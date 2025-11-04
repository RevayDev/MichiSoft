package com.michiStudios.michisoft.database.FileManage;

import com.michiStudios.michisoft.database.DataBase;
import java.io.File;

public class MainFileManager {

    private final Loader loader;
    private final Saver saver;
    private final File archivo;

    public MainFileManager() {
        archivo = new File("src/main/java/com/michiStudios/michisoft/database/FileManage/Registro.txt");
        loader = new Loader();
        saver = new Saver();
    }

    public void cargar(DataBase db) {
        if (!archivo.exists()) {
            System.out.println("[FileManage] No existe Registro.txt, se creará al guardar.");
            return;
        }
        loader.cargarDesdeArchivo(db, archivo);
    }

    public void guardar(DataBase db) {
        saver.guardarEnArchivo(db, archivo);
    }

    public void registrarAutoGuardado(final DataBase db) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("[FileManage] Guardando datos antes de cerrar...");
            guardar(db);
            System.out.println("[FileManage] Guardado finalizado.");
        }));
    }
}
