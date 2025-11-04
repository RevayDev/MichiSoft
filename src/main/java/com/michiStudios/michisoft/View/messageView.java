package com.michiStudios.michisoft.View;

//Paquete adicionales
import javax.swing.JOptionPane;

//Sonidos
import Sound_Manage.ErrorSound;
import Sound_Manage.CorrectSound;

/*
 * @author ROBERTO JIMENEZ
 */

public class messageView {
    public void message(String message, boolean opcion){
        if(!opcion){
            ErrorSound.play();
            JOptionPane.showMessageDialog(null, message, "System Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            CorrectSound.play();
            JOptionPane.showMessageDialog(null, message, "System", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

}
