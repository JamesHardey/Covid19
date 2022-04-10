module com.example.covid19 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfoenix;
    requires java.sql;
    requires com.gluonhq.connect;
    requires jackson.databind;
    requires jackson.annotations;

    opens com.example.covid19 to javafx.fxml;
    exports com.example.covid19;
    exports com.example.covid19.models1;
    opens com.example.covid19.models1 to javafx.fxml;
}