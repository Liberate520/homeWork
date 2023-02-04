package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Controller.Controller;
import View.Command.Option;
import View.Command.PrintHuman;
import View.Command.PrintHumanChild;
import View.Command.PrintHumanFather;
import View.Command.PrintHumanMother;
import View.Command.PrintHumanSistBroth;
import View.Command.PrintHumanTreeConsole;
import View.Command.PrintHumanTreeFile;
import View.Command.PrintHumanTreeSortByBirth;
import View.Command.PrintHumanTreeSortByName;

public class View {

    private Scanner scanner;
    Controller controller;
    int order;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void orderHuman() {
        System.out.println("Choose number of human in order of HumanTree:");
        this.order = scanner.nextInt();
        if (!controller.orderCheck(order)) {
            System.out.println("Human is absent");
            orderHuman();
        }
    }

    public void user(List<Option> commandList) {
        System.out.println("Choose number of action: 1. HumanList. 2. Human.");
        int chooseAction = scanner.nextInt();
        if (chooseAction == 1) {
            commandList.add(new PrintHumanTreeConsole(this));
            commandList.add(new PrintHumanTreeFile(this));
            commandList.add(new PrintHumanTreeSortByBirth(this));
            commandList.add(new PrintHumanTreeSortByName(this));
            action(commandList, chooseAction);
        } else if (chooseAction == 2) {
            commandList.add(new PrintHuman(this));
            commandList.add(new PrintHumanChild(this));
            commandList.add(new PrintHumanSistBroth(this));
            commandList.add(new PrintHumanFather(this));
            commandList.add(new PrintHumanMother(this));
            orderHuman();
            action(commandList, chooseAction);
        } else {
            System.out.println("Select uncorrect number of action.");
            user(commandList);
        }
    }

    public void action(List<Option> commandList, int chooseAction) {
        System.out.println("Choose number of action:");
        for (int index = 0; index < commandList.size(); index++) {
            System.out.println((index + 1) + ". " + commandList.get(index).discription());
        }
        int chooseCommand = scanner.nextInt();
        if (chooseCommand <= commandList.size()) {
            if (chooseAction == 1) {
                commandList.get(chooseCommand - 1).execute();
            } else if (chooseAction == 2) {
                commandList.get(chooseCommand - 1).execute(order);
            }
        } else {
            System.out.println("Select uncorrect number of action.");
            action(commandList, chooseAction);
        }
        System.out.println();        
        restart();  
        scanner.close();          
    }

    public void restart() {
        System.out.println("Do you want to continue working in the application (yes/no)?");
        String work = scanner.next();
        if (work.equals("yes")) {            
            start();
        } else if (work.equals("no")) {
            System.out.println("Goodbay!");            
            return;
        }
        else{
            System.out.println("Insert uncorrect choice, try again");
            restart();
        }
    }

    public void start() {
        List<Option> commandList = new ArrayList<Option>();
        user(commandList);
    }

    public void printConsole() {
        controller.printConsole();
    }

    public void printFile() {
        controller.printFile();
    }

    public void sortHumanByBirth() {
        controller.sortHumanByBirth();
    }

    public void sortHumanByName() {
        controller.sortHumanByName();
    }

    public void printHuman(int order) {
        order = this.order;
        controller.printHuman(order);
    }

    public void printHumanChild(int order) {
        controller.printHumanChild(order);
    }

    public void printHumanMother(int order) {
        controller.printHumanMother(order);
    }

    public void printHumanFather(int order) {
        controller.printHumanFather(order);
    }

    public void printHumanSistBroth(int order) {
        controller.printHumanSistBroth(order);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
