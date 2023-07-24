package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.family_tree.FamilyTreeItem;
import family_tree.model.writer.FileHandler;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class FamilyTreeService<E extends FamilyTreeItem<E> & Serializable> {
    private FamilyTree<E> familyTree;
    private FileHandler fileHandler;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public void addPerson(E person) {
        familyTree.add(person);
    }

    public E getPersonByName(String name) {
        return familyTree.getByName(name);
    }

    public List<E> getAllPersons() {
        return familyTree.getHumanList();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void saveFamilyTree(String filePath) throws IOException {
        fileHandler.save(familyTree, filePath);
    }

    public void loadFamilyTree(String filePath) throws IOException, ClassNotFoundException {
        FamilyTree<E> loadedFamilyTree = (FamilyTree<E>) fileHandler.read(filePath);
        if (loadedFamilyTree != null) {
            familyTree = loadedFamilyTree;
        }
    }
}

