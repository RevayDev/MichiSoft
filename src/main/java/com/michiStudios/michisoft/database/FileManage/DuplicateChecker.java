package com.michiStudios.michisoft.database.FileManage;

import com.michiStudios.michisoft.database.DataBase;
import java.util.HashSet;

public class DuplicateChecker {

    public static void limpiarDuplicados(DataBase db) {
        // Sucursales
        db.sucursales = new java.util.ArrayList<>(new HashSet<>(db.sucursales));

        // Administradores
        HashSet<String> adminSet = new HashSet<>();
        for (int i = 0; i < db.administrador.size(); i++) {
            String registro = db.administrador.get(i) + "|" + db.id_ad.get(i) + "|" + db.correo_ad.get(i) + "|" + db.pass_ad.get(i);
            if (!adminSet.contains(registro)) {
                adminSet.add(registro);
            }
        }
        reconstruirAdmins(db, adminSet);

        // Vendedores
        HashSet<String> vendedorSet = new HashSet<>();
        for (int i = 0; i < db.vendedor.size(); i++) {
            String registro = db.vendedor.get(i) + "|" + db.id_ve.get(i) + "|" + db.correo_ve.get(i) + "|" + db.pass_ve.get(i);
            if (!vendedorSet.contains(registro)) {
                vendedorSet.add(registro);
            }
        }
        reconstruirVendedores(db, vendedorSet);
    }

    private static void reconstruirAdmins(DataBase db, HashSet<String> set) {
        db.administrador.clear();
        db.id_ad.clear();
        db.correo_ad.clear();
        db.pass_ad.clear();
        for (String s : set) {
            String[] partes = s.split("\\|");
            db.administrador.add(partes[0]);
            db.id_ad.add(partes[1]);
            db.correo_ad.add(partes[2]);
            db.pass_ad.add(partes[3]);
        }
    }

    private static void reconstruirVendedores(DataBase db, HashSet<String> set) {
        db.vendedor.clear();
        db.id_ve.clear();
        db.correo_ve.clear();
        db.pass_ve.clear();
        for (String s : set) {
            String[] partes = s.split("\\|");
            db.vendedor.add(partes[0]);
            db.id_ve.add(partes[1]);
            db.correo_ve.add(partes[2]);
            db.pass_ve.add(partes[3]);
        }
    }
}
