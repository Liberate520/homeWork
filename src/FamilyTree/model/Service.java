package FamilyTree.model;

import FamilyTree.model.fileHandler.FileHandler;
import FamilyTree.model.fileHandler.SaveLoader;
import FamilyTree.model.tree.FamilyTree;
import FamilyTree.model.tree.TreeItem;

public class Service<T extends TreeItem> {
    private int id;
    private FamilyTree<T> familyTree;

    public Service(FamilyTree<T> tree) {
        this.familyTree = tree;
    }

    public Service() {
        this(new FamilyTree<T>());
    }

    public void add(T element) {
        familyTree.add(element);
    }

    public T getByName(String name) {
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
        familyTree = (FamilyTree<T>) fileHandler.load(path);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

}
