package com.michiStudios.michisoft.Model;

// Importacion de la DB
import com.michiStudios.michisoft.database.DataBase;
import com.michiStudios.michisoft.database.FileManage.MainFileManager;

//Importaciones adicionales
import java.util.ArrayList;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/*
 * @author ROBERTO JIMENEZ
 */

public class panelVendedorModel {
    private DataBase db;
    private MainFileManager fm;
    private static int numFactura = 1;
    private static final String FACTURA_KEY = "SISTEMA_ULTIMA_FACTURA";
    
    public panelVendedorModel(DataBase db, MainFileManager fm){
        this.fm = fm;
        this.db = db;
        // CARGAR DATOS DESDE ARCHIVO
        cargarDatosDesdeArchivo();
        inicializarNumeroFactura();
    }
   
    // Pieza agotandoce
    public ArrayList<ArrayList<String>> getPiezaAgotada() {
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        ArrayList<String> nombresProductos = new ArrayList<>();
        ArrayList<String> cantidadesProductos = new ArrayList<>();

        int index = db.sucursal_point;
        if (index < 0) {
            resultado.add(nombresProductos);
            resultado.add(cantidadesProductos);
            return resultado; 
        }

        ArrayList<Integer> inventarioSucursal = db.ex.get(index);
        for (int p = 0; p < db.pieza_name.size(); p++) {
            int cantidad = inventarioSucursal.get(p);
            if (cantidad > 0 && cantidad < 30) {
                nombresProductos.add(db.pieza_id.get(p) + " - " + db.pieza_name.get(p));
                cantidadesProductos.add(String.valueOf(cantidad));
            }
        }

        resultado.add(nombresProductos);
        resultado.add(cantidadesProductos);
        return resultado;
    }
    
    // Reumen globales
    public String[] getInfoResume() {
    
        int index = db.sucursal_point;
        int count_pieza = 0;
        int count_clients = 0; 
        double neto_pieza = 0;
   
        ArrayList<Integer> inventarioSucursal = db.ex.get(index);

        for (int i = 0; i < inventarioSucursal.size(); i++) {
            int cantidad = inventarioSucursal.get(i);
            if (cantidad > 0) {
                count_pieza ++;
                neto_pieza += cantidad * db.pieza_price.get(i); 
            }
        }
        return new String[] {db.sucursales.get(index), ("" + count_pieza), ("" + count_clients), ("" + neto_pieza)};
    }
    
   /*
    * @author ALEJANDRA BOLIVARES
   */
    
    // Inventario por sucursal
    public Object[] getInventarioSucursal() {
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        ArrayList<String> idProductos = new ArrayList<>();
        ArrayList<String> nombresProductos = new ArrayList<>();
        ArrayList<String> cantidadesProductos = new ArrayList<>();
        ArrayList<String> valorProductos = new ArrayList<>();
        int index = db.sucursal_point;

        if (index < 0 || index >= db.sucursales.size()) {
            
            resultado.add(idProductos);       
            resultado.add(nombresProductos);  
            resultado.add(cantidadesProductos); 
            resultado.add(valorProductos);    

            // Retornar nombre de sucursal por defecto o vacío
            String sucursalName = (index >= 0 && index < db.sucursales.size()) ? 
                                 db.sucursales.get(index) : "Sucursal no seleccionada";
            return new Object[] {resultado, sucursalName}; 
        }

        // Procesar inventario normal
        ArrayList<Integer> inventarioSucursal = db.ex.get(index);
        for (int p = 0; p < Math.min(db.pieza_name.size(), inventarioSucursal.size()); p++) {
            idProductos.add(db.pieza_id.get(p));
            nombresProductos.add(db.pieza_name.get(p));
            valorProductos.add("" + db.pieza_price.get(p));

            if (inventarioSucursal.get(p) > 0) {
                cantidadesProductos.add(("" + inventarioSucursal.get(p)));
            } else {
                cantidadesProductos.add("0"); 
            }
        }

        resultado.add(idProductos);
        resultado.add(nombresProductos);
        resultado.add(cantidadesProductos);
        resultado.add(valorProductos);
        return new Object[] {resultado, db.sucursales.get(index)};
    }
    
