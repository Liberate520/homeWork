package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Controller.Controller;
import View.Command.Option;
import View.Command.PrintFirstHuman;
import View.Command.PrintFirstHumanChild;
import View.Command.PrintHumanTreeConsole;
import View.Command.PrintHumanTreeFile;
import View.Command.PrintLastFather;
import View.Command.PrintLastHuman;
import View.Command.PrintLastMother;
import View.Command.PrintLastSistBroth;

public class View {

    private Scanner scanner;
    Controller controller;
        
    public View() {
        scanner = new Scanner(System.in);
    }

    public void user(List<Option> commandList){
        

        System.out.println("Choose number of action: 1. HumanList. 2. Human.");
        int chooseAction = scanner.nextInt();
        if (chooseAction == 1) {
            commandList.add(new PrintHumanTreeConsole(this));
            commandList.add(new PrintHumanTreeFile(this));
        } else if (chooseAction == 2) {
            commandList.add(new PrintFirstHuman(this));
            commandList.add(new PrintFirstHumanChild(this));
            commandList.add(new PrintLastHuman(this));
            commandList.add(new PrintLastSistBroth(this));
            commandList.add(new PrintLastFather(this));
            commandList.add(new PrintLastMother(this));

        } else {
            System.out.println("Selecy uncorrect number of action.");
            user(commandList);
        }
    }

    public void start() {        
        List<Option> commandList = new ArrayList<Option>();
        user(commandList);
        System.out.println("Choose number of action:");
        for (int index = 0; index < commandList.size(); index++) {
            System.out.println((index + 1) + ". " + commandList.get(index).discription());
        }

        int myChoose = scanner.nextInt();
        commandList.get(myChoose - 1).execute();

    }

    public void printConsole() {
        controller.printConsole();
    }

    public void printFile() {
        controller.printFile();
    }

    public void printFirst() {
        controller.printFirst();
    }

    public void printFirstChild() {
        controller.printFirstChild();
    }

    public void printLast() {
        controller.printLast();
    }

    public void printLastMother() {
        controller.printLastMother();
    }

    public void printLastFather() {
        controller.printLastFather();
    }

    public void printLastSistBroth() {
        controller.printLastSistBroth();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
