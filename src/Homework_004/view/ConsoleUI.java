package Homework_004.view;

import Homework_004.controller.Controller;
import Homework_004.model.FamilyTree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Controller controller;
    public Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in, "cp866");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() throws ClassNotFoundException, IOException {
        List<CommandOption> commandList = new ArrayList<>();   
        commandList.add(new Command1());
        commandList.add(new Command2());
        commandList.add(new Command3());
        commandList.add(new Command4());
        commandList.add(new Command5());
        commandList.add(new ComandCreateNode());
        commandList.add(new CommandExit());

        boolean flag = true;
        while (flag){
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i+1 + "-" + commandList.get(i).discription());
            }
            int command = scan(commandList.size());
            if (command==commandList.size()){
                flag=false;
                commandList.get(command-1).exec(controller);
            } else {
                commandList.get(command-1).exec(controller);
            }
            System.out.println("======================================================");
        }
    }
                  
    private int scan(int commandListSize) {
        System.out.println("Введите команду:");
        while (!scanner.hasNextInt()) {
            System.out.println("Команда не распознана.");
            System.out.println("Введите команду:");
            scanner.next();
        }
        int command = scanner.nextInt();
        if (command>=1 && command<=commandListSize) {
            return command;
        } else {
            System.out.println("Команда не распознана.");
            command = scan(commandListSize);
        }
        return command;
    }


    @Override
    public void answer(Object ft ) {
        System.out.println(ft + "\n");
     }
}
