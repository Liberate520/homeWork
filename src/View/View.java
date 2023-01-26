package Seminars_OOP.HW_7.src.View;

import Seminars_OOP.HW_7.src.Presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

//    Scanner scanner = new Scanner(System.in);
    Presenter presenter;

    public void view() {

        List<Options> commandList = new ArrayList<>();

        commandList.add(new CommandGetAllHuman(this));
        commandList.add(new CommandSortByName(this));
        commandList.add(new CommandSortByAge(this));
        commandList.add(new CommandGetHumanByName(this));

        for (int i = 0; i < commandList.size(); i++) {
            System.out.println(i + ": " + commandList.get(i).description());
        }

        Scanner scanner = new Scanner(System.in);
        int menuItem = scanner.nextInt();
        commandList.get(menuItem).execute();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void getHumanByName() {
        System.out.println("Введите имя: ");
        Scanner sc = new Scanner(System.in);
        String nameOfHuman = sc.nextLine();
        presenter.getHumanByName(nameOfHuman);
    }

    public void getAllHuman() {
        presenter.getAllHuman();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

