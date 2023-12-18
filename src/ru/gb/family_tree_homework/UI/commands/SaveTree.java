package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI){
        super("Save family tree", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file name:\n");
        String fileName = scanner.nextLine();
        getConsoleUI().saveTree(fileName);
    }
}
