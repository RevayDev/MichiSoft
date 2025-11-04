package com.michiStudios.michisoft.database.FileManage;

import com.michiStudios.michisoft.database.DataBase;
import java.util.ArrayList;

/**
 * Parser simple para convertir líneas del Registro.txt en estructuras de DataBase.
 * No hace IO; solo valida/convierte y llama a los métodos de DataBase.
 */
public class Parser {

    public void parseSucursal(String linea, DataBase db) {
        String s = linea.trim();
        if (s.isEmpty()) return;
      
        db.agregarSucursal(s);
    }

    public void parseAdmin(String linea, DataBase db) {
       
        String[] p = linea.split("\\|");
        if (p.length < 5) {
            
            return;
        }
        int suc = parseIntSafe(p[4], 0);
        db.agregarAdministrador(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim(), suc);
    }

    public void parseVendedor(String linea, DataBase db) {
        
        String[] p = linea.split("\\|");
        if (p.length < 5) {
           
            return;
        }
        int suc = parseIntSafe(p[4], 0);
        db.agregarVendedor(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim(), suc);
    }

    public void parseProducto(String linea, DataBase db) {
       
        String[] p = linea.split("\\|");
        if (p.length < 3) {
            
            return;
        }
        double precio = parseDoubleSafe(p[2], 0.0);
        db.agregarProducto(p[0].trim(), p[1].trim(), precio);
    }

    public void parseExistencias(String linea, DataBase db) {
    
        String[] parts = linea.split(":");
        if (parts.length != 2) {
            
            return;
        }
        int sucIndex = parseIntSafe(parts[0], -1);
        if (sucIndex < 0 || sucIndex >= db.sucursales.size()) {
            
            return;
        }

        String[] cantidades = parts[1].split(",");
   
        while (db.ex.size() <= sucIndex) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int i = 0; i < db.pieza_id.size(); i++) fila.add(0);
            db.ex.add(fila);
        }
        ArrayList<Integer> fila = db.ex.get(sucIndex);

        for (int i = 0; i < db.pieza_id.size(); i++) {
            int val = 0;
            if (i < cantidades.length) val = parseIntSafe(cantidades[i], 0);
            if (i < fila.size()) fila.set(i, val); else fila.add(val);
        }
    }

    /** Garantiza que ex tenga filas = sucursales y columnas = productos. */
    public void ensureExConsistency(DataBase db) {
        while (db.ex.size() < db.sucursales.size()) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int i = 0; i < db.pieza_id.size(); i++) fila.add(0);
            db.ex.add(fila);
        }
        for (ArrayList<Integer> fila : db.ex) {
            while (fila.size() < db.pieza_id.size()) fila.add(0);
            while (fila.size() > db.pieza_id.size()) fila.remove(fila.size() - 1);
        }
    }

    private int parseIntSafe(String s, int def) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return def; }
    }

    private double parseDoubleSafe(String s, double def) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return def; }
    }
}
