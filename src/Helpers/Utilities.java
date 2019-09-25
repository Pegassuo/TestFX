package Helpers;

import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.List;

public class Utilities {

    //Comprobar si es admin
    public static boolean isAdmin(TextField usuario, TextField contrasena){
        boolean bl = false;
        if(usuario.getText().equals("cbr") && contrasena.getText().equals("carlos0903")){
            bl = true;
        }
        return bl;
    }

    //Negando la comprobación del admin
    public static boolean isNotAdmin(TextField usuario, TextField contrasena){
        return !isAdmin(usuario, contrasena);
    }

}
