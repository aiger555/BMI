package com.example.bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private void calculateBMI(ActionEvent event) {
        try {
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());
            double bmi = calculateBMIValue(weight, height);
            resultLabel.setText("Your BMI: " + String.format("%.2f", bmi));
            String status = getBMIStatus(bmi);
            statusLabel.setText(status);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid values.");
        }
    }

    private double calculateBMIValue(double weight, double height) {
        return weight / (height * height);
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
