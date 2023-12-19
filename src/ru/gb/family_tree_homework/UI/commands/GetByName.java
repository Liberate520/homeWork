package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class GetByName extends Command{
    public GetByName(ConsoleUI consoleUI){
        super("Get family members by name", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name:\n");
        String name = scanner.nextLine();
        getConsoleUI().getByName(name);
    }
}
