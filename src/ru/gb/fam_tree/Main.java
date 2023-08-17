package ru.gb.fam_tree;

import ru.gb.fam_tree.view.ConsoleUI;
import ru.gb.fam_tree.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
