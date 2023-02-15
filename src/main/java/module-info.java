module com.example.emailfunctionality {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;


    opens com.programming.EmailApiDemo to javafx.fxml;
    exports com.programming.EmailApiDemo;
}