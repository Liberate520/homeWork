package ru.gb.general_methods;

public class IsNumeric<E> {
    private int maxValue;
    private int minValue;
    private String object;

    public IsNumeric( int minValue, int maxValue, E checkingValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.object = checkingValue.toString();
    }

    private boolean isNumeric() {
        if (object.isEmpty()) {
            return false;
        }
        for (int i = 0; i < object.length(); i++) {
            //todo
        }
        return true;
    }

}
