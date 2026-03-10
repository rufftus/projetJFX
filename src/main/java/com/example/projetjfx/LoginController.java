package com.example.projetjfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
    @FXML
    private Label loginText;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    protected void onLoginButtonClick() {
        String login = loginField.getText();
        String password =passwordField.getText();
        loginText.setText("Veuillez saisir votre identifiants");
        loginText.setStyle("fx-text-fill: black");

        if(!password.equals("mdp")){
            loginText.setText("Identifiants incorrects");
            loginText.setStyle("-fx-text-fill: red");
        } else{
            loginText.setText("Hello "+login);
            loginText.setStyle("-fx-text-fill: green");
            loginText.setStyle("-fx-border-color: green; -fx-border-width: 2px");
        }

    }
    @FXML
    protected void onLogoutButtonClick() {
        String login = loginField.getText();
        String password =passwordField.getText();
        loginField.clear();
        passwordField.clear();
        loginText.setText("Veuillez saisir votre identifiants");
        loginText.setStyle("fx-text-fill: black");
    }
}