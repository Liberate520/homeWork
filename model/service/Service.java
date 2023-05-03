package model.service;

import java.io.Serializable;

import javax.print.attribute.standard.Severity;

import human.Human;
import model.saveFile.FileHandler;
import model.saveFile.ReadingFile;
import model.saveFile.SaveFile;
import model.saveFile.Writable;
import model.serch.Search;
import model.sort.HumanComparatorByName;
import model.sort.HumanComparatorbyBirthDate;
import model.tree.FamilyTree;
import model.tree.InformationAdd;

public class Service {

    private FamilyTree<Human> humanList;

    public Service(FamilyTree<Human> humanList) {
        this.humanList = humanList;
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

        SaveFile saveFile = new SaveFile();
        saveFile.saveFile(humanList);

    }

    public void read() {
        ReadingFile readingFile = new ReadingFile();
        readingFile.readFile();
    }

    public void print() {
        System.out.println(humanList.getInfo());
    }

    public String get(String all) {

        Search serchPerson = new Search(humanList);
        return serchPerson.getInformationName(all, humanList).toString();

    }

    public String getNote(String name, String father, String mother, String year) {

        InformationAdd personAdd = new InformationAdd(humanList);
        return personAdd.toFamilyTree(name, father, mother, year, humanList);

    }
}
