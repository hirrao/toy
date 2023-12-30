module com.hirrao.rockpaperscissors {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.hirrao.rockpaperscissors to javafx.fxml;
    exports com.hirrao.rockpaperscissors;
}