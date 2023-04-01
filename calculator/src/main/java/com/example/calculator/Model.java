package com.example.calculator;

public class Model {

    public float calculator(float num1, float num2, String operator){
        switch (operator){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) return 0;
                return num1 / num2;
        }
        return 0;
    }
}
