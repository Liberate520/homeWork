package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class Remove extends Command{
    public Remove(ConsoleUI consoleUI){
        super("Remove from tree", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick ID to remove:\n");
        String strChoice = scanner.nextLine();
        int choice = Integer.parseInt(strChoice);
        getConsoleUI().remove(choice);
        System.out.println("Done\n");
    }
}
