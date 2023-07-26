import Class.Human;
import Class.Utils;
import Class.FamilyTree;
import Class.Relation;
import Commands.CFindParents;
import Commands.CLoad;
import Commands.CPrint;
import Commands.CSave;
import Interfaces.ICommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<ICommands> commands;
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Utils utils = new Utils(tree);
        utils.fillTree();

        //добавления команд в меню списком
        commands = new ArrayList<ICommands>();
        commands.add(new CFindParents());
        commands.add(new CPrint());
        commands.add(new CSave());
        commands.add(new CLoad());

        Scanner scanner = new Scanner(System.in);

        do {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            boolean inputGood = false;
            for (ICommands command : commands) {
                if (input.equals(command.getName())) {
                    command.task(scanner, utils);
                    inputGood = true;
                    break;
                }
            }
            if (!inputGood) {
                System.out.println("Команда нераспознана, повторите ввод");
            }
        } while (true);
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("__________________________________________________");
        System.out.println("Меню гениалогического дерева");
        System.out.println("Введите команду из списка: ");
        System.out.println("exit - выход");
        for (ICommands command : commands) {
            System.out.println(command.info());
        }
        System.out.println("__________________________________________________");
    }
}