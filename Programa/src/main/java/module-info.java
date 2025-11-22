module com.example.programa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires java.logging;
    requires java.desktop;
    requires org.apache.commons.csv;
    requires java.sql;

    opens com.example.programa to javafx.fxml;
    opens com.example.programa.Controllers to javafx.fxml;

    opens com.example.programa.Classes.MusicClass to javafx.base;

    exports com.example.programa;
}