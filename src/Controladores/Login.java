package Controladores;

import Helpers.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField txtusu;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button btngo;

    @FXML
    private Button btnexit;


    //Constructor
    public Login(){
        stage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/Login.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Entrar(ActionEvent event) {
        if(Utilities.isAdmin(txtusu, txtpass)){
            txtusu.clear();
            txtpass.clear();
            System.out.println("Bienvenido");
            Producto prd = new Producto();
            stage.hide();
        }
        else{
            System.out.println("Usuario o contraseña incorrectos");
            txtusu.setFocusTraversable(true);
        }
    }

    @FXML
    void Cancel(ActionEvent event) {
        stage.hide();
    }

}
