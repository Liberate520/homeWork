package home_work;

import home_work.view.ConsoleUI;
import home_work.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}