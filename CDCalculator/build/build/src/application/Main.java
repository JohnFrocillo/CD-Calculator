package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(final Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Certificates of Deposit Calculator");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
