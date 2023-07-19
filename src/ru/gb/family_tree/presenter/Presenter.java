package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.servise.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class Presenter{
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void getTreeInfo() {
        String answer = service.getTreeInfo();
        System.out.println(answer);
    }

    public void addHuman(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday) {
        service.addHuman(numPassport, surname, name, gender, birthday);
        saveInFile();
        getTreeInfo();
    }

    public void searchHuman(String value) {
        String answerSeach = String.valueOf(service.searchHuman(value));
        System.out.println(answerSeach);
    }

    // TODO доработать addKid
    public void addKid(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday) {
//        getTreeInfo();
//        System.out.println("Выберите родителя из списка (введите номер паспорта): \n");
//        String value = scanner.nextLine();
//        String answer = searchHuman(value);
        service.addToKids(numPassport, surname, name, gender, birthday);
    }

    // TODO доработать addParent
    public void addParent(String surname, String name, Human.Gender gender) {
//        familyTree.addToParents(surname, name, gender);
    }

    // TODO доработать addPartner
    public void addPartner(String surname, String name, Human.Gender gender) {
//        familyTree.addToPartner(surname, name, gender);
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getTreeInfo();
    }

    public void sortByBirthday() {
        service.sortByBirthday();
        getTreeInfo();
    }


    public void saveInFile() {
        service.saveInFile();
    }

    public void loadFromFile() {
        service.loadFromFile();
    }
}