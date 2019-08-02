package application;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BankInfoController implements Initializable {
	int bankNum = 0;
	String sBankTitle, sAmount, sTerm, sAPY, sDate, sValueToday, sTotalValue, sMaturityDate;
	@FXML
	private Label bankTitle;
	@FXML
	private TextField amount, term, apy, date, valueToday, totalValue, maturityDate;

	public void setBankNum(int bankNum) throws IOException {
		this.bankNum = bankNum;
		displayInfo();
	}

	private void displayInfo() throws IOException {
		FileInputStream fs = new FileInputStream("Banks.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));

		if (bankNum == 1) {
			// pull all the variables from the file
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
		}

		if (bankNum == 2) {
			// Use this to get to specific lines
			for (int i = 0; i < 6; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 3) {
			for (int i = 0; i < 12; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 4) {
			for (int i = 0; i < 18; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 5) {
			for (int i = 0; i < 24; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 6) {
			for (int i = 0; i < 30; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 7) {
			for (int i = 0; i < 36; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 8) {
			for (int i = 0; i < 42; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 9) {
			for (int i = 0; i < 48; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		if (bankNum == 10) {
			for (int i = 0; i < 54; i++)
				br.readLine();
			sBankTitle = br.readLine();
			sAmount = br.readLine();
			sTerm = br.readLine();
			sAPY = br.readLine();
			sDate = br.readLine();
			br.close();
		}

		// make amount formatted as money
		double temp;
		String tempAmount;
		temp = Double.parseDouble(sAmount);
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		tempAmount = currencyFormatter.format(temp);

		bankTitle.setText(sBankTitle);
		amount.setText(tempAmount);
		term.setText(sTerm);
		apy.setText(sAPY + "%");
		date.setText(sDate);

		calculateMaturityPrice();
		calculateCurrentValue();
		calculateMaturityDate();
	}

	private void calculateMaturityPrice() {
		double result, P, r, n, t;
		// use the standard formula A=P(1+r/n)^(nt)
		P = Double.parseDouble(sAmount);
		r = (Double.parseDouble(sAPY)) / 100;
		n = 365;
		t = (Double.parseDouble(sTerm)) / 12;
		result = P * Math.pow((1 + r / n), (n * t));

		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		// set the textfield to show as currency
		totalValue.setText(currencyFormatter.format(result));
	}

	private void calculateCurrentValue() {
		// somehow get values of months, days, and years into numbers to be subtracted
		// this value will be how many days since purchase
		// You can then use this as t in the equation (ex: if it is 50 days, then t=
		// 50/365)

		// split the string to use the year, month, and date separately
		String[] purchaseDate = sDate.split("/");

		// purchase Date
		LocalDate dateBefore = LocalDate.of(Integer.parseInt(purchaseDate[2]),
				Month.valueOf(Month.of(Integer.parseInt(purchaseDate[0])).name()), Integer.parseInt(purchaseDate[1]));

		// Today
		LocalDate dateAfter = LocalDate.now();

		// This is now to be used for "t" in the formula
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

		double result, P, r, n, t;
		// use the standard formula A=P(1+r/n)^(nt)
		P = Double.parseDouble(sAmount);
		r = (Double.parseDouble(sAPY)) / 100;
		n = 365;
		// caste to double
		t = noOfDaysBetween;
		// format it properly in years and as decimal double by dividing
		t = t / 365;
		result = P * Math.pow((1 + r / n), (n * t));

		// Format the result of the equation as money
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		// set the textfield to show as currency
		valueToday.setText(currencyFormatter.format(result));
	}

	private void calculateMaturityDate() {

		// split the string to use the year, month, and date separately
		String[] purchaseDate = sDate.split("/");

		// purchase Date
		LocalDate purchase = LocalDate.of(Integer.parseInt(purchaseDate[2]),
				Month.valueOf(Month.of(Integer.parseInt(purchaseDate[0])).name()), Integer.parseInt(purchaseDate[1]));

		// Maturity Date
		LocalDate date = purchase.plusMonths(Integer.parseInt(sTerm));

		// Format the date
		String formattedDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));

		maturityDate.setText(formattedDate);
	}
	
	public void deleteCD() {
		if(bankNum == 1) {
			// ********** CONTINUE HERE **********
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Version 1.0 Notice");
		alert.setHeaderText(null);
		alert.setContentText("Not supported in this version. Coming soon.\nContact administrator if a deletion is needed.");
		alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}