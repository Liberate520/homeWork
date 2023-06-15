package tree;

import tree.model.geneticTree.Tree;
import tree.model.human.Gender;
import tree.model.human.Human;
import tree.presenter.Presenter;
import tree.model.service.Group;
import tree.model.service.Service;
import tree.view.ConsoleUI;
import tree.view.DesktopUI;
import tree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Tree<Human> tree = new Tree<>();
//        Service service = new Service();
//        service.addHuman("Anton", LocalDate.of(1988, 03, 29), Gender.Male);
//        service.addHuman("Nataliya", LocalDate.of(1994, 06, 20), Gender.Female);
//        service.addHuman("Artem", LocalDate.of(2020, 02, 16), Gender.Male, service.getByName("Anton"), service.getByName("Nataliya"));
//        service.addHuman("Alexander", LocalDate.of(2021, 03, 01), Gender.Male, service.getByName("Anton"), service.getByName("Nataliya"));
//        System.out.println(service.getInfo());

        View view = new ConsoleUI();

        view.start();

        System.out.println("-----------------------------");

//        service.sortByAge();
//        System.out.println(service.getInfo());
//
//        service.sortByName();
//        System.out.println(service.getInfo());
//
//        service.save("qwe.txt");

//        service.load("qwe.txt");

//        System.out.println(service.getInfo());
    }
}



