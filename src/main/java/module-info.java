module demoproject {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.opencsv;
    requires static lombok;

    requires org.controlsfx.controls;

    opens com.energy.demoproject to javafx.fxml;
    exports com.energy.demoproject;
}