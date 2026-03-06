package com.example.projetjfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label loginText;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    protected void onHelloButtonClick() {
        String login = loginField.getText();
        String password =passwordField.getText();

        if(!password.equals("mdp")){
            loginText.setText("Identifiants incorrects");
            loginText.setStyle("-fx-text-fill: red");
        } else{
            loginText.setText("Veuillez saisir vos identifiants");
            loginText.setStyle("fx-text-fill: black");
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Hello "+login);
            alert.showAndWait();
            loginField.clear();
            passwordField.clear();
        }

    }
}