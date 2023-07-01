package FamilyTree.model;

import FamilyTree.model.fileHandler.FileHandler;
import FamilyTree.model.fileHandler.SaveLoader;
import FamilyTree.model.person.CreatePerson;
import FamilyTree.model.person.Gender;
import FamilyTree.model.person.Person;
import FamilyTree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service{
    private int id;
    private FamilyTree<Person> familyTree;
    private SaveLoader fileHandler;

    public Service() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public FamilyTree<Person> loadTree(String path) {
        return familyTree = fileHandler.load(path);
    }

    public boolean saveTree(String path) {
        return fileHandler.save(familyTree, path);
    }

    public void createPerson(String name, String inputGender, LocalDate dateOfBirth, String inputMotherName, String inputFatherName) {
        CreatePerson cp = new CreatePerson(familyTree);
        Person person = cp.createPerson(name, inputGender, dateOfBirth, inputMotherName, inputFatherName);
//        Gender gender = Gender.valueOf(inputGender);
//        Person mother = familyTree.getByName(inputMotherName);
//        Person father = familyTree.getByName(inputFatherName);
//        Person person = new Person(name, gender, dateOfBirth, mother, father);
        familyTree.addPerson(person);
    }

    public void addPerson(Person person) {
        familyTree.addPerson(person);
    }

    public Person getByName(String name) {
        return familyTree.getByName(name);
    }

    public String getFamilyTreeInfo() {

//        StringBuilder stringBuilder = new StringBuilder();
//
////        Iterator<Person> iterator = new familyTree.iterator();
////        while (iterator.hasNext()) {
////            Person person = iterator.next();
////            stringBuilder.append(person).append("\n");
////        }
//
//        for (Person person : familyTree) {
//            stringBuilder.append(person).append("\n");
//        }
//        return stringBuilder.toString();

        return familyTree.getFamilyTreeInfo();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

}