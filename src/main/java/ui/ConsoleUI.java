package ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }


    public void start() {
       int choice = Integer.parseInt(scan("Выберите: 1 - просмотр, 2 - добавить новую запись,3 -выход"));
       presenter.getChois(choice);

    }
    @Override
    public String scan(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public void print(String text) {
        System.out.println(text);
    }
}
