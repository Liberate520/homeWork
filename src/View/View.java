package Seminars_OOP.HW_5.src.View;

import Seminars_OOP.HW_5.src.Presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    Scanner scanner;
    Presenter presenter;
    public Scanner name;

    public void view() {
        View view = new View();
        List<Options> commandList = new ArrayList<>();

        commandList.add(new CommandGetHumanByName(this));
        commandList.add(new CommandGetAllHuman(this));
//        commandList.add(new CommandReadFamilyTree());
//        commandList.add(new CommandSortByName());
//        commandList.add(new CommandSortByAge());

        for (int i = 0; i < commandList.size(); i++) {
            System.out.println(i + ": " + commandList.get(i).description());
        }
        scanner = new Scanner(System.in);
        int menuItem = scanner.nextInt();
        commandList.get(1).execute();

    }
//    public void readFamilyTree(){
//        presenter.readFamilyTree();
//    }

//    public Human getHumanByName(String ) {
//        presenter.getHumanByName();
//    }

//    public void sortByName() {
//    }
//
//    public void sortByAge() {
//    }

    public void GetAllHuman() {

    }

    public void HumanByName() {
        Presenter.getHumanByName(new Scanner(System.in));
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

