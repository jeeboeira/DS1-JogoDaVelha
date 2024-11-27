module com.jesseboeira.jogodavelha {
    requires javafx.fxml;
    requires java.rmi;
    requires javafx.controls;
    //requires javafx.controls;
    //requires javafx.fxml;
    //requires java.rmi;
    //requires java.desktop;
    //requires junit;

    exports com.jesseboeira.Old.ds1interfacejavafx; // Permite que o JavaFX acesse o pacote de interface
    exports com.jesseboeira.Old.ds1jogodavelha.core; // Exporte os pacotes usados na lógica, se necessário
    exports com.jesseboeira.Old.ds1jogodavelha.comm; // Exporte pacotes de comunicação, se utilizados na interface
    exports com.jesseboeira.jogodavelha;
}
