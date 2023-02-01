package Homework_006.view;

import Homework_006.controller.Controller;
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
        commandList.add(new CommandReadTree());
        commandList.add(new CommandShow());
        commandList.add(new CommandCreateNode());
        commandList.add(new CommandSortById());
        commandList.add(new CommandSortDate());
        commandList.add(new CommandSaveTree());
        commandList.add(new CommandSetParent());
        commandList.add(new CommandShowParrent());
        commandList.add(new CommandShowBrothersAndSisters());
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
        int command = getNumber();
        if (command>=1 && command<=commandListSize) {
            return command;
        } else {
            System.out.println("Команда не распознана.");
            command = scan(commandListSize);
        }
        return command;
    }
    
    @Override
    public ArrayList<String> createNodeForm() {
        ArrayList<String> prop = new ArrayList<>();
        System.out.println("Введите имя:");
        prop.add(scanner.next());
        System.out.println("Введите пол:");
        prop.add(scanner.next());
        System.out.println("Введите дату:");
        prop.add(scanner.next());
        return prop;
    }
    
    @Override
    public int[] setParentForm() {
        int[] ids = new int[2];
        ids[0]=requestChildId();
        ids[1]=requestParentId();
        while (ids[0]==ids[1]){
            System.out.println("id должны быть разными");
            ids[0]=requestChildId();
            ids[1]=requestParentId();
        }
        return ids;
    }
    
    @Override
    public Integer requestChildId(){
        System.out.println("Введите id ребенка:");
        return getNumber();
    }


    @Override
    public Integer requestParentId(){
        System.out.println("Введите id родителя:");
        return getNumber();
    }
   

    @Override
    public Integer requestNodeId(){
        System.out.println("Введите id:");
        return getNumber();
    }


    private int getNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз:");
            scanner.next();
        }
        return scanner.nextInt();
    }
  
  
    @Override
    public void answerIdAbsent(int id) {
        if (id == -1){
            System.out.println("Указанные id не существуют в дереве");
        } else {
            System.out.println("id"+ id + " не существует в дереве");
        }
    }

    @Override
    public void answerNoData() {
        System.out.println("Нет данных\n");
    }

    @Override
    public void answer(Object obj) {
        System.out.println(obj + "\n");
    }



}
