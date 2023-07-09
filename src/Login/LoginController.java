package Login;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;



public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Label statusLabel1;

    @FXML
    private ImageView gambar;

    @FXML
    private void handleLoginButtonAction() throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin")) {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Menu/Tmenu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Sampah");
            primaryStage.setScene(scene);
            primaryStage.show();

            // Close the login window
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();
        
         } else if (!username.equals("admin")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Username salah.");
            alert.showAndWait();
         } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password salah.");
            alert.showAndWait();
        }
    }

}
