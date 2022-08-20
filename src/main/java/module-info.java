module cf.democf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens cf.democf to javafx.fxml;
    exports cf.democf;
    exports cf.democf.controller;
    opens cf.democf.controller to javafx.fxml;
    exports cf.democf.model;
    opens cf.democf.model to javafx.fxml;
}