    // Obtener todos los usuarios
    public Object[] GetEquipo() {
    ArrayList<ArrayList<String>> info = new ArrayList<>();
    
    // Validar que sucursal_point es válido
    if (db.sucursal_point < 0 || db.sucursal_point >= db.sucursales.size()) {
        return new Object[] {info, "Sucursal no seleccionada"};
    }
    
    // Agregar administradores
    for (int a = 0; a < db.administrador.size(); a++) {
        if (a < db.sucursal_ad.size() && db.sucursal_ad.get(a) == db.sucursal_point) {
            ArrayList<String> fila = new ArrayList<>();
            fila.add(db.id_ad.get(a));
            fila.add(db.administrador.get(a));
            fila.add("Administrador");
            info.add(fila); 
        }
    }

    // Agregar vendedores - con validación de límites
    int maxVendedores = Math.min(db.vendedor.size(), db.sucursal_ad.size());
    for (int v = 0; v < maxVendedores; v++) {
        if (db.sucursal_ad.get(v) == db.sucursal_point) {
            ArrayList<String> fila = new ArrayList<>();
            fila.add(db.id_ve.get(v));
            fila.add(db.vendedor.get(v));
            fila.add("Vendedor");
            info.add(fila);
        }
    }
    
    return new Object[] {info, db.sucursales.get(db.sucursal_point)};
}
    
