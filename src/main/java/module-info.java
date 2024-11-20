module com.jesse.boeira.ds1jogodavelha {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.jesse.boeira.ds1jogodavelha to javafx.fxml;
    exports com.jesse.boeira.ds1jogodavelha;
}