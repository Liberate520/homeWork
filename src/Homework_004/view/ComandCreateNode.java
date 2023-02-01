package Homework_004.view;

import java.util.ArrayList;
import java.util.Scanner;

import Homework_004.controller.Controller;

public class ComandCreateNode implements CommandOption  {
    
    @Override
    public String discription() {
        return "Добавить запись";
    }

    @Override
    public void exec(Controller controller) {
        Scanner scanner = new Scanner(System.in, "CP866");
        ArrayList<String> prop = new ArrayList<>();
        System.out.println("Введите имя:");
        prop.add(scanner.next());
        System.out.println("Введите пол:");
        prop.add(scanner.next());
        System.out.println("Введите дату:");
        prop.add(scanner.next());
     
        controller.createNode(prop);
        System.out.println("Запись добавлена");

    }
}
