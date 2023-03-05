package com.familytree;

public class Input {
    public static boolean isValidOption(int input) {
        return (-1 < input && input < 6) ? true : false;
    }

    public static boolean isValidName(String input) {
        return !input.isEmpty() && input.matches("^[a-zA-Z '.-]*$");
    }
}
