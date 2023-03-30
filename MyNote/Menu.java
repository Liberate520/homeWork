package MyNote;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import javax.swing.text.View;

import MyNote.Commands.AddRecord;
import MyNote.Commands.Command;
import MyNote.Commands.PrintNotebook;
import MyNote.Commands.RemoveRecord;



public class Menu {

    private Scanner scanner;
    private View view;
    private Presenter presenter;
    private Map<Integer, Command> commands;
  

    Menu(Presenter presenter, View view) {
        this.presenter=presenter;
        this.view=view;
        scanner = new Scanner(System.in);
        commands = new HashMap<>();
        commands.put(1, new AddRecord());
        commands.put(2, new RemoveRecord());
        commands.put(3, new PrintNotebook());
    }
 

  
    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = readChoice();
            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Пока!");
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить запись");
        System.out.println("2. Удалить запись");
        System.out.println("3. Напечатать записную книжку");
        System.out.println("0. Выход");
    }

    private int readChoice() {
        System.out.print("Введите пункт меню: ");
        int index=scanner.nextInt();
        return index;
    }



    

}
