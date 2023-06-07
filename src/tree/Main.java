package tree;

import tree.geneticTree.Tree;
import tree.human.Gender;
import tree.human.Human;
import tree.saveLoad.Write;
import tree.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addHuman("Anton", LocalDate.of(1988, 03, 29), Gender.Male);
        service.addHuman("Nataliya", LocalDate.of(1994, 06, 20), Gender.Female);
        service.addHuman("Artem", LocalDate.of(2020, 02, 16), Gender.Male, service.getByName("Anton"), service.getByName("Nataliya"));
        service.addHuman("Alexander", LocalDate.of(2021, 03, 01), Gender.Male, service.getByName("Anton"), service.getByName("Nataliya"));
        System.out.println(service.getInfo());

        service.sortByAge();
        System.out.println(service.getInfo());

        service.sortByName();
        System.out.println(service.getInfo());

        service.save("qwe.txt");

//        service.load("qwe.txt"); вф


        System.out.println(service.getInfo());
    }
}



