package Seminar6.src.ui;

import Seminar6.src.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUi implements View {
    int size;
    List<String> list;
    Presenter presenter;
    Scanner scanner;
    public ConsoleUi() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public void addNote(String str) {
        list.add(str);
    }

    @Override
    public String printNote() {

        System.out.printf("запись номер %s\n",++size);
        scanner.nextLine();
        String str = scanner.nextLine();
        return str;


    }



    @Override
    public void allList() {
        System.out.println("Все ваши записи:");
        for (String l :
                list) {
            System.out.println(l);
        }


    }
    public void launch(){
        menu();

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void menu(){
        System.out.println("выберите :");
        System.out.println("1) добавить запись ");
        System.out.println("2) вывести все записи  ");

        int num = scanner.nextInt();

        switch (num){
            case (1)-> presenter.button(printNote());

            case (2)-> allList();

            default -> System.out.println("другие параметры не предусмотрены");

        }

    }

}
