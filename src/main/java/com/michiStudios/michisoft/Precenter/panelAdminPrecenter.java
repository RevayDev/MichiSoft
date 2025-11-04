package com.michiStudios.michisoft.Precenter;
import java.util.ArrayList;

//Panel Login
import com.michiStudios.michisoft.View.loginView;
import com.michiStudios.michisoft.Model.loginModel;
import com.michiStudios.michisoft.Precenter.loginPrecenter;
import com.michiStudios.michisoft.database.DataBase;

//Panel Admin
import com.michiStudios.michisoft.Model.panelAdminModel;

// Imortacion de ventana message
import com.michiStudios.michisoft.View.messageView;
import com.michiStudios.michisoft.database.FileManage.MainFileManager;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelAdminPrecenter {
    private panelAdminModel panelAdminModel;
    private DataBase db;
    private MainFileManager fm;
    private messageView messageView = new messageView();
    
    public panelAdminPrecenter(panelAdminModel panelAdminModel, DataBase db, MainFileManager fm){
        this.panelAdminModel = panelAdminModel;
        this.db = db;
        this.fm = fm;

    }
    
    //Cerrar seccion
    public boolean ExitPanel(){
             loginModel loginModel = new loginModel(db);
             loginPrecenter loginPrecenter = new loginPrecenter(loginModel, db, fm);
             loginView loginView = new loginView(loginPrecenter);
             loginView.setVisible(true);
             return  true; 
    }
    
    
    //Selectores
    //Cargador de Sucursales de los selecores
    public String[] ReloadDataSucursal(){
       return panelAdminModel.ReloadDataSucursal();
    }
    
    //Cargador de las Piezas
    public ArrayList<ArrayList<String>> ReloadDataItems(){
       return panelAdminModel.ReloadDataItems();
    }
    
    //Sucursales
    //Agregar sucursal
    public void AgregarSucursal(String NombreSucursal){
       boolean res = panelAdminModel.AgregarSucursal(NombreSucursal);
       if(res) messageView.message("Sucursal agregado con exito", true);
       else messageView.message("Sucursal ya existente", false);
    }
    
    // Editar una sucursal
    public void EditSucursal(String NombreSucursal, String NewNombreSucursa){
       boolean res = panelAdminModel.EditSucursal(NombreSucursal, NewNombreSucursa);
       if(res) messageView.message("Sucursal editado con exito", true);
       else messageView.message("Error al guardar cambios", false);
       ReloadDataSucursal();
    }
    
    //Eliinar sucursal
    public void DeleteSucursal(String NombreSucursal){
       boolean res = panelAdminModel.DeleteSucursal(NombreSucursal);
       if(res) messageView.message("Sucursal eliminada con exito", true);
       else messageView.message("Error al eliminar cambios", false);
       ReloadDataSucursal();
    }
    
    // Obtener toda la informacion de una sucursal
    public int[] GetSucursalInfo(String NombreSucursal){
        int[] res =  panelAdminModel.GetInfoSucursal(NombreSucursal);
        return res;
    }
    
   /*
    * @author ALEJANDRA BOLIVARES
   */
    //Paner Reportes
    // Maximo y Minimo de un producto de una sucursal
    public String[] MaxAndMinPiezas(String Sucursal){
       return panelAdminModel.MaxAndMinPiezas(Sucursal);
    }
    
    // Obtener invntario completo de una sucursal
    public ArrayList<ArrayList<String>> getInventarioSucursal(String nombreSucursal){
        return panelAdminModel.getInventarioSucursal(nombreSucursal);
    }
    
    // Obtener informacion de cantidad de una pieza por sucursal
    public ArrayList<ArrayList<String>> getPiezaID(String nombrePiezasID){
        return panelAdminModel.getPiezaID(nombrePiezasID);
    }

    /*
     * @author ESTEBAN JAIMES
    */
    
    //Panel piezas
    // Crear una pieza
    public void AgregarPieza(String codigo, String nombre, double precio, String sucursal, int cantidad) {
       boolean res = panelAdminModel.AgregarPieza(codigo, nombre, precio, sucursal, cantidad);
       if(res) messageView.message("Pieza agregada con exito", true);
       else messageView.message("No se pudo agregar la piza, verifique los campos", false);
       ReloadDataItems();
    }
    
    // Eliminar una pieza
    public void DeletePieza(String codigo, String sucursal){
         boolean res = panelAdminModel.EliminarPieza(codigo, sucursal);
         if(res) messageView.message("Pieza eliminada con exito", true);
         else messageView.message("No se pudo eliminar la piza, verifique los campos", false);
         ReloadDataItems();
    }
    
    //Editar una pieza
    public void EditarPieza(String codigo, String nuevoNombre, double nuevoPrecio, String sucursal, int nuevaCantidad) {
        boolean res = panelAdminModel.EditarPieza(codigo, nuevoNombre, nuevoPrecio, sucursal, nuevaCantidad);
        if(res) messageView.message("Pieza se editor con exito", true);
        else messageView.message("No se pudo editar la piza, verifique los campos", false);
    }
    
    // Obtener una lista de todas las piezas
    public ArrayList<ArrayList<String>> GetInfoPiezas() {
         return panelAdminModel.GetInfoPiezas();
    }
    
    /*
    * @author SAMUEL CASTRO
    */
    
    //Panel usuario
    //Crear usuario
    public void AddUsuario(String nombre, String id, String correo, char[] pass, String sucursal, String rol){
        Object[] res = panelAdminModel.AddUsuario(nombre, id, correo, pass, sucursal, rol);
        if((boolean) res[0]) messageView.message("Usuario creado con exito", true);
        else messageView.message((String) res[1], false);
    }
    
    //Editar un usuario (Solo Nombre o sucursal)
    public void EditUsuario(String id, String nuevoNombre, String Sucursal, String rol){
        boolean res = panelAdminModel.EditUsuario(id, nuevoNombre, Sucursal, rol);
        if(res) messageView.message("Usuario editado con exito", true);
        else messageView.message("No se pudo editar el usuario, verifique los campos", false);
    }
    
    //Eliminar un usuario
    public void DeleteUsuario(String id, String rol){
        boolean res = panelAdminModel.DeleteUsuario(id, rol);
        if(res) messageView.message("Usuario eliminado con exito", true);
        else messageView.message("No se pudo eliminar el usuario, verifique los campos", false);
    }
    
    /*
     * @author ROBERTO JIMENEZ
    */ 
    
    //Obtener lista completa de un usuario
    public ArrayList<ArrayList<String>> GetUsurarios() {
         return panelAdminModel.GetUsuarios();
    } 
}
