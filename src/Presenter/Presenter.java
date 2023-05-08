package Presenter;

import Model.FamilyTree;
import Model.service.Filehandlers.FileHandler;
import Model.service.Filehandlers.Writable;
import Model.service.Service;
import Model.units.Gender;
import Model.units.Unit;
import UI.Console;

import java.io.IOException;

public class Presenter<T extends Unit> {
    private Console console;
    private FamilyTree<T> tree;
    private Service<T> service;

    public Presenter(Console console, FamilyTree<T> tree,
                     FileHandler<T> fh) {
        this.console = console;
        this.tree = tree;
        this.service = new Service<T>(tree, fh);
        console.setPresenter(this);
    }

    public void getInfo() {
        System.out.println(tree.getInfo());
    }

    public void save(String path) throws IOException {
        service.save(path, tree);
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
        service.addHuman(firstName, secondName, gender1, birthday, birthmonth,
                         birthyear);
    }
}