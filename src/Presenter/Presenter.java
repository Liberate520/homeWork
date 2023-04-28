package Presenter;

import Model.FamilyTree;
import Model.service.FileHandlers.FileHandler;
import Model.units.Gender;
import Model.units.Human;
import Model.units.Unit;

import UI.*;

import java.io.IOException;

public class Presenter {
    private Console console;
    private FamilyTree<Unit> tree;

    public Presenter(Console console, FamilyTree tree) {
        this.console = console;
        this.tree = tree;
        console.setPresenter(this);
    }

    public void getInfo() {
        System.out.println(tree.getInfo());
    }

    public void save(String path) throws IOException {
        tree.save(new FileHandler<Human>(), path);
    }

    public void getHumanList() {
        System.out.println("Список людей: ");
        for (Unit unit : tree) {
            System.out.println(unit.getName());
        }
    }

    public void addHuman(String firstName, String secondName, String gender,
                         int birthday, int birthmonth, int birthyear) {
        Gender gender1 = Gender.valueOf(gender);
        tree.add(
                new Human(firstName, secondName, gender1, birthday, birthmonth,
                          birthyear));
    }
}