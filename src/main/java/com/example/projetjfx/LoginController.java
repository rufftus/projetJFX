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
    private Button logoutButton;

    private int erreur=0;


    @FXML
    protected void onLoginButtonClick() {
        String login = loginField.getText();
        String password =passwordField.getText();
        loginText.setText("Veuillez saisir votre identifiants");
        loginText.setStyle("fx-text-fill: black");
        if(!password.equals("mdp")){
            erreur=erreur+1;
            loginText.setText("Identifiants incorrects");
            loginText.setStyle("-fx-text-fill: red");
        } else{
            if(erreur>=3){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Vous avez fait 3 erreurs");
                alert.showAndWait();
                loginButton.setDisable(true);
            }
            else{
                loginText.setText("Hello "+login);
                loginText.setStyle("-fx-text-fill: green;-fx-border-color: green; -fx-border-width: 2px");
                logoutButton.setDisable(false);
                loginButton.setDisable(true);
            }
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
        logoutButton.setDisable(true);
        loginButton.setDisable(false);
        erreur=0;
    }
}