package model;

import model.familyTree.FamilyTree;
import model.person.Person;
import model.person.Relation;
import model.person.Sex;
import model.saving.FileOutStr;
import model.saving.LoadFromFile;
import model.saving.SaveInFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Service {
    private FamilyTree<Person> activeTree;
    private List<FamilyTree<Person>> familyTreeList;

    public Service(FamilyTree<Person> tree) {
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }

    public Service(){
        this(new FamilyTree<Person>());
    }

    public void addFamilyTree(FamilyTree<Person> familyTree){
        familyTreeList.add(familyTree);
    }

    public void addPerson(String firstName, String lastName, int age, String gender){
        Sex sex = (gender.toLowerCase().equals("м")) ? Sex.Male: Sex.Female;
        activeTree.pushToTree(new Person(firstName, lastName, age, sex));
    }

    public void addPersonAs(String firstName, String lastName, int age, String gender,
                            String targetFirstName, String targetLastName, String relation){

        Sex sex = (gender.toLowerCase().equals("м")) ? Sex.Male: Sex.Female;
        Person person = new Person(firstName, lastName, age, sex);
        activeTree.pushToTree(person);
        Person targetPerson = getPerson(targetFirstName, targetLastName);
        if (targetPerson != null) {
            switch (relation.toLowerCase()) {
                case "сп" -> activeTree.pushSpouseToSet(targetPerson, person);
                case "о" -> activeTree.pushFatherToSet(targetPerson, person);
                case "м" -> activeTree.pushMotherToSet(targetPerson, person);
                case "б" -> activeTree.pushBrotherToSet(targetPerson, person);
                case "ст" -> activeTree.pushSisterToSet(targetPerson, person);
                case "сн" -> activeTree.pushSonToSet(targetPerson, person);
                case "д" -> activeTree.pushDaughterToSet(targetPerson, person);
            }
        }
    }

    public Person getPerson(String firstName, String lastName) {
        for (Person item: activeTree) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return item;
            }
        }
        return null;
    }

    public String getInfo(String firstName, String lastName, String rel) {
        Relation relation = switch (rel.toLowerCase()) {
            case "м" -> Relation.Mother;
            case "о" -> Relation.Father;
            case "сп" -> Relation.Spouse;
            case "б" -> Relation.Brother;
            case "ст" -> Relation.Sister;
            case "сн" -> Relation.Son;
            case "д" -> Relation.Daughter;
            default -> null;
        };
        return activeTree.getInfo(firstName, lastName, relation);
    }

    public String getInfo(String firstName, String lastName) {
        return activeTree.getInfo(firstName, lastName);
    }

    public String getTreeInfo(){
        StringBuilder output = new StringBuilder();
        output.append("-----Записи Фамильного Древа:-----" + "\n");
        if (this.getCountPerson() != 0) {
            for (Person item: activeTree) {
                output.append(item + "\n");
            }
        } else {
            output.append("Записей нет." + "\n");
        }
        output.append("---------------------------------" + "\n");
        return output.toString();
    }

    public int getCountPerson() {
        return activeTree.getCountPerson();
    }

    public String printSortByLastName(){
        StringBuilder output = new StringBuilder();
        TreeSet<Person> personSet = activeTree.getTreeSortByLastName();
        output.append("---Персоны (сортировка по Фамилиям)---" + "\n");
        if (this.getCountPerson() != 0) {
            for (Person person: personSet) {
                output.append("ID: " + person.getId() + " " + person.getFirstName() +
                        " " + person.getLastName() + " " + person.getAge() + "\n");
            }
        } else {
            output.append("Список пуст." + "\n");
        }
        output.append("--------------------------------------");
        return output.toString();
    }

    public String printSortByFirstName(){
        StringBuilder output = new StringBuilder();
        TreeSet<Person> personSet = activeTree.getTreeSortByFirstName();
        output.append("----Персоны (сортировка по Именам)----" + "\n");
        if (this.getCountPerson() != 0) {
            for (Person person: personSet) {
                output.append("ID: " + person.getId() + " " + person.getFirstName() +
                        " " + person.getLastName() + " " + person.getAge() + "\n");
            }
        } else {
            output.append("Список пуст." + "\n");
        }
        output.append("--------------------------------------");
        return output.toString();
    }

    public String printSortByAge(){
        StringBuilder output = new StringBuilder();
        TreeSet<Person> personSet = activeTree.getTreeSortByAge();
        output.append("----Персоны (сортировка по Именам)----" + "\n");
        if (this.getCountPerson() != 0) {
            for (Person person: personSet) {
                output.append("ID: " + person.getId() + " " + person.getFirstName() +
                        " " + person.getLastName() + " " + person.getAge() + "\n");
            }
        } else {
            output.append("Список пуст." + "\n");
//            System.out.println("Список пуст.");
        }
        output.append("--------------------------------------");
        return output.toString();
    }

    public void saveFamilyTreeAs(String path, FileOutStr format) throws IOException {
        format.saveFamilyTreeAs(activeTree, path);
    }

    public void saveFamilyTreeAs(String path) throws IOException {
        SaveInFile saveInFile = new SaveInFile();
        saveInFile.saveObjectAs(activeTree, path);
    }

    public void loadFamilyTreeFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        activeTree = format.getFamilyTreeFrom(path);
    }

    public void loadFamilyTreeFrom(String path) throws IOException, ClassNotFoundException {
        LoadFromFile loadFromFile = new LoadFromFile();
        activeTree = (FamilyTree) loadFromFile.loadObjectFrom(path);
    }

    public void savePersonAs(Person person, String path, FileOutStr format) throws IOException {
        format.savePersonAs(person, path);
    }

    public Person loadPersonFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        return format.getPersonFrom(path);
    }
}
