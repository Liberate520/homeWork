package FamilyTree.model;

import FamilyTree.model.fileHandler.FileHandler;
import FamilyTree.model.fileHandler.SaveLoader;
import FamilyTree.model.person.Gender;
import FamilyTree.model.person.Person;
import FamilyTree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree<Person> familyTree;

    public Service(FamilyTree<Person> tree) {
        this.familyTree = tree;
    }

    public Service() {
        this(new FamilyTree<Person>());
    }

    public void add(String name, Gender gender, LocalDate dateOfBirth, Person mother, Person father) {
        Person person = new Person(name, gender, dateOfBirth, mother, father);
        familyTree.add(person);
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

        return familyTree.getFamilyTree();
    }

        public void saveTree(String path) {
        SaveLoader fileHandler = new FileHandler();
        fileHandler.save(familyTree, path);
    }

    public void loadTree(String path) {
        SaveLoader fileHandler = new FileHandler();
        familyTree = (FamilyTree<Person>) fileHandler.load(path);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

}
