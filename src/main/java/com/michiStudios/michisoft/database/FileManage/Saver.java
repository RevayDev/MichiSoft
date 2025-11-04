package com.michiStudios.michisoft.database.FileManage;

import com.michiStudios.michisoft.database.DataBase;
import java.io.*;

public class Saver {

    public void guardarEnArchivo(DataBase db, File archivo) {
        DuplicateChecker.limpiarDuplicados(db);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            
            // Sucursales
            bw.write("#SUCURSALES\n");
            for (String suc : db.sucursales) {
                bw.write(suc + "\n");
            }
            bw.write("\n");

            // Administradores
            bw.write("#ADMINISTRADORES\n");
            for (int i = 0; i < db.administrador.size(); i++) {
                bw.write(db.administrador.get(i) + "|" +
                         db.id_ad.get(i) + "|" +
                         db.correo_ad.get(i) + "|" +
                         db.pass_ad.get(i) + "|" +
                         db.sucursal_ad.get(i) + "\n");
            }
            bw.write("\n");

            // Vendedores
            bw.write("#VENDEDORES\n");
            for (int i = 0; i < db.vendedor.size(); i++) {
                bw.write(db.vendedor.get(i) + "|" +
                         db.id_ve.get(i) + "|" +
                         db.correo_ve.get(i) + "|" +
                         db.pass_ve.get(i) + "|" +
                         db.sucursal_ve.get(i) + "\n");
            }
            bw.write("\n");

            // Piezas
            bw.write("#PIEZAS\n");
            for (int i = 0; i < db.pieza_id.size(); i++) {
                bw.write(db.pieza_id.get(i) + "|" +
                         db.pieza_name.get(i) + "|" +
                         db.pieza_price.get(i) + "\n");
            }
            bw.write("\n");

            // Existencias
            bw.write("#EXISTENCIAS\n");
            for (int i = 0; i < db.ex.size(); i++) {
                bw.write(i + ":");
                for (int j = 0; j < db.ex.get(i).size(); j++) {
                    bw.write(db.ex.get(i).get(j) + (j < db.ex.get(i).size() - 1 ? "," : ""));
                }
                bw.write("\n");
            }

        } catch (IOException e) {
            System.out.println("[FileManage] Error al guardar el archivo: " + e.getMessage());
        }
    }
}
