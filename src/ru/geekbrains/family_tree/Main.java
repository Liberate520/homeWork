package ru.geekbrains.family_tree;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;
import ru.geekbrains.family_tree.view.UserInterface;

public class Main {
    
    public static void main(String[] args) {
        
        UserInterface consoleUserInterface = new ConsoleUserInterface();
        consoleUserInterface.run();

    }

}
