module demoproject {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.opencsv;

    requires org.controlsfx.controls;

    opens com.energy.demoproject to javafx.fxml;
    exports com.energy.demoproject;
}