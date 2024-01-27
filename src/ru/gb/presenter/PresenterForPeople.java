package ru.gb.presenter;

import ru.gb.model.person.Person;
import ru.gb.model.service.ServiceForPeople;
import ru.gb.model.treeItem.Gender;
import ru.gb.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.time.LocalDate;

public class PresenterForPeople implements Serializable {
    private ServiceForPeople service;
    private View view;

    public PresenterForPeople(View view) {
        this.view = view;
        service = new ServiceForPeople();
        service.createEmptyFamilyTree();
    }

    public void createNewFamilyTree() {
        service.createEmptyFamilyTree();
    }

    public Person getInfoByName(String name, int treeIndex) {
        return service.getByName(name, treeIndex);
    }

    public void getAllTreesInfo() {
        view.printAnswer(service.getInfo());
    }

    public void saveTrees() throws IOException {
        try {
            service.saveTrees();
        } catch (NotSerializableException e) {
            System.out.println("Древо уже было сохранено ранее");
        }
    }

    public void loadAllTrees() throws IOException {
        try {
            service = new ServiceForPeople(service.loadTrees());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addItemToFamilyTree(String name, Gender gender, LocalDate birthDate, int treeIndex) {
        service.addItem(service.createPerson(name, gender, birthDate), treeIndex);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void addMom(String momName, String childName, int treeIndex) {
        service.addMom(momName, childName, treeIndex);
    }

    public void addDad(String dadName, String childName, int treeIndex) {
        service.addDad(dadName, childName, treeIndex);
    }

    public void addChild(String parentName, String childName, int treeIndex) {
        service.addChild(parentName, childName, treeIndex);
    }

    public Gender strToGender(String genderStr) {
        if (Gender.Male.toString().equalsIgnoreCase(genderStr)) {
            return Gender.Male;
        } else {
            return Gender.Female;
        }
    }

    public void setDeathDate(String name, int treeIndex, LocalDate deathDate) {
        service.setDeathDate(name, treeIndex, deathDate);
    }
    public int getAmountOfTrees() {
        return service.getAmountOfTrees();
    }
}
