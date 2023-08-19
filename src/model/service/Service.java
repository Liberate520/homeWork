package model.service;

import model.family_tree.FamilyTree;
import model.person.Gender;
import model.person.Person;
import model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private int idPerson;
    private FamilyTree<Person> tree;

    public Service() {
        tree = new FamilyTree();
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother){
        Person person = new Person(firstName, lastName, gender, birthDate, deathDate, father, mother);
        tree.add(person);
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, Person father, Person mother){
        Person person = new Person(firstName, lastName, gender, birthDate, null, father, mother);
        tree.add(person);
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate){
        Person person = new Person(firstName, lastName, gender, birthDate, null, null, null);
        tree.add(person);
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
