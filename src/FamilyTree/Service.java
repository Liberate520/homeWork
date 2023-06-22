package FamilyTree;

import FamilyTree.fileHandler.FileHandler;
import FamilyTree.fileHandler.SaveLoader;
import FamilyTree.person.Person;
import FamilyTree.person.comparators.PersonComparatorByName;
import FamilyTree.tree.FamilyTree;
import FamilyTree.tree.PersonIterator;
import FamilyTree.tree.TreeItem;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Service<T extends TreeItem> {
    private int id;
    private FamilyTree<T> familyTree;

    public Service(FamilyTree<T> tree) {
        this.familyTree = tree;
    }

    public Service() {
        this(new FamilyTree<T>());
    }

    public void addPerson(T person) {
        familyTree.add(person);
    }

    public T getByName(String name) {
        for(T person : familyTree) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
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
        familyTree = (FamilyTree<T>) fileHandler.load(path);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

}
