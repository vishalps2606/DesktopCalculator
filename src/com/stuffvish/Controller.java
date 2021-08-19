package com.stuffvish;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label label1, label2, label3;
	@FXML
	public TextField textField1, textField2;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public Button resultButton;

	private static final String add = "ADD";
	private static final String substract = "SUBSTRACT";
	private static final String multiply = "MULTIPLY";
	private static final String divide = "DIVIDE";
	private static final String modulus = "MODULUS";

	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		choiceBox.getItems().add(add);
		choiceBox.getItems().add(substract);
		choiceBox.getItems().add(multiply);
		choiceBox.getItems().add(divide);
		choiceBox.getItems().add(modulus);
		choiceBox.setValue(add);

		resultButton.setOnAction(event -> {
			System.out.println("Button Clicked");
			calculate();
			// more function
		});
	}

	private void calculate() {
		String input1 = textField1.getText();
		String input2 = textField2.getText();

		try {
			float result = 0;
			float enteredNumber1 = Float.parseFloat(input1);
			float enteredNumber2 = Float.parseFloat(input2);

			if (choiceBox.getSelectionModel().getSelectedItem().equals(add))
				result = enteredNumber1 + enteredNumber2;
			else if (choiceBox.getSelectionModel().getSelectedItem().equals(substract))
				result = enteredNumber1 - enteredNumber2;
			else if (choiceBox.getSelectionModel().getSelectedItem().equals(multiply))
				result = enteredNumber1 * enteredNumber2;
			else if (choiceBox.getSelectionModel().getSelectedItem().equals(divide))
				result = enteredNumber1 / enteredNumber2;
			else if (choiceBox.getSelectionModel().getSelectedItem().equals(modulus))
				result = enteredNumber1 % enteredNumber2;

			display(result);

		} catch (Exception exception) {
			warnUser();
		}
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setHeaderText("Warning");
		alert.setContentText("Please Enter valid number");
		alert.show();
	}

	private void display(float result) {
		System.out.println("The result is " + result);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setHeaderText("Result");
		alert.setContentText("The result is " + result);
		alert.show();
	}
}
