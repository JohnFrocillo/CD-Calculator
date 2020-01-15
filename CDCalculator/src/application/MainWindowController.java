package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {
	

	@FXML
	private Button newCD;

	@FXML
	private Button bank1, bank2, bank3, bank4, bank5, bank6, bank7, bank8, bank9, bank10;

	@FXML
	private void clickBank(final ActionEvent e) throws IOException {
		// CONTINUE
		// HERE****************************************************************************************
		// CREATE A NEW WINDOW TO DISPLAY BANK INFORMATION (new fxml, etc)
		// A parameter for which bank was clicked is needed to be passed
		// This way you can display the correct lines of Banks.txt (ex: bank1 will
		// display lines 1-5)

		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("BankInfo.fxml"));
		Loader.load();

		// Pass the parameter that you are viewing Bank#
		BankInfoController bank = Loader.getController();
		if (e.getSource() == bank1) {
			bank.setBankNum(1);
		}
		if (e.getSource() == bank2) {
			bank.setBankNum(2);
		}
		if (e.getSource() == bank3) {
			bank.setBankNum(3);
		}
		if (e.getSource() == bank4) {
			bank.setBankNum(4);
		}
		if (e.getSource() == bank5) {
			bank.setBankNum(5);
		}
		if (e.getSource() == bank6) {
			bank.setBankNum(6);
		}
		if (e.getSource() == bank7) {
			bank.setBankNum(7);
		}
		if (e.getSource() == bank8) {
			bank.setBankNum(8);
		}
		if (e.getSource() == bank9) {
			bank.setBankNum(9);
		}
		if (e.getSource() == bank10) {
			bank.setBankNum(10);
		}

		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		stage.setTitle(bank.sBankTitle + " Certificate of Deposit");
		stage.setScene(new Scene(p));
		stage.show();
		
		//close the current window in order for it to be refreshed
		//if any changes are made (such as deleting the selected cd)
		Stage stageThis = (Stage)bank1.getScene().getWindow();
		stageThis.close();
	}

	public void newBank() throws IOException {
		// new bank window; enter the info
		// this new window will make a bank object with properties to access
		// save these properties/variables to a text file to be read when the
		// program is reopened.

		// CALL THE NEW WINDOW WITH THE ABILITY TO PASS PARAMS
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("NewBank.fxml"));
		Loader.load();
		// MainWindowController win = Loader.getController();
		// USE win TO CALL METHODS AND PASS THINGS TO THE NEW CONTROLLER
		// win.setButton();
		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		stage.setTitle("Add a New Bank");
		stage.setScene(new Scene(p));
		stage.show();

		Stage stageThis = (Stage)bank1.getScene().getWindow();
		stageThis.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bank1.setVisible(false);
		bank2.setVisible(false);
		bank3.setVisible(false);
		bank4.setVisible(false);
		bank5.setVisible(false);
		bank6.setVisible(false);
		bank7.setVisible(false);
		bank8.setVisible(false);
		bank9.setVisible(false);
		bank10.setVisible(false);

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Banks.txt"));
			int lines = 0;
			while (reader.readLine() != null)
				lines++;
			reader.close();
			LoginController.totalNumBanks = (lines / 6);
		} catch (IOException e) {
			System.out.println("ERROR!");
		}

		if (LoginController.totalNumBanks >= 10) {
			bank10.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 54; i++)
					br.readLine();
				bank10.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 9) {
			bank9.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 48; i++)
					br.readLine();
				bank9.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 8) {
			bank8.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 42; i++)
					br.readLine();
				bank8.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 7) {
			bank7.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 36; i++)
					br.readLine();
				bank7.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 6) {
			bank6.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 30; i++)
					br.readLine();
				bank6.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 5) {
			bank5.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 24; i++)
					br.readLine();
				bank5.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 4) {
			bank4.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 18; i++)
					br.readLine();
				bank4.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 3) {
			bank3.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 12; i++)
					br.readLine();
				bank3.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 2) {
			bank2.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				for (int i = 0; i < 6; i++)
					br.readLine();
				bank2.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (LoginController.totalNumBanks >= 1) {
			bank1.setVisible(true);
			FileInputStream fs;
			try {
				fs = new FileInputStream("Banks.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				bank1.setText(br.readLine());
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
