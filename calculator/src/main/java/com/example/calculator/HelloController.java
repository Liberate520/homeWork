package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;



public class HelloController {
    @FXML
    private Text output;
    private float num1 = 0;


    private boolean start = true;

    private String operator = "";
    private Model model = new Model() ;
    @FXML
    private Label welcomeText;

    public HelloController() {
    }

    @FXML
    protected void onCClick() {
        output.setText("0");
        operator = "";
    }

    @FXML
    private void num (ActionEvent event){
        if(start){
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }



    @FXML
    private void processOperator (ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if(operator.isEmpty()) return;
             output.setText(String.valueOf(model.calculator(num1,Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
