package Seminars_OOP.HW_6.src.View;

//import Seminars_OOP.HW_6.src.Model.Program;
import Seminars_OOP.HW_6.src.Model.Human;
import Seminars_OOP.HW_6.src.Presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

//    Scanner scanner = new Scanner(System.in);
    Presenter presenter;

    public void view() {

        List<Options> commandList = new ArrayList<>();

        commandList.add(new CommandGetHumanByName(this));
        commandList.add(new CommandGetAllHuman(this));
//        commandList.add(new CommandReadFamilyTree());
//        commandList.add(new CommandSortByName());
//        commandList.add(new CommandSortByAge());

        for (int i = 0; i < commandList.size(); i++) {
            System.out.println(i + ": " + commandList.get(i).description());
        }

        Scanner scanner = new Scanner(System.in);
        int menuItem = scanner.nextInt();
        commandList.get(menuItem).execute();
    }
    public void readFamilyTree(){
    }

    public void sortByName() {
    }

    public void sortByAge() {
    }

    public void GetHumanByName() {
        System.out.println("Введите имя: ");
        Scanner sc = new Scanner(System.in);
        String nameOfHuman = sc.nextLine();
        presenter.getHumanByName(nameOfHuman);
    }

    public void GetAllHuman() {
        presenter.getAllHuman();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

