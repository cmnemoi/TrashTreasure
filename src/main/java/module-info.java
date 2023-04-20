module com.cytech {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cytech to javafx.fxml;
    opens com.cytech.controller to javafx.fxml;
    exports com.cytech;
}