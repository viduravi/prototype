package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login_details.login_details;

public class login_page_controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    @FXML
    public void initialize() {
        roleChoiceBox.getItems().addAll("Admin", "Student");
        roleChoiceBox.setValue("Student");
    }

    @FXML
    public void handleLoginAction(ActionEvent actionEvent) {
        String user = usernameField.getText();
        String pw = passwordField.getText();

        if (checkValidation(user, pw)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Invalid username or password!");
        }
    }

    private boolean checkValidation(String user, String pw) {
        String storedUsername = login_details.getUSERNAME();
        String storedPassword = login_details.getPASSWORD();

        return user.equals(storedUsername) && pw.equals(storedPassword);
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Login Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
