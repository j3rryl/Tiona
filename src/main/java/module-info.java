module com.tione.tiona {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires firebase.admin;
    requires google.cloud.core;
    requires com.google.api.apicommon;
    requires com.google.auth.oauth2;
    requires google.cloud.firestore;
    requires com.google.auth;

    opens com.tione.tiona to javafx.fxml;
    exports com.tione.tiona;

    opens com.tione.tiona.Admin to javafx.fxml;
    exports com.tione.tiona.Admin;
    exports com.tione.tiona.HelperClass;
    opens com.tione.tiona.HelperClass to javafx.fxml;
    exports com.tione.tiona.Models;
    opens com.tione.tiona.Models to javafx.fxml;
}