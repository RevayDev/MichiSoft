package com.michiStudios.michisoft.database;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBase {
    //Point User
    public int sucursal_point;
    // Sucursales
    public ArrayList<String> sucursales;

    // Administradores
    public ArrayList<String> administrador;
    public ArrayList<String> id_ad;
    public ArrayList<String> correo_ad;
    public ArrayList<String> pass_ad;

    // Vendedores
    public ArrayList<String> vendedor;
    public ArrayList<String> id_ve;
    public ArrayList<String> correo_ve;
    public ArrayList<String> pass_ve;
    
    //ID de vendedores y administradores por sucursales
    public ArrayList<Integer> sucursal_ad;
    public ArrayList<Integer> sucursal_ve;
    
    // Productos
    public ArrayList<String> pieza_id;
    public ArrayList<String> pieza_name;
    public ArrayList<Double> pieza_price;

    // Existencias por sucursal y producto
    public ArrayList<ArrayList<Integer>> ex;


    public DataBase() {
        sucursales = new ArrayList<>();

        administrador = new ArrayList<>();
        id_ad = new ArrayList<>();
        correo_ad = new ArrayList<>();
        pass_ad = new ArrayList<>();

        vendedor = new ArrayList<>();
        id_ve = new ArrayList<>();
        correo_ve = new ArrayList<>();
        pass_ve = new ArrayList<>();
        
        sucursal_ad = new ArrayList<>();
        sucursal_ve = new ArrayList<>();
        
        pieza_id = new ArrayList<>();
        pieza_name = new ArrayList<>();
        pieza_price = new ArrayList<>();

        ex = new ArrayList<>();
    }

    // Agregar sucursal
    public void agregarSucursal(String nombre) {
        sucursales.add(nombre);

        ArrayList<Integer> existenciasSucursal = new ArrayList<>();
        for (int i = 0; i < pieza_id.size(); i++) {
            existenciasSucursal.add(0);
        }
        ex.add(existenciasSucursal);
    }

    // Agregar producto
    public void agregarProducto(String id, String nombre, double precio) {
        pieza_id.add(id);
        pieza_name.add(nombre);
        pieza_price.add(precio);
        
        for (int i = 0; i < ex.size(); i++) {
            ex.get(i).add(0);
        }
    }

    // Actualizar existencia
    public void actualizarExistencia(int sucursalIndex, int productoIndex, int cantidad) {
        if (sucursalIndex >= 0 && sucursalIndex < ex.size() &&
            productoIndex >= 0 && productoIndex < pieza_id.size()) {
            ex.get(sucursalIndex).set(productoIndex, cantidad);
        }
    }

    // Agregar administrador
    public void agregarAdministrador(String nombre, String id, String correo, String password, int sucursalIndex) {
        administrador.add(nombre);
        id_ad.add(id);
        correo_ad.add(correo);
        pass_ad.add(password);
        sucursal_ad.add(sucursalIndex);
    }

    // Agregar vendedor
    public void agregarVendedor(String nombre, String id, String correo, String password, int sucursalIndex) {
        vendedor.add(nombre);
        id_ve.add(id);
        correo_ve.add(correo);
        pass_ve.add(password);
        sucursal_ve.add(sucursalIndex);
    }
    
    //De samuel
    // Busca índice de producto por nombre (case-insensitive)
    private int indexProductoPorNombre(String nombre) {
        for (int i = 0; i < pieza_name.size(); i++) {
            if (pieza_name.get(i).equalsIgnoreCase(nombre)) return i;
        }
        return -1;
    }

    // Devuelve "cantidad,precio" del producto en la sucursal actual (sucursal_point)
    public String obtenerDato(String productoNombre) {
        int pIdx = indexProductoPorNombre(productoNombre);
        if (pIdx < 0) return "0,0.0";

        int suc = (sucursal_point >= 0 && sucursal_point < ex.size()) ? sucursal_point : 0;
        // Si aún no hay existencias cargadas para la sucursal, asumimos 0
        int cantidad = (ex.isEmpty() || ex.get(suc).isEmpty()) ? 0 : ex.get(suc).get(pIdx);
        double precio = pieza_price.get(pIdx);

        return cantidad + "," + precio;
    }

    // Guarda "cantidad,precio" para el producto en la sucursal actual.
    // Si solo pasas "cantidad", actualiza solo existencias.
    public void guardarDato(String productoNombre, String value) {
        int pIdx = indexProductoPorNombre(productoNombre);
        if (pIdx < 0) return; // no existe el producto

        String[] parts = value.split(",");
        if (parts.length == 0) return;

        int nuevaCantidad = Integer.parseInt(parts[0].trim());
        Integer suc = (sucursal_point >= 0 && sucursal_point < ex.size()) ? sucursal_point : 0;

        // Asegura que la lista de existencias de la sucursal tenga tamaño correcto
        if (ex.isEmpty()) return; // no hay sucursales aún
        if (ex.get(suc).size() < pieza_id.size()) {
            // Rellena faltantes con 0 por seguridad
            while (ex.get(suc).size() < pieza_id.size()) ex.get(suc).add(0);
        }
        ex.get(suc).set(pIdx, nuevaCantidad);

        if (parts.length >= 2) {
            double nuevoPrecio = Double.parseDouble(parts[1].trim());
            pieza_price.set(pIdx, nuevoPrecio);
        }
    }

    // Mapa nombreDePieza -> "cantidad,precio" para la sucursal actual
    public Map<String, String> obtenerTodos() {
        Map<String, String> res = new LinkedHashMap<>();
        if (pieza_name.isEmpty()) return res;

        int suc = (sucursal_point >= 0 && sucursal_point < ex.size()) ? sucursal_point : 0;
        if (ex.isEmpty() || suc >= ex.size()) return res;

        // Garantiza tamaños
        if (ex.get(suc).size() < pieza_id.size()) {
            while (ex.get(suc).size() < pieza_id.size()) ex.get(suc).add(0);
        }

        for (int i = 0; i < pieza_name.size(); i++) {
            int cantidad = ex.get(suc).get(i);
            double precio = pieza_price.get(i);
            res.put(pieza_name.get(i), cantidad + "," + precio);
        }
        return res;
    }
}
