package com.michiStudios.michisoft.Precenter;

//Panel Login
import com.michiStudios.michisoft.Model.loginModel;

// Imortacion de ventana message
import com.michiStudios.michisoft.View.messageView;

// Importacion de la DB
import com.michiStudios.michisoft.database.DataBase;
import com.michiStudios.michisoft.database.FileManage.MainFileManager;

//Panel Admin
import com.michiStudios.michisoft.Model.panelAdminModel;
import com.michistudios.michisoft.View.panelAdminView;
import com.michiStudios.michisoft.Precenter.panelAdminPrecenter;

//Panel Vendedor
import com.michiStudios.michisoft.View.panelVendedorView;
import com.michiStudios.michisoft.Model.panelVendedorModel;
import com.michiStudios.michisoft.Precenter.panelVendedorPrecenter;

/*
 * @author ROBERTO JIMENEZ
 */

public class loginPrecenter {
     private loginModel loginModel;
     private messageView messageView = new messageView();
     private DataBase db;
     private MainFileManager fm;
    
     public loginPrecenter(loginModel loginModel, DataBase db, MainFileManager fm){
         this.loginModel = loginModel;
         
         this.db = db;
         this.fm = fm;
     }
     
     //Marca de agua (Sello)
     public void start(){
        System.out.println("""
         /$$      /$$ /$$           /$$       /$$                      /$$$$$$   /$$    
        | $$$    /$$$|__/          | $$      |__/                     /$$__  $$ | $$    
        | $$$$  /$$$$ /$$  /$$$$$$$| $$$$$$$  /$$  /$$$$$$$  /$$$$$$ | $$  \\__//$$$$$$  
        | $$ $$/$$ $$| $$ /$$_____/| $$__  $$| $$ /$$_____/ /$$__  $$| $$$$   |_  $$_/  
        | $$  $$$| $$| $$| $$      | $$  \\ $$| $$|  $$$$$$ | $$  \\ $$| $$_/     | $$    
        | $$\\  $ | $$| $$| $$      | $$  | $$| $$ \\____  $$| $$  | $$| $$       | $$ /$$
        | $$ \\/  | $$| $$|  $$$$$$$| $$  | $$| $$ /$$$$$$$/|  $$$$$$/| $$       |  $$$$/ 
        |__/     |__/|__/ \\_______/|__/  |__/|__/|_______/  \\______/ |__/        \\___/ 
                                                      
        Created with architecture MVP - 2025               Res System -> Hello World >W<
                           
        """);
     }
     
     //Sistema de Login
     public boolean Login(String UserID, char[] Password){
         boolean[] res = loginModel.Login(UserID, Password);
         
         if(res[0] && res[1]){
             messageView.message("Iniciado como Administrador", true);
             //(panelAdmin)
             panelAdminModel panelAdminModel = new panelAdminModel(db);
             panelAdminPrecenter panelAdminPrecenter = new panelAdminPrecenter(panelAdminModel, db, fm);
             panelAdminView panelAdminView = new panelAdminView(panelAdminPrecenter);
             panelAdminView.setVisible(true);
             return  true;         
             
         }else{
             if(res[0] && !res[1]){
                  messageView.message("Iniciado como Vendedor", true);
                  //(panelVendedor)
                  panelVendedorModel panelVendedorModel = new panelVendedorModel(db, fm);
                  panelVendedorPrecenter panelVendedorPrecenter = new panelVendedorPrecenter(panelVendedorModel, db, fm);
                  panelVendedorView panelVendedorView = new panelVendedorView(panelVendedorPrecenter);
                  panelVendedorView.setVisible(true);
                  return  true;
                  
             } else messageView.message("Credenciales incorrectas", false);
         }
          
         return false;

     }
      
}
