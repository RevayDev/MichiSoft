package com.michiStudios.michisoft.database;

public class preData {
    private DataBase db;

    public preData(DataBase db) {
        this.db = db;
    }

    public void cargarDatosPrueba() {
        // Administradores
        db.agregarAdministrador("Administrador Principal", "1743980838", "admin@michisoft.co", "admin123", 0);

        // Vendedores
        db.agregarVendedor("Vendedor Principal", "2783980734", "vendedor@michisoft.co", "venta123", 0);

        // Sucursales
        db.agregarSucursal("Barranquilla");
        db.agregarSucursal("Panama");
        db.agregarSucursal("Corea del Norte");

        // Productos
        db.agregarProducto("28822731", "Router MichiLink", 19.99);
        db.agregarProducto("89569383", "Cable MichiRed CAT6", 29.99);
        db.agregarProducto("57887731", "Mini PC MichiBox", 9.99);
        db.agregarProducto("65466678", "Camara IP MichiCam 360", 15.50);

        // Actualizar existencias
        db.actualizarExistencia(0, 0, 15); // Barranquilla, Producto 0
        db.actualizarExistencia(0, 1, 60); // Barranquilla, Producto 1
        db.actualizarExistencia(0, 2, 40); // Barranquilla, Producto 2
        db.actualizarExistencia(0, 3, 20); // Barranquilla, Producto 1
        
        db.actualizarExistencia(1, 0, 65); // Panama, Producto 0
        db.actualizarExistencia(1, 1, 40); // Panama, Producto 1
        db.actualizarExistencia(1, 2, 10); // Panama, Producto 2
        db.actualizarExistencia(1, 3, 5); // Panama, Producto 1

    }
}
