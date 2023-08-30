package model.service;

import model.human.Gender;
import model.human.Human;
import model.tree.Node;
import model.tree.humanGroup.HumanGroupItem;
import model.tree.humanGroup.ListAllHuman;

import java.time.LocalDate;
import java.util.Scanner;


public class Service<E extends HumanGroupItem> {
    private ListAllHuman<E> listAllHuman;
    private Node tree;

    public Service() {

        listAllHuman = new ListAllHuman<>();
        tree = new Node<>();
    }


    public String getHumanList() {
        StringBuilder builder = new StringBuilder();
        builder.append("Семья:\n");
        for (E human : listAllHuman) {
            builder.append(human);
            builder.append("\n");
        }
        return builder.toString();
    }

    public String sortByName() {
        listAllHuman.sortByName();
        return getHumanList();
    }

    public ListAllHuman<E> getListAllHuman() {
        return listAllHuman;
    }

    public String sortByAge() {
        listAllHuman.sortByAge();
        return getHumanList();
    }


    public String addHumans(String name, String genderHuman, String birthDate) {
        Gender gender = Gender.valueOf(genderHuman);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate);
        listAllHuman.addHumans((E) human);
        return "Человек успешно добавлен в дерево";
    }
    public String searchByName() {
        System.out.println("Введите имя:");
        Scanner scan = new Scanner(System.in);
        String st = scan.nextLine();
        for (E lst : listAllHuman) {
            if (lst.getFullName().equals(st)) {
                return "Имя  " + st + " найдено";
            }
        }
        return "Имя не найдено";

    }

}
