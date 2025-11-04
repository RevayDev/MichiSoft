
package com.michiStudios.michisoft.Model;

//Importacion de la DB
import com.michiStudios.michisoft.database.DataBase;

//Paquetes adicionales
import java.util.ArrayList;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelAdminModel {
    private DataBase db;
    
    public  panelAdminModel(DataBase db){
       this.db = db;
    
    }
    
    //Selectores
    //Cargador de Sucursales de los selecores
    public String[] ReloadDataSucursal() {
        return db.sucursales.toArray(new String[0]);
    }
    
    //Cargador de las Piezas
    public ArrayList<ArrayList<String>> ReloadDataItems() {
        ArrayList<String> ids = db.pieza_name;
        ArrayList<String> name = db.pieza_id;
        ArrayList<ArrayList<String>> Dato = new ArrayList<>();
        Dato.add(name);
        Dato.add(ids);
        
        return Dato;
    }
   
    //Sucursal
    public boolean AgregarSucursal(String NombreSucursal){
        for(int i = 0; i < db.sucursales.size(); i++){
            if(db.sucursales.get(i).toLowerCase().equals(NombreSucursal.toLowerCase()))  
                return false;  
        }
        db.sucursales.add(NombreSucursal.toUpperCase());
    

        ArrayList<Integer> existenciasSucursal = new ArrayList<>();
        for (int i = 0; i < db.pieza_id.size(); i++) {
            existenciasSucursal.add(0);
        }
        db.ex.add(existenciasSucursal);
  
        return true;
    }

    // Editar una sucursal
    public boolean EditSucursal(String NombreSucursal, String NewNombreSucursal){
      for(int i =  0; i < db.sucursales.size(); i++){
          if(db.sucursales.get(i).equalsIgnoreCase(NombreSucursal)){
            int index = i;
            db.sucursales.set(index, NewNombreSucursal.toUpperCase());
            return true;
          };
      }
     
      return false;
    }
    
    // Eliminar una sucursal
    public boolean DeleteSucursal(String nombreSucursal) {
        for (int i = 0; i < db.sucursales.size(); i++) {
            if (db.sucursales.get(i).equalsIgnoreCase(nombreSucursal)) {
                int index = i;

                db.sucursales.remove(index);

                if (index < db.ex.size()) {
                    db.ex.remove(index);
                }
                
                // Remover los Admins
                for (int j = db.sucursal_ad.size() - 1; j >= 0; j--) {
                    if (db.sucursal_ad.get(j) == index) {
                        db.id_ad.remove(j);
                        db.correo_ad.remove(j);
                        db.pass_ad.remove(j);
                        db.administrador.remove(j);
                        db.sucursal_ad.remove(j);
                    }
                }
                for (int j = 0; j < db.sucursal_ad.size(); j++) {
                    if (db.sucursal_ad.get(j) > index) {
                        db.sucursal_ad.set(j, db.sucursal_ad.get(j) - 1);
                    }
                }
                
                // Remover los vendedores
                for (int j = db.sucursal_ve.size() - 1; j >= 0; j--) {
                    if (db.sucursal_ve.get(j) == index) {
                        db.id_ve.remove(j);
                        db.correo_ve.remove(j);
                        db.pass_ve.remove(j);
                        db.vendedor.remove(j);
                        db.sucursal_ve.remove(j);
                    }
                }
                for (int j = 0; j < db.sucursal_ve.size(); j++) {
                    if (db.sucursal_ve.get(j) > index) { 
                        db.sucursal_ve.set(j, db.sucursal_ve.get(j) - 1);
                    }
                }

                return true;
            }
        }
        return false;
    }

    // Informacion de sucursales
    public int[] GetInfoSucursal(String NombreSucursal){
      for(int i =  0; i < db.sucursales.size(); i++){
          if(db.sucursales.get(i).toLowerCase().equalsIgnoreCase(NombreSucursal)){
              int index = i;
              int count_ad = 0, count_ve = 0, count_pieza = 0;
              ArrayList<Integer> inventarioSucursal = db.ex.get(index);
            
              // Contador de Administradores
              for(int a = 0; a < db.sucursal_ad.size(); a++){
                  if(index == db.sucursal_ad.get(a)) count_ad++;  
              }
        
              // Contador de Vendedores
              for(int v = 0; v < db.sucursal_ve.size(); v++){
                  if(index == db.sucursal_ve.get(v)) count_ve++;  
              }
            
              // Contador de Piezas
              for (int p = 0; p < inventarioSucursal.size(); p++) {
                  int cantidad = inventarioSucursal.get(p);
                  if (cantidad > 0){
                      count_pieza ++;
                  }
              }
              return new int[]{count_ad, count_ve, count_pieza};
          }
      }
      return new int[]{0,0,0};
    }
    
    /*
    * @author ALEJANDRA BOLIVARES
    */
    
    // Reporte de máximos y mínimos por sucursal
    public String[] MaxAndMinPiezas(String sucursal) {
        int indexSucursal = db.sucursales.indexOf(sucursal);
        ArrayList<Integer> piezasSucursal = db.ex.get(indexSucursal);

        int maxCantidad = Integer.MIN_VALUE;
        int minCantidad = Integer.MAX_VALUE;
        int indexMaxPieza = -1;
        int indexMinPieza = -1;

        for (int i = 0; i < piezasSucursal.size(); i++) {
            int cantidad = piezasSucursal.get(i);
            if (cantidad > maxCantidad) {
                maxCantidad = cantidad;
                indexMaxPieza = i;
            }
            if (cantidad < minCantidad) {   
                minCantidad = cantidad;
                indexMinPieza = i;
            }
        }

        return new String[]{ db.pieza_name.get(indexMaxPieza), String.valueOf(maxCantidad), db.pieza_name.get(indexMinPieza), String.valueOf(minCantidad)};
    }

    // Inventario por sucursal
    public ArrayList<ArrayList<String>> getInventarioSucursal(String nombreSucursal) {
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        ArrayList<String> nombresProductos = new ArrayList<>();
        ArrayList<String> cantidadesProductos = new ArrayList<>();

        int index = db.sucursales.indexOf(nombreSucursal);
        if (index < 0) {
            resultado.add(nombresProductos);
            resultado.add(cantidadesProductos);
            return resultado; 
        }

        ArrayList<Integer> inventarioSucursal = db.ex.get(index);
        for (int p = 0; p < Math.min(db.pieza_name.size(), inventarioSucursal.size()); p++) {
            nombresProductos.add(db.pieza_id.get(p) + " - " + db.pieza_name.get(p));
            if (inventarioSucursal.get(p) > 0) {
                cantidadesProductos.add(String.valueOf(inventarioSucursal.get(p)));
            }
        }

        resultado.add(nombresProductos);
        resultado.add(cantidadesProductos);
        return resultado;
    }

    // Buscar Pieza Por ID
    public ArrayList<ArrayList<String>> getPiezaID(String NombrePieza) {
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        ArrayList<String> sucursalesConStock = new ArrayList<>();
        ArrayList<String> cantidades = new ArrayList<>();

        String nombreBuscado = NombrePieza;
        int indice = NombrePieza.indexOf('-');
        if (indice != -1) {
            nombreBuscado = NombrePieza.substring(indice + 1).trim();
        }

        int productoIndex = -1;
        for (int i = 0; i < db.pieza_name.size(); i++) {
            if (db.pieza_name.get(i).equalsIgnoreCase(nombreBuscado)) {
                productoIndex = i;
                break;
            }
        }
        if (productoIndex < 0) {
            resultado.add(sucursalesConStock);
            resultado.add(cantidades);
            return resultado; 
        }

        for (int sucursalIdx = 0; sucursalIdx < db.sucursales.size(); sucursalIdx++) {
            ArrayList<Integer> inventario = db.ex.get(sucursalIdx);
            if (productoIndex < inventario.size()) {
                int cantidad = inventario.get(productoIndex);
                if (cantidad > 0) {
                    sucursalesConStock.add(db.sucursales.get(sucursalIdx));
                    cantidades.add(String.valueOf(cantidad));
                }
            }
        }

        resultado.add(sucursalesConStock);
        resultado.add(cantidades);
        return resultado;
    }

    /*
     * @author ESTEBAN JAIMES
    */
    
    // Agregar una nueva pieza
    public boolean AgregarPieza(String codigo, String nombre, double precio, String sucursal, int cantidad) {
        for (String id : db.pieza_id) {
            if (id.equals(codigo)) return false;
        }
        
        if(codigo.length() - 1 == 8) return  false;
        db.pieza_id.add(codigo);
        db.pieza_name.add(nombre);
        db.pieza_price.add(precio);
   
        for (int i = 0; i < db.ex.size(); i++) {
            db.ex.get(i).add(0);
        }
    
        int productoIndex = db.pieza_id.size() - 1;
        if (sucursal.equals("TODAS")) {
            for (int i = 0; i < db.sucursales.size(); i++) {
                 db.ex.get(i).set(productoIndex, cantidad);
           }
        } else {
            for (int i = 0; i < db.sucursales.size(); i++) {
                 if (db.sucursales.get(i).equalsIgnoreCase(sucursal)) {
                     db.ex.get(i).set(productoIndex, cantidad);
                      break;
                 }
            }
        }
    
       return true;
    }

    // Editar una pieza existente
    public boolean EditarPieza(String codigo, String nuevoNombre, double nuevoPrecio, String sucursal, int nuevaCantidad) {
        int productoIndex = -1;
        for (int i = 0; i < db.pieza_id.size(); i++) {
            if (db.pieza_id.get(i).equalsIgnoreCase(codigo)) {
                productoIndex = i;
                break;
            }
        }
        
        if (productoIndex < 0) return false;


        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            db.pieza_name.set(productoIndex, nuevoNombre);
        }

        if (nuevoPrecio >= 0) {
        db.pieza_price.set(productoIndex, nuevoPrecio);
    
        }

        if (sucursal.equalsIgnoreCase("TODAS")) {  
            for (int i = 0; i < db.sucursales.size(); i++) {
                db.ex.get(i).set(productoIndex, nuevaCantidad);
            }
            
        } else {
            boolean encontrada = false;
            for (int i = 0; i < db.sucursales.size(); i++) {
                if (db.sucursales.get(i).equalsIgnoreCase(sucursal)) {
                    db.ex.get(i).set(productoIndex, nuevaCantidad);
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) return false; 
        }
        return true;
    }


    // Obtener todas las pizas
    public ArrayList<ArrayList<String>> GetInfoPiezas() {
        ArrayList<ArrayList<String>> info = new ArrayList<>();

        for (int productoIndex = 0; productoIndex < db.pieza_id.size(); productoIndex++) {
            String id = db.pieza_id.get(productoIndex);
            String nombre = db.pieza_name.get(productoIndex);
            String precio = String.valueOf(db.pieza_price.get(productoIndex));

            for (int sucursalIndex = 0; sucursalIndex < db.sucursales.size(); sucursalIndex++) {
                int cantidad = db.ex.get(sucursalIndex).get(productoIndex);

                ArrayList<String> fila = new ArrayList<>();
                fila.add(id);                         
                fila.add(nombre);                     
                fila.add(precio);                      
                fila.add(String.valueOf(cantidad));   
                fila.add(db.sucursales.get(sucursalIndex)); 

                info.add(fila);
      
            }
        }

        return info;
    }

    // Eliminar pieza de una sucursal o de todas
    public boolean EliminarPieza(String codigo, String sucursal) {
        int productoIndex = -1;

        for (int i = 0; i < db.pieza_id.size(); i++) {
            if (db.pieza_id.get(i).equalsIgnoreCase(codigo)) {
            productoIndex = i;
            break;
            }
        }

        if (productoIndex < 0) return false;

        if (sucursal.equalsIgnoreCase("TODAS")) {
            db.pieza_id.remove(productoIndex);
            db.pieza_name.remove(productoIndex);
            db.pieza_price.remove(productoIndex);

            for (int i = 0; i < db.sucursales.size(); i++) {
                db.ex.get(i).remove(productoIndex);
            }
   
        } else {
            for (int i = 0; i < db.sucursales.size(); i++) {
                if (db.sucursales.get(i).equalsIgnoreCase(sucursal)) {
                    db.ex.get(i).set(productoIndex, 0);
                    break;
                }
            }
        }

        return true;
    }

    /*
    * @author SAMUEL CASTRO
    */
    
    // Crear ususario
    public Object[] AddUsuario(String nombre, String id, String correo, char[] password, String sucursal, String rol) {
        String pass = new String(password);
        int sucursalIdx = -1;
        
        if(id.length() != 10) return  new Object[]{false, "La ID debe ser minimo de 10 caracteres"};
        
        Object[] res = validarPassword(pass);
        if (!(boolean) res[0]){
            return  new Object[]{false, (String) res[1]};
        }
        
        if (!correo.endsWith("@michisoft.co")) {
            return new Object[]{false, "El correo debe terminar en el dominio de la empresa (@michisoft.co)"};
        }
        
        for(int s = 0; s < db.sucursales.size(); s++){
            if(db.sucursales.get(s).equalsIgnoreCase(sucursal)){
                sucursalIdx = s;
            }
        }
       
        if (rol.equalsIgnoreCase("Administrador")) {
            for (int i = 0; i < db.id_ad.size(); i++) {
                if (db.id_ad.get(i).equals(id) || db.correo_ad.get(i).equalsIgnoreCase(correo)) {
                    return  new Object[]{false, "Usuario ya exitente"};
                }
            }
            
            db.administrador.add(nombre);
            db.id_ad.add(id);
            db.correo_ad.add(correo);
            db.pass_ad.add(pass);
            db.sucursal_ad.add(sucursalIdx);
            return  new Object[]{true, "Usuario creado con exito (nuevo administrador)"};
  
        }

    
        if (rol.equalsIgnoreCase("Vendedor")) {
            for (int i = 0; i < db.id_ve.size(); i++) {
                if (db.id_ve.get(i).equals(id) || db.correo_ve.get(i).equalsIgnoreCase(correo)) {
                     return  new Object[]{false, "Usuario ya exitente"};
                }
            }
      
            db.vendedor.add(nombre);
            db.id_ve.add(id);    
            db.correo_ve.add(correo);
            db.pass_ve.add(pass);
            db.sucursal_ve.add(sucursalIdx);
            return  new Object[]{true, "Usuario creado con exito (nuevo vendedor)"};
        }
        
       return  new Object[]{false, "Error al registar usuario campos requeridos"};
    }

    // Editar usuario
    public boolean EditUsuario(String id, String nuevoNombre, String sucursal, String rol) {
        
        int sucursalIdx = -1;
        for(int s = 0; s < db.sucursales.size(); s++){
            if(db.sucursales.get(s).equalsIgnoreCase(sucursal)){
                sucursalIdx = s;
            }
        }
        if (rol.equalsIgnoreCase("Administrador")) {
            for (int i = 0; i < db.id_ad.size(); i++) {
                if (db.id_ad.get(i).equals(id)) {
                    db.administrador.set(i, nuevoNombre);
                    db.sucursal_ad.set(i, sucursalIdx);
                    return true;
                }
            }
        }

        if (rol.equalsIgnoreCase("Vendedor")) {
            for (int i = 0; i < db.id_ve.size(); i++) {
                if (db.id_ve.get(i).equals(id)) {
                    db.vendedor.set(i, nuevoNombre);
                    db.sucursal_ve.set(i, sucursalIdx);
                    return true;
                }
            }
        }

        return false; 
    }

    // Eliminar usuario
    public boolean DeleteUsuario(String id, String rol) {
        if (rol.equalsIgnoreCase("Administrador")) {
            for (int i = 0; i < db.id_ad.size(); i++) {
                if (db.id_ad.get(i).equals(id)) {
                    db.id_ad.remove(i);
                    db.administrador.remove(i);
                    db.correo_ad.remove(i);
                    db.pass_ad.remove(i);
                    db.sucursal_ad.remove(i);
                    return true;
                }
            }
        }

        if (rol.equalsIgnoreCase("Vendedor")) {
            for (int i = 0; i < db.id_ve.size(); i++) {
                if (db.id_ve.get(i).equals(id)) {
                    db.id_ve.remove(i);
                    db.vendedor.remove(i);
                    db.correo_ve.remove(i);
                    db.pass_ve.remove(i);
                    db.sucursal_ve.remove(i);
                    return true;
                }
            }
        }

        return false; 
    }
    
    /*
     * @author ROBERTO JIMENEZ
    */
    
    // Verificador Password
    public Object[] validarPassword(String password){
        boolean numCaracteres = password.length() >= 4 && password.length() >= 8;
        boolean mayus = false;
        boolean minus = false;
        boolean nums = false;
        boolean especiales = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) mayus = true;
            else if (Character.isLowerCase(c)) minus = true;
            else if (Character.isDigit(c)) nums = true;
            else especiales = true; // cualquier otro carácter lo consideramos especial
        }

        if (!numCaracteres) return new Object[]{false, "La contraseña debe tener entre 4 o mayor de 8 caracteres."};
        if (!mayus) return new Object[]{false, "La contraseña debe tener mínimo una mayúscula."};
        if (!minus) return new Object[]{false, "La contraseña debe tener mínimo una minúscula."};
        if (!nums) return new Object[]{false, "La contraseña debe tener mínimo un número."};
        if (!especiales) return new Object[]{false, "La contraseña debe tener mínimo un carácter especial."}; 
        
        return new Object[]{true, null}; 

    }

    // Obtener todos los usuarios
    public ArrayList<ArrayList<String>> GetUsuarios() {
        ArrayList<ArrayList<String>> info = new ArrayList<>();
        
        for (int a = 0; a < db.administrador.size(); a++) {
             ArrayList<String> fila = new ArrayList<>();
             fila.add(db.id_ad.get(a));
             fila.add(db.administrador.get(a));
             fila.add(db.sucursales.get(db.sucursal_ad.get(a)));
             fila.add("Administrador");
             info.add(fila); 
        }

   
        for (int v = 0; v < db.vendedor.size(); v++) {
             ArrayList<String> fila = new ArrayList<>();
             fila.add(db.id_ve.get(v));
             fila.add(db.vendedor.get(v));
             fila.add(db.sucursales.get(db.sucursal_ve.get(v)));
             fila.add("Vendedor");
             info.add(fila);
        }

        return info;
    }

}