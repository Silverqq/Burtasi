module com.example.kursa4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.kursa4 to javafx.fxml;
    exports com.example.kursa4;
}