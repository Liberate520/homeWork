package ru.gb.presenter;

import ru.gb.model.service.Service;
import ru.gb.model.treeItem.Gender;
import ru.gb.view.View;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
        service.createEmptyFamilyTree();
    }

    public void addItemToFamilyTree(String name, Gender gender, LocalDate birthDate, int treeIndex) {
        service.addItem(service.createPerson(name, gender, birthDate), treeIndex);
    }

    public void createNewFamilyTree() {
        service.createEmptyFamilyTree();
    }

    public void getInfoByName(String name, int treeIndex) {
        System.out.println(service.getByName(name, treeIndex));
    }

    public void getAllTreesInfo() {
        view.printAnswer(service.getInfo());
    }

    public void saveTrees() throws IOException, ClassNotFoundException {
        service.saveTrees();
    }
    public void loadAllTrees() throws IOException, ClassNotFoundException {
        service.loadTrees();
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
        //TODO: Добавить связь, когда добавляешь ребенку отца, у него должен появиться ребенок
    }

    public void addChild(String parentName, String childName, int treeIndex) {
        service.addChild(parentName, childName, treeIndex);
    }

    public void setGender(String name, String gender, int treeIndex) {
        service.setGender(name, gender, treeIndex);
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

    //TODO: метод загрузки деревьев не работает - поправить
}
