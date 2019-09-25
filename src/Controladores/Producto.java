package Controladores;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Producto {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtcan;

    @FXML
    private TextField txtpre;

    @FXML
    private TableView<?> tbpro;

    @FXML
    private Button btnadd;

    @FXML
    void AddProduct(ActionEvent event) {

    }

    //Constructor
    public Producto(){
        stage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/Productos.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            setTextLimit(txtcan, 3);
            txtcan.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d*")) {
                        txtcan.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setTextLimit(TextField textField, int length) {
        textField.setOnKeyTyped(event -> {
            String string = textField.getText();

            if (string.length() > length) {
                textField.setText(string.substring(0, length));
                textField.positionCaret(string.length());
            }
        });
    }
}
