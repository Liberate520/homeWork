package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

import java.util.Scanner;

public class SetWedding extends Command{
    public SetWedding(ConsoleUI consoleUI){
        super("Set wedding", consoleUI);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        getConsoleUI().getFamilyTreeInfo();
        System.out.println("Pick 1-st human ID:\n");
        String strHumanId1 = scanner.nextLine();
        long humanId1 = Long.parseLong(strHumanId1);
        getConsoleUI().getFamilyTreeInfo();
        System.out.println("Pick 2-nd human ID:\n");
        String strHumanId2 = scanner.nextLine();
        long humanId2 = Long.parseLong(strHumanId2);
        if (humanId1 != humanId2){
            getConsoleUI().setWedding(humanId1, humanId2);
            System.out.println("Done\n");
        } else {
            System.out.println("Invalid input\n");
        }
    }
}
