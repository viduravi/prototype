package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login_details.login_details;

public class reset_password_controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    public void handleResetAction(ActionEvent event) {
        String enteredUsername = usernameField.getText();
        String newPassword = newPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (enteredUsername.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please fill in all fields.");
            return;
        }

        if (!enteredUsername.equals(login_details.getUSERNAME())) {
            showAlert(Alert.AlertType.ERROR, "Invalid username. Please enter your registered username.");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            showAlert(Alert.AlertType.WARNING, "Passwords do not match!");
            return;
        }

        login_details.setPASSWORD(newPassword);
        showAlert(Alert.AlertType.INFORMATION, "Password has been successfully reset!");
    }

    @FXML
    public void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to login page...");
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Reset Password");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void handleResetPassword(ActionEvent actionEvent) {

    }
}
