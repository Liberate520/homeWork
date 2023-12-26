package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class SetChild extends Command{
    public SetChild(ConsoleUI consoleUI){
        super("Set a child to a family member", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        getConsoleUI().getFamilyTreeInfo();
        System.out.println("Pick child ID:\n");
        String strChildId = scanner.nextLine();
        long childId = Long.parseLong(strChildId);
        getConsoleUI().getFamilyTreeInfo();
        System.out.println("Pick parent ID:\n");
        String strParentId = scanner.nextLine();
        long parentId = Long.parseLong(strParentId);
        if (childId != parentId){
            getConsoleUI().setChild(childId, parentId);
            getConsoleUI().setParent(parentId, childId);
            System.out.println("Done\n");
        } else {
            System.out.println("Invalid input\n");
        }
    }
}