    /*
    * @author SAMUEL CASTRO
    */
     
    
    /**
     * Carga los datos desde el archivo Registro.txt usando FileManager
     */
    private void cargarDatosDesdeArchivo() {
        try {
            fm.cargar(db);
            
            if (db.sucursal_point < 0 && !db.sucursales.isEmpty()) {
                db.sucursal_point = 0; 
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    private int obtenerUltimaFacturaDeDirectorio() {
        File dir = new File("src/main/java/com/michiStudios/Factures");
        if (!dir.exists() || !dir.isDirectory()) {
            return 0;
        }
        
        int maxNumero = 0;
        File[] archivos = dir.listFiles((d, name) -> name.startsWith("Factura_") && name.endsWith(".txt"));
        
        if (archivos != null) {
            for (File archivo : archivos) {
                try {
                    String nombre = archivo.getName();
                    
                    String numeroStr = nombre.substring(8, nombre.length() - 4);
                    int numero = Integer.parseInt(numeroStr);
                    maxNumero = Math.max(maxNumero, numero);
                } catch (Exception e) {
                   
                    System.err.println("Archivo de factura con formato incorrecto: " + archivo.getName());
                }
            }
        }
        
        return maxNumero;
    }
    
    /**
     * Busca el número de la última factura en la base de datos
     */
    private String buscarUltimaFacturaEnDB() {
        try {
            // Usar el método obtenerTodos y buscar nuestra clave especial
            Map<String, String> todos = db.obtenerTodos();
            for (String key : todos.keySet()) {
                if (key.equals(FACTURA_KEY)) {
                    String valor = todos.get(key);
                    
                    return valor.split(",")[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Guarda el número de factura actual en la base de datos
     */
    private void guardarNumeroFacturaEnDB(int numeroFactura) {
        try {
            db.guardarDato(FACTURA_KEY, numeroFactura + ",0");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //PanelRegistrarCompras
    // Inicializa el número de factura buscando en la carpeta Factures
    private void inicializarNumeroFactura() {
        try {
            
            String ultimaFacturaStr = buscarUltimaFacturaEnDB();
            
            if (ultimaFacturaStr != null) {
                numFactura = Integer.parseInt(ultimaFacturaStr) + 1;
              
                return;
            }
            
            int ultimaFacturaDirectorio = obtenerUltimaFacturaDeDirectorio();
            if (ultimaFacturaDirectorio > 0) {
                numFactura = ultimaFacturaDirectorio + 1;
              
               
                guardarNumeroFacturaEnDB(ultimaFacturaDirectorio);
            } else {
                numFactura = 1;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            numFactura = 1;
        }
    }

    // Procesar venta
    public String procesarVenta(String producto, String cantidadText, String nombre,
                                String documento, String telefono, String direccion) {

        if (producto == null || producto.trim().isEmpty()) return "Seleccione un producto";
        if (cantidadText == null || cantidadText.trim().isEmpty()) return "Ingrese cantidad";
        if (nombre == null || nombre.trim().isEmpty()) return "Ingrese nombre del cliente";
        if (documento == null || documento.trim().isEmpty()) return "Ingrese documento del cliente";
        
        // Validar formato de documento (solo números)
        if (!documento.matches("\\d+")) return "El documento debe contener solo números";
        if (documento.length() < 6 || documento.length() > 12) return "El documento debe tener entre 6 y 12 dígitos";

        // Validar teléfono si no está vacío
        if (telefono != null && !telefono.trim().isEmpty()) {
            if (!telefono.matches("\\d+")) return "El teléfono debe contener solo números";
            if (telefono.length() < 7 || telefono.length() > 15) return "El teléfono debe tener entre 7 y 15 dígitos";
        }

        // Validar nombre (no debe contener números)
        if (nombre.matches(".*\\d.*")) return "El nombre no debe contener números";
        if (nombre.length() < 2) return "El nombre debe tener al menos 2 caracteres";

        int cantidad;
        try { cantidad = Integer.parseInt(cantidadText); }
        catch (NumberFormatException e) { return "Cantidad inválida"; }

        if (cantidad <= 0) return "La cantidad debe ser mayor a 0";
        if (cantidad > 1000) return "La cantidad no puede ser mayor a 1000 unidades";

        try {
            String[] datos = db.obtenerDato(producto).split(",");
            int stock = Integer.parseInt(datos[0]);
            double precio = Double.parseDouble(datos[1]);

            if (cantidad > stock) return "Stock insuficiente. Disponible: " + stock;
            // Validar que el precio sea razonable
            if (precio <= 0) return "Error: Precio inválido del producto";
            if (precio > 1000000) return "Error: Precio del producto demasiado alto";

            // Validar que el total no exceda un límite razonable
            double total = cantidad * precio;
            if (total > 10000000) return "El total de la venta excede el límite permitido";
            // Después de: if (documento == null || documento.trim().isEmpty()) return "Ingrese documento del cliente";
            String errorValidacion = validarDatosCliente(nombre, documento, telefono, direccion);
            if (errorValidacion != null) return errorValidacion;

            db.guardarDato(producto, (stock - cantidad) + "," + precio);
           

            String facturaTxt = generarFactura(producto, cantidad, precio, total, nombre, documento, telefono, direccion);
            guardarFactura(facturaTxt);

            return "SUCCESS:" + facturaTxt;

        } catch (Exception e) {
            return "Error al procesar la venta";
        }
    }
    
    //GenerarFactura
    private String generarFactura(String producto, int cantidad, double precio, double total,
                                  String cliente, String documento, String telefono, String direccion) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = dtf.format(LocalDateTime.now());

        return "================= FACTURA =================\n"
                + "Factura No: " + numFactura + "\n"
                + "Fecha: " + fecha + "\n"
                + "-------------------------------------------\n"
                + "Cliente: " + cliente + "\n"
                + "Documento: " + documento + "\n"
                + "Telefono: " + telefono + "\n"
                + "Direccion: " + direccion + "\n"
                + "-------------------------------------------\n"
                + "Producto: " + producto + "\n"
                + "Cantidad: " + cantidad + "\n"
                + "Precio Unitario: $" + String.format("%.0f", precio) + "\n"
                + "-------------------------------------------\n"
                + "TOTAL: $" + String.format("%.0f", total) + "\n"
                + "===========================================";
    }
    
    //Guardar Factura
    private void guardarFactura(String facturaTxt) {
        File dir = new File("src/main/java/com/michiStudios/Factures");
        if (!dir.exists()) dir.mkdirs();

        File file = new File(dir, "Factura_" + numFactura + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(facturaTxt);
            numFactura++; 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Ultima factura
    public static int getNumFactura() { return numFactura; }
    
    /**
     * Obtiene todos los productos disponibles
     * @return Map con los productos y sus datos (excluyendo datos del sistema)
     */
    public Map<String, String> obtenerProductos() {
        try {
            Map<String, String> todos = db.obtenerTodos();
            todos.remove(FACTURA_KEY);
            return todos;
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of();
        }
    }
    
    /**
     * Busca en el directorio de facturas el último número usado
     */
    
    
    /**
     * Obtiene información detallada de un producto específico
     * @param producto Nombre del producto
     * @return String con la información del producto
     */
    public String obtenerInformacionProducto(String producto) {
        if (producto == null || producto.trim().isEmpty()) {
            return "Seleccione un producto";
        }
        
        // Ignorar si es nuestra clave del sistema
        if (producto.equals(FACTURA_KEY)) {
            return "Seleccione un producto";
        }
        
        try {
            String[] datos = db.obtenerDato(producto).split(",");
            int cantidad = Integer.parseInt(datos[0]);
            double precio = Double.parseDouble(datos[1]);
            return "Cantidad Disponible: " + cantidad + " || Precio: $" + String.valueOf(precio);
        } catch (Exception e) {
            return "Error al obtener información del producto";
        }
    }
    /**
 * Valida los datos del cliente antes de procesar la venta
 */
    private String validarDatosCliente(String nombre, String documento, String telefono, String direccion) {
        // Validar caracteres especiales en nombre
        if (nombre.matches(".*[<>\"'&].*")) return "El nombre contiene caracteres no válidos";

        // Validar que el documento no tenga patrones sospechosos
        if (documento.equals("0000000000") || documento.matches("(.)\\1{5,}")) {
            return "Documento inválido";
        }

        // Validar dirección si no está vacía
        if (direccion != null && !direccion.trim().isEmpty()) {
            if (direccion.length() > 100) return "La dirección es demasiado larga";
            if (direccion.matches(".*[<>\"'&].*")) return "La dirección contiene caracteres no válidos";
        }

        return null; // Sin errores
    }
}
    

