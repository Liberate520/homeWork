package com.pamihnenkov;

import com.pamihnenkov.model.Human;
import com.pamihnenkov.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
           ConsoleUI<Human> application = new ConsoleUI<>();
           application.start();
    }
}
