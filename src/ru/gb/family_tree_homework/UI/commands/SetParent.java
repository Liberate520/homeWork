package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class SetParent extends Command{
    public SetParent(ConsoleUI consoleUI){
        super("Set a parent to a family member", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        getConsoleUI().getFamilyTreeInfo();
        System.out.println("Pick parent ID:\n");
        String strParentId = scanner.nextLine();
        long parentId = Long.parseLong(strParentId);
        getConsoleUI().getFamilyTreeInfo();
        System.out.println("Pick child ID:\n");
        String strChildId = scanner.nextLine();
        long childId = Long.parseLong(strChildId);
        if (childId != parentId){
            getConsoleUI().setParent(parentId, childId);
            getConsoleUI().setChild(childId, parentId);
            System.out.println("Done\n");
        } else {
            System.out.println("Invalid input\n");
        }
    }
}
