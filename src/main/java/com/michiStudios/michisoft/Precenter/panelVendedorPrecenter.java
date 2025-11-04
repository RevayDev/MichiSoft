package com.michiStudios.michisoft.Precenter;

//Importa DB
import com.michiStudios.michisoft.database.DataBase;

//Panel Vendedor
import com.michiStudios.michisoft.Model.panelVendedorModel;
import com.michiStudios.michisoft.View.messageView;

//Panel Login
import com.michiStudios.michisoft.View.loginView;
import com.michiStudios.michisoft.Model.loginModel;
import com.michiStudios.michisoft.Precenter.loginPrecenter;
import com.michiStudios.michisoft.database.FileManage.MainFileManager;

//Paquetes adicionales
import java.util.ArrayList;
import java.util.Map;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelVendedorPrecenter {
    private panelVendedorModel panelVendedorModel;
    private DataBase db;
    private MainFileManager fm;
    private messageView messageView = new messageView();
    
    public panelVendedorPrecenter(panelVendedorModel panelVendedorModel, DataBase db, MainFileManager fm){
        this.panelVendedorModel = panelVendedorModel;
         this.db = db;
         this.fm = fm;
    }
    
    // Cerrar seccion
    public boolean ExitPanel(){
        loginModel loginModel = new loginModel(db);
        loginPrecenter loginPrecenter = new loginPrecenter(loginModel, db, fm);
        loginView loginView = new loginView(loginPrecenter);
        loginView.setVisible(true);
        return  true; 
    }
    
    //PanelResumen
    // Obtener ariculos por debajo de 30 unidades
    public ArrayList<ArrayList<String>> getPiezaAgotada() {
        return  panelVendedorModel.getPiezaAgotada();
    }
    
    // Obtener resumen globales
    public String[] getInfoResume(){
        return panelVendedorModel.getInfoResume();
    }
    
   /*
    * @author ALEJANDRA BOLIVARES
   */
    
    //Panel Inventario
    // Inventario de sucursal que este el vendedor
    public Object[] getInventarioSucursal(){
        return panelVendedorModel.getInventarioSucursal();
    }
    
    //Panel Equipo
    // Lista de miembros de la sucursal que este el vendedor
    public Object[] getEquipo(){
        return panelVendedorModel.GetEquipo();
    }
    
 
    public void procesarVenta(String producto, String cantidadText, String nombre, 
                               String documento, String telefono, String direccion){
        String res = panelVendedorModel.procesarVenta(producto, cantidadText, nombre, documento, telefono, direccion);
        if(res.contains("SUCCESS:")){
             messageView.message(res, true);
             
        }else messageView.message(res, false);
    }
    
    public String obtenerInformacionProducto(String producto){
        return panelVendedorModel.obtenerInformacionProducto(producto);
    }
    
     public Map<String, String> obtenerProductos(){
         return  panelVendedorModel.obtenerProductos();
     }

}
