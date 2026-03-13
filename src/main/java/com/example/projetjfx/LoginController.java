package com.example.projetjfx;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

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
    private Button logoutButton;

    @FXML
    private int erreur=0;





    List<String> utilisateurs= new ArrayList<String>();
    List<String> sifre= new ArrayList<String>();

    public void initialize(){
        utilisateurs.add("admin");
        sifre.add("admin");

        utilisateurs.add("ilker");
        sifre.add("ilker");

        utilisateurs.add("visiteur");
        sifre.add("visiteur");
    }


    @FXML
    protected void onLoginButtonClick() {
        String login = loginField.getText();
        String password = passwordField.getText();
        boolean testU=false;
        boolean testS=false;
        int valU=0;
        int valS=0;

        loginText.setText("Veuillez saisir vos identifiants");
        loginText.setStyle("-fx-text-fill: black");

        for(int i=0;i<utilisateurs.size();i++){
            if (login.equals(utilisateurs.get(i))){
                testU=true;
                valU=i;
            }
        }
        for(int i=0;i<sifre.size();i++){
            if (password.equals(sifre.get(i))){
                testS=true;
                valS=i;
            }
        }

        if((testU && testS) && (valU==valS)){
            loginText.setText("Hello " + login);
            loginText.setStyle("-fx-text-fill: green;-fx-border-color: green; -fx-border-width: 2px");
            logoutButton.setDisable(false);
            loginButton.setDisable(true);
        }
        else{
            erreur = erreur + 1;
            loginText.setText("Identifiants incorrects ["+erreur+"/3]");
            loginText.setStyle("-fx-text-fill: red");

            if(erreur >= 3){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERREURS");
                alert.setHeaderText("Vous avez fait 3 erreurs");
                alert.showAndWait();
                Platform.exit();
                loginButton.setDisable(true);
            }
        }

    }


    @FXML
    protected void onLogoutButtonClick() {
        String login = loginField.getText();
        String password = passwordField.getText();
        loginField.clear();
        passwordField.clear();
        loginText.setText("Veuillez saisir vos identifiants");
        loginText.setStyle("-fx-text-fill: black");
        logoutButton.setDisable(true);
        loginButton.setDisable(false);
        erreur=0;
    }
}