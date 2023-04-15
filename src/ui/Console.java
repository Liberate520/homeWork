package ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import human.Family;
import human.Human;
import presenter.Presenter;

public class Console implements Iview {

    private Scanner scanner;
    private Presenter presenter;
    boolean work;
    private Menu menu;
    public Console(){
        scanner = new Scanner(System.in);
    }
    public static List<Human<Family>> humans = new ArrayList<>();
    List<Commands> commands;

    public Scanner getScanner(){
        return scanner;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));

            } else {
                System.out.println("что-то пошло не так");
            }
        }
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }

    private void hello() {
        System.out.println(menu.printMenu());
    }

    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }

}
