package HW.model;

import HW.model.dataManager.DataSaver;
import HW.model.dataManager.UpDownLoader;
import HW.model.human.Human;
import HW.model.human.enumerate.Sex;
import HW.model.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceHuman {
    FamilyTree<Human> tree;

    public ServiceHuman(FamilyTree<Human> tree) {
        this.tree = tree;
    }

    public List<String> getAllNotes() {
        List<String> newList = new ArrayList<>();
        for (Human human : tree.getAllNotes()) {
            newList.add(human.toString());
        }
        return newList;
    }

    public String getNote(String name, String surname) {
        return tree.findPerson(name, surname).toString();
    }

    public void addNote(String name, String surname, String sex, String dateOfBirth, String dateOfDeath, String fatherName, String fatherSurname, String motherName, String motherSurname) {
        Human father = tree.findPerson(fatherName, fatherSurname);
        Human mother = tree.findPerson(motherName, motherSurname);
        tree.addPerson(new Human(name, surname, getSex(sex), parseDate(dateOfBirth), parseDate(dateOfDeath), father, mother));
    }

    private LocalDate parseDate(String dateString) {
        if (dateString.isEmpty()) return null;
        String[] dateStrings = dateString.split(".");
        return LocalDate.of(Integer.parseInt(dateStrings[0]),
                Integer.parseInt(dateStrings[1]), Integer.parseInt(dateStrings[2]));
    }

    public Sex getSex(String sexStr) {
        return Sex.fromString(sexStr);
    }


    public void doSave() {
        UpDownLoader file = new DataSaver();
        try {
            tree.saver(file);
        } catch (IOException e) {
        }
    }

    public void doRecover() {
        UpDownLoader file = new DataSaver();
        try {
            tree = FamilyTree.recovery(file);
        } catch (IOException | ClassNotFoundException e) {
        }
    }

}
