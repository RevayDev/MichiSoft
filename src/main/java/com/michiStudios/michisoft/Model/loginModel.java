package com.michiStudios.michisoft.Model;
// Importacion de la DB
import com.michiStudios.michisoft.database.DataBase;
import com.michiStudios.michisoft.database.FileManage.MainFileManager;
/*
 * @author ROBERTO JIMENEZ
 */

public class loginModel {
    private final DataBase db;

    public loginModel(DataBase db) {
        this.db = db;
    }

    // Retorna {true, true} si es administrador, {true, false} si es vendedor, {false, false} si no autenticado
    public boolean[] Login(String UserID, char[] Password) {
        String PasswordString = new String(Password);

        // Verificar si es ADMIN por ID
        for (int i = 0; i < db.administrador.size(); i++) {
            if (db.id_ad.get(i) != null && db.pass_ad.get(i) != null &&
                db.id_ad.get(i).equals(UserID) && db.pass_ad.get(i).equals(PasswordString)) {
                db.sucursal_point = db.sucursal_ad.get(i);
                return new boolean[]{true, true};
            }
        }

        // Verificar si es ADMIN por correo
        for (int i = 0; i < db.administrador.size(); i++) {
            if (db.correo_ad.get(i) != null && db.pass_ad.get(i) != null &&
                db.correo_ad.get(i).equals(UserID) && db.pass_ad.get(i).equals(PasswordString)) {
                db.sucursal_point = db.sucursal_ad.get(i);
                return new boolean[]{true, true};
            }
        }

        // Verificar si es VENDEDOR por ID
        for (int i = 0; i < db.vendedor.size(); i++) {
            if (db.id_ve.get(i) != null && db.pass_ve.get(i) != null &&
                db.id_ve.get(i).equals(UserID) && db.pass_ve.get(i).equals(PasswordString)) {
                db.sucursal_point = db.sucursal_ve.get(i);
                return new boolean[]{true, false}; 
            }
        }

        // Verificar si es VENDEDOR por correo
        for (int i = 0; i < db.vendedor.size(); i++) {
            if (db.correo_ve.get(i) != null && db.pass_ve.get(i) != null &&
                db.correo_ve.get(i).equals(UserID) && db.pass_ve.get(i).equals(PasswordString)) {
                db.sucursal_point = db.sucursal_ve.get(i);
                return new boolean[]{true, false}; 
            }
        }

        // Si no pasó ninguna validación
        return new boolean[]{false, false};
    }
}
