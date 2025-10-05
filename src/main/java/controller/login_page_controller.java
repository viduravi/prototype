package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import login_details.login_details;

import java.io.IOException;

public class login_page_controller {

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void handleLoginAction(ActionEvent actionEvent) {
        String user = usernameField.getText();
        String pw = passwordField.getText();

        if (checkValidation(user, pw)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful!");
            openDashboard();
        } else {
            showAlert(Alert.AlertType.ERROR, "Invalid username or password!");
        }
    }

    private boolean checkValidation(String user, String pw) {
        return user.equals(login_details.getUSERNAME()) && login_details.checkPassword(pw);
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Login Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void forgotPasswordAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/reset_password.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Reset Password");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error loading reset password page!");
        }
    }

    @FXML
    public void enterOnAction(ActionEvent actionEvent) {
        handleLoginAction(actionEvent);
    }

    private void openDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error loading dashboard!");
        }
    }
}
