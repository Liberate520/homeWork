package model.service;

import java.io.Serializable;
import human.Human;
import model.saveFile.FileHandler;
import model.saveFile.Writable;
import model.sort.HumanComparatorByName;
import model.sort.HumanComparatorbyBirthDate;
import model.tree.FamilyTree;
import model.tree.PersonAdd;
import model.tree.SerchPerson;

public class Service {

    private FamilyTree<Human> human;
    private static final String ENPTY_ERROR = "Вы не ввели  ";

    public Service(FamilyTree<Human> human) {
        this.human = human;
    }

    public void sortByName() {
        human.getHumansList().sort(new HumanComparatorByName());
        System.out.println(human.getInfo());
    }

    public void sortBirthDate() {
        human.getHumansList().sort(new HumanComparatorbyBirthDate());
        System.out.println(human.getInfo());
    }

    public void save() {

        Writable writable = new FileHandler();
        writable.save((Serializable) human, "Test.txt");

    }

    public void read() {
        Writable writable = new FileHandler();
        writable.read("Test.txt");
        human = (FamilyTree<Human>) writable.read("Test.txt");
        // System.out.println(human.getInfo());

    }

    public void print() {
        System.out.println(human.getInfo());
    }

    public String get(String all) {
        if (all.isBlank()) {
            System.out.println();
            return ENPTY_ERROR;
        }
        try {
            SerchPerson serchPerson = new SerchPerson(human);
            return serchPerson.getInformation(all, human).toString();

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
            PersonAdd personAdd = new PersonAdd(human);
            return personAdd.toFamilyTree(name, father, mother, year, human);

        } catch (NullPointerException e) {
            return "Неверное введеное имя";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
