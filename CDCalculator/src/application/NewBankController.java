package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewBankController implements Initializable {

	@FXML
	private Label bankName, amount, time, apy, date;

	@FXML
	private TextField typeBankName, typeAmount, typeTime, typeAPY, typeDate;

	@FXML
	private Button next, cancel;

	public void next() throws IOException {
		Alert valid = new Alert(AlertType.INFORMATION);
		valid.setTitle("Error!");
		valid.setHeaderText(null);
		valid.setContentText("");

		if (!(typeAmount.getText().matches("\\d*\\.{1}\\d*") || typeAmount.getText().matches("\\d*"))) {
			valid.setContentText("Enter a valid number for the amount.");
			valid.showAndWait();
		} else if (!(typeTime.getText().matches("\\d*"))) {
			valid.setContentText("Enter a valid number for the time of maturity.");
			valid.showAndWait();
		} else if (!(typeAPY.getText().matches("\\d*\\.{1}\\d*") || typeAPY.getText().matches("\\d*"))) {
			valid.setContentText("Enter a valid number or decimal for the APY.");
			valid.showAndWait();
		} else if (!(typeDate.getText().matches("\\d{2}\\/\\d{2}\\/\\d{4}"))) {
			valid.setContentText("Enter a valid date following the pattern shown.");
			valid.showAndWait();
		} else {
			String amount;
			double temp;
			// format Money
			try {
				amount = typeAmount.getText();
				temp = Double.parseDouble(amount);
				Locale locale = new Locale("en", "US");
				NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
				typeAmount.setText(currencyFormatter.format(temp));
			} catch (Exception e) {
				amount = typeAmount.getText();
			}

			// display all cells as ready for entering data
			typeBankName.setStyle("-fx-control-inner-background: yellow; -fx-font-weight: bold");
			typeAmount.setStyle("-fx-control-inner-background: yellow; -fx-font-weight: bold");
			typeTime.setStyle("-fx-control-inner-background: yellow; -fx-font-weight: bold");
			typeAPY.setStyle("-fx-control-inner-background: yellow; -fx-font-weight: bold");
			typeDate.setStyle("-fx-control-inner-background: yellow; -fx-font-weight: bold");

			// Ask to proceed
			Alert alert = new Alert(AlertType.NONE);
			alert.setTitle("Confirm Bank Information");
			alert.setContentText("Is the information correct?");
			ButtonType yesButton = new ButtonType("Yes");
			ButtonType noButton = new ButtonType("No", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(yesButton, noButton);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == yesButton) {
				// Call a method to write the information to a text file and then re-open the
				// Main Window
				writeToFile(typeBankName.getText(), amount, typeTime.getText(), typeAPY.getText(), typeDate.getText());
				// OR
				// create a new object of a bank and store the info there.
				bankAdded();
			} else if (result.get() == noButton) {
				// ... user chose NO or closed the dialog
				// reset formatting of the boxes
				typeBankName.setStyle("");
				typeAmount.setStyle("");
				typeTime.setStyle("");
				typeAPY.setStyle("");
				typeDate.setStyle("");
				typeAmount.setText(amount);
			}
		}
	}

	public void bankAdded() throws IOException {
		LoginController.totalNumBanks++;

		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("MainWindow.fxml"));
		Loader.load();

		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		stage.setTitle("Certificate of Deposit Calculator");
		stage.setScene(new Scene(p));
		stage.show();

		Stage stageThis = (Stage) bankName.getScene().getWindow();
		stageThis.close();
	}

	public void writeToFile(String bank, String amount, String time, String apy, String date) {
		try {
			FileWriter fw = new FileWriter("Banks.txt", true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(bank);
			pw.println(amount);
			pw.println(time);
			pw.println(apy);
			pw.println(date);
			pw.print("\n");
			pw.close();
		} catch (IOException e) {
			System.out.println("ERROR!");
		}
	}

	public void cancel() throws IOException {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("MainWindow.fxml"));
		Loader.load();

		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		stage.setTitle("Certificate of Deposit Calculator");
		stage.setScene(new Scene(p));
		stage.show();

		Stage stageThis = (Stage) bankName.getScene().getWindow();
		stageThis.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Alert v1 = new Alert(AlertType.INFORMATION);
		v1.setTitle("Version 1.0 Notice");
		v1.setHeaderText(null);
		v1.setContentText("Note, error checking is not complete.\n Please enter information correctly and carefully.");
		v1.showAndWait();
	}
}
