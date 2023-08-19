package model.service;

import jdk.jshell.PersistentSnippet;
import model.family_tree.FamilyTree;
import model.person.Gender;
import model.person.Person;
import model.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private int idPerson;
    private FamilyTree<Person> tree;

    public Service() {
        tree = new FamilyTree();
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate){
        Person person = new Person(firstName, lastName, gender, birthDate, deathDate);
        tree.add(person);
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate){
        Person person = new Person(firstName, lastName, gender, birthDate, null);
        tree.add(person);
    }

    public void addParent(int childId, int parentId){
        if (tree.addParent(childId, parentId))
            System.out.println("Успешно добавлено\n");
        else
            System.out.println("Ошибка при добавлении\n");
    }

    public String getParents(int childId){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Родители:\n");
        List<Person> parents = tree.getParents(childId);
        for (Person person : parents){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getChildren(int parentId){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дети:\n");
        List<Person> children = tree.getChildren(parentId);
        for (Person person : children){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Person person : tree){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void saveTree(){
        String filePath = "src/model/family_tree/data/tree.out";
        FileHandler fileHandler = new FileHandler();

        fileHandler.save(tree, filePath);
        System.out.println("Древо сохранено");
    }

    public void loadTree(){
        String filePath = "src/model/family_tree/data/tree.out";
        FileHandler fileHandler = new FileHandler();

        tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println("Древо загружено");
    }
}
