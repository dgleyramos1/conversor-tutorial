module com.conservor.moeda {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.conservor.moeda to javafx.fxml;
    opens com.conservor.moeda.model to com.google.gson;

    exports com.conservor.moeda;
}