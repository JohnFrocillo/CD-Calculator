package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(final Stage stage) throws Exception {

		// SWITCH TO MAINWINDOW.fxml FOR FASTER TESTING
		// Should be LoginWindow.fxml for the actual program
		Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
