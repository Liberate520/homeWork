package service;

import service.Persons.Comparators.*;
import service.Persons.Human;
import service.Persons.Person;
import service.io.DataLoad;
import service.io.DataSave;
import service.io.FileHandlerLoad;
import service.io.FileHandlerSaver;
import service.tree.AddToTree.AddPerson;
import service.tree.AddToTree.FillHuman;
import service.tree.FamilyTree;
import service.tree.FindHuman;
import java.io.IOException;

public class Service<T extends Person> {
    private FamilyTree familyTree;
    private Person person;
    private Human human;
    private FindHuman findHuman;
    private AddPerson addPerson;
    private NameComparator nameComparator;
    private SortByDate sortByDate;
    private SortByName sortByName;
    private HumanIterator humanIterator;
    private DateComparator dateComparator;
    private DataSave saveData;
    private DataLoad loadData;

    public Service(FamilyTree familyTree, DataSave saveData, SortByName sortByName, FindHuman findHuman,
                   AddPerson addPerson, SortByDate sortByDate) {
        this.familyTree = familyTree;
        this.addPerson = addPerson;
        this.sortByName = sortByName;
        this.sortByDate = sortByDate;
        this.saveData = saveData;
        this.findHuman = findHuman;
    }
    public void AddPeson() {
        AddPerson addPerson1 = new AddPerson();
        FillHuman fillHuman1 = new FillHuman();
        System.out.println("Дерево: " + addPerson1.addPerson(fillHuman1.fillByHuman()));
    }
    public void FindHuman()
    {
        AddPerson addPerson3 = new AddPerson();
        FillHuman fillHuman3 = new FillHuman();
        FamilyTree familyTree3 = new FamilyTree();
        familyTree3 = addPerson3.addPerson(fillHuman3.fillByHuman());
        FindHuman findHuman = new FindHuman();
        findHuman.findHuman(familyTree3);
    }

    public void SortByName() {
        AddPerson addPerson = new AddPerson();
        FillHuman fillHuman = new FillHuman();
        FamilyTree familyTree1 = addPerson.addPerson(fillHuman.fillByHuman());
        sortByName.sortByName1(familyTree1);
        System.out.println("Список, отсортированный по имени: " + familyTree1);
    }

    public void SortByDate() {
        AddPerson addPerson = new AddPerson();
        FillHuman fillHuman = new FillHuman();
        FamilyTree familyTree1 = addPerson.addPerson(fillHuman.fillByHuman());
        sortByDate.sortByDate(familyTree1);
        System.out.println("Список, отсортированный по дате смерти: " + familyTree1);
    }

    public void DataSaveFile() throws IOException, ClassNotFoundException {
        DataSave dataSave = new FileHandlerSaver();
        dataSave.saveData(familyTree);
    }

    public void DataLoadFile() throws IOException, ClassNotFoundException {
        DataLoad dataLoad = new FileHandlerLoad();
        familyTree = (FamilyTree<Person>) dataLoad.loadData("familyTree.ser");


    }
}

