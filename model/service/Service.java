package model.service;

import java.io.Serializable;
import human.Human;
import model.saveFile.FileHandler;
import model.saveFile.Writable;
import model.serch.Serch;
import model.sort.HumanComparatorByName;
import model.sort.HumanComparatorbyBirthDate;
import model.tree.FamilyTree;
import model.tree.InformationAdd;

public class Service {

    private FamilyTree<Human> humanList;
    private static final String ENPTY_ERROR = "Вы не ввели  ";

    public Service(FamilyTree<Human> humanList) {
        this.humanList=humanList;
    }

    public void sortByName() {
        humanList.getHumansList().sort(new HumanComparatorByName());
        System.out.println(humanList.getInfo());
    }

    public void sortBirthDate() {
        humanList.getHumansList().sort(new HumanComparatorbyBirthDate());
        System.out.println(humanList.getInfo());
    }

    public void save() {

        Writable writable = new FileHandler();
        writable.save((Serializable) humanList, "Test.txt");

    }

    public void read() {
        Writable writable = new FileHandler();
        writable.read("Test.txt");
        humanList = (FamilyTree<Human>) writable.read("Test.txt");
        // System.out.println(human.getInfo());

    }

    public void print() {
        System.out.println(humanList.getInfo());
    }

    public String get(String all) {
        if (all.isBlank()) {
            System.out.println();
            return ENPTY_ERROR;
        }
        try {
            Serch serchPerson = new Serch(humanList);
            return serchPerson.getInformationName(all, humanList).toString();

        } catch (NullPointerException e) {
            return "Неверное введеное имя";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getNote(String name, String father, String mother, String year) {
        if (name.isBlank()) {
            System.out.println(ENPTY_ERROR);
            return ENPTY_ERROR;
        }
        if (father.isBlank()) {
            System.out.println();
            return ENPTY_ERROR;
        }
        if (mother.isBlank()) {
            System.out.println();
            return ENPTY_ERROR;
        }
        if (year.isBlank()) {
            System.out.println();
            return ENPTY_ERROR;
        }
        try {
            InformationAdd personAdd = new InformationAdd(humanList);
            return personAdd.toFamilyTree(name, father, mother, year, humanList);

        } catch (NullPointerException e) {
            return "Неверное введеное имя";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
