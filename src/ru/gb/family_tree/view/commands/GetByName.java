package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

import java.util.Scanner;

public class GetByName extends Command {
    public GetByName(Console console) {
        super("Search for a person by name", console);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name:\n");
        String name = scanner.nextLine();
        getConsole().getByName(name);
    }
}
