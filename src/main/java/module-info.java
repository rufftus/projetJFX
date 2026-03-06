module com.example.projetjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetjfx to javafx.fxml;
    exports com.example.projetjfx;
}