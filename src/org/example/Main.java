package org.example;

import View.View;
import View.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}