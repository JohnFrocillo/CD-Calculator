package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	String name = new String("John");
	String pass = new String("money");
	public static int totalNumBanks = 0;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button login;

	@FXML
	private Button forgotPassword;

	@FXML
	private void login(ActionEvent e) throws IOException {
		// Check username and password.
		if (username.getText().equals(name) && password.getText().equals(pass)) {
			//JOptionPane.showMessageDialog(null, "Login Successful.");
			Alert success = new Alert(AlertType.INFORMATION);
			success.setTitle("Login");
			success.setHeaderText(null);
			success.setContentText("Login Successful.");
			success.showAndWait();

			// CALL THE MAIN WINDOW WITH THE ABILITY TO PASS PARAMS
			FXMLLoader Loader = new FXMLLoader();
			Loader.setLocation(getClass().getResource("MainWindow.fxml"));
			Loader.load();
			// MainWindowController win = Loader.getController();
			// USE win TO CALL METHODS AND PASS THINGS TO THE NEW CONTROLLER
			// win.setButton();
			Parent p = Loader.getRoot();
			Stage stage = new Stage();
			stage.setTitle("Certificate of Deposit Calculator");
			stage.setScene(new Scene(p));
			stage.show();

			// CLOSE THE LOGIN WINDOW
			Stage stageThis = (Stage) username.getScene().getWindow();
			stageThis.close();
		} else {
			//JOptionPane.showMessageDialog(null, "Incorrect username or password.");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Incorrect username or password.");
			alert.showAndWait();
		}
	}

	@FXML
	private void forgot() {
		//JOptionPane.showMessageDialog(null, "Not supported in this version.");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Version 1.0 Notice");
		alert.setHeaderText(null);
		alert.setContentText("Not supported in this version.");
		alert.showAndWait();
	}
	
	@FXML
	private void loginMouseEnter() {
		login.setStyle("-fx-background-color:white; -fx-background-radius:5em");
	}
	
	@FXML
	private void loginMouseExit() {
		login.setStyle("-fx-background-color: #ffe0c2; -fx-background-radius:5em");
	}
	
	@FXML
	private void forgotPassMouseEnter() {
		forgotPassword.setStyle("-fx-background-color:white; -fx-background-radius:5em");
	}
	
	@FXML
	private void forgotPassMouseExit() {
		forgotPassword.setStyle("-fx-background-color: #ffe0c2; -fx-background-radius:5em");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Runs when window immediately loads
	}

}
