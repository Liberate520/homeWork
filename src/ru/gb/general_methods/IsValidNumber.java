package ru.gb.general_methods;

public class IsValidNumber {
    public boolean isNumeric(String checkingValue) {
        if (checkingValue.isEmpty()) {
            return false;
        } else return checkingValue.matches("[0-9]+");
    }

    private boolean isInRange(String checkingValue, int minValue, int maxValue) {
        return Integer.parseInt(checkingValue) >= minValue && Integer.parseInt(checkingValue) <= maxValue;
    }

    public boolean isValidInRange(int minValue, int maxValue, Object checkingValue) {
        return isNumeric(String.valueOf(checkingValue)) && isInRange(String.valueOf(checkingValue), minValue, maxValue);
    }

    public void error() {
        System.out.println("Введите валидное число!");
    }
}
