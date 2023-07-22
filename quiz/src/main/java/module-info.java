module com {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com to javafx.fxml;
    exports com;
}