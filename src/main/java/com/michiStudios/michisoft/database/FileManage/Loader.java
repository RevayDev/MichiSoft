package com.michiStudios.michisoft.database.FileManage;

import com.michiStudios.michisoft.database.DataBase;
import java.io.*;

public class Loader {

    private final Parser parser = new Parser();

    public void cargarDesdeArchivo(DataBase db, File archivo) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea;
            String seccion = "";

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                if (linea.startsWith("#")) {
                    seccion = linea;
                    continue;
                }

                switch (seccion) {
                    case "#SUCURSALES":
                        parser.parseSucursal(linea, db);
                        break;

                    case "#ADMINISTRADORES":
                        parser.parseAdmin(linea, db);
                        break;

                    case "#VENDEDORES":
                        parser.parseVendedor(linea, db);
                        break;

                    case "#PIEZAS":
                        parser.parseProducto(linea, db);
                        break;

                    case "#EXISTENCIAS":
                        parser.parseExistencias(linea, db);
                        break;

                    default:
                        // sección desconocida -> ignorar
                        break;
                }
            }

            // Ajustar la matriz de existencias por si faltó algo
            parser.ensureExConsistency(db);

        } catch (IOException e) {
            System.out.println("[FileManage] Error al leer el archivo: " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException ignored) {}
        }
    }
}
