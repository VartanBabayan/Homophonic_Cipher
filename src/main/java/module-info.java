module pl.polsl.lab.vartan.babayan {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.polsl.lab.vartan.babayan to javafx.fxml;
    exports pl.polsl.lab.vartan.babayan;
    exports pl.polsl.lab.vartan.babayan.controllercipher;
    exports pl.polsl.lab.vartan.babayan.modelcipher;
    opens pl.polsl.lab.vartan.babayan.controllercipher to javafx.fxml;
}