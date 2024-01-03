module com.hirrao.game {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    opens com.hirrao.game.control to javafx.fxml;
    exports com.hirrao.game.main;
}