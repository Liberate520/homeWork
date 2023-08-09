package ru.gb;

import ru.gb.view.ConsoleUI;
import ru.gb.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
    }
}
