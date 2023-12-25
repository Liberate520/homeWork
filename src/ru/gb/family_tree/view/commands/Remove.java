package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

import java.util.Scanner;

public class Remove extends Command {
    public Remove(Console console) {
        super("Delete an item by ID", console);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose ID:\n");
        String strChoice = scanner.nextLine();
        int choice = Integer.parseInt(strChoice);
        getConsole().remove(choice);
    }
}
