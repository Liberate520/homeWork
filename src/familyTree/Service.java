package familyTree;

import familyTree.enums.Gender;
import familyTree.treeWorkspace.FamilyTree;
import familyTree.treeWorkspace.Person;
import familyTree.treeWorkspace.TreeLoader;
import familyTree.treeWorkspace.Writable;

import java.time.LocalDate;

public class Service {
    // Класс агрегатор
    private FamilyTree<Person> currentTree;

    public Service() {
        currentTree = new FamilyTree<>();
    }

    public boolean addPerson(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        int id = currentTree == null ? 0 : currentTree.getMaxId();
        Person tmpPerson = new Person(id, name, gender, birthDate, deathDate);
        return currentTree.addPerson(tmpPerson);
    }

    public FamilyTree<Person> getCurrentTree() {
        return currentTree;
    }

    public Person findPerson(int id) {
        return currentTree.findPerson(id);
    }

    public Person findPerson(String name, Gender gender) {
        return currentTree.findPerson(name, gender);
    }

    public String getInfo() {
        return currentTree.toString();
    }

    public void sortByName() {
        currentTree.sortByName();
    }

    public void sortByAge() {
        currentTree.sortByAge();
    }

    public void sortByGender() {
        currentTree.sortByGender();
    }

    public void saveTree(String path) {
        Writable treeLoader = new TreeLoader();
        treeLoader.saveTree(currentTree, path);
    }

    public FamilyTree<Person> loadTree(String path) {
        TreeLoader treeLoader = new TreeLoader();
        currentTree = (FamilyTree<Person>) treeLoader.loadTree(path);
        return (FamilyTree<Person>) treeLoader.loadTree(path);
    }
}
