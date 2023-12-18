package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class LoadTree extends Command{
    public LoadTree(ConsoleUI consoleUI){
        super("Load family tree", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file name:\n");
        String fileName = scanner.nextLine();
        getConsoleUI().loadTree(fileName);
    }
}
