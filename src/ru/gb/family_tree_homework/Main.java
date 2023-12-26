package ru.gb.family_tree_homework;

import ru.gb.family_tree_homework.UI.ConsoleUI;
import ru.gb.family_tree_homework.UI.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}