package ui;

import Presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUi implements View{
    private Presenter presenter;
    private Scanner scanner;

    private boolean flag;
public ConsoleUi(){

}

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in);

        flag = true;
        while (flag) {
            printMenu();
            System.out.print("Введите пункт меню:");
            int menuOption = Integer.parseInt(scanner.nextLine());
            presenter.menuInput(menuOption);



        }

    }
        public void printMenu(){
            System.out.println("1.распечатать дерево:");
            System.out.println("2.сохранить дерево:");
            System.out.println("3.загрузить дерево:");
             System.out.println("4.сортировка дерева по фамилиям:");
            System.out.println("5.сортировка дерева по полу:");
            System.out.println("6.сортировка дерева по году рождения:");

        }

    @Override
    public void print(String text) {

    }




}
