module com.conservor.moeda {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.conservor.moeda to javafx.fxml;
    exports com.conservor.moeda;
}
