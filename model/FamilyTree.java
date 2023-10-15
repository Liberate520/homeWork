package homeWork3.model;

import homeWork3.comparator.PetIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends PetFamily> implements Iterable<T>, Serializable {
    private List<T> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addFamilyTree(T human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            if (human.getMother() != null) {
                human.getMother().addKid(human);
            }
            if (human.getFather() != null) {
                human.getFather().addKid(human);
            }
        }
    }

    @Override
    public String toString() {
        String res = "В семье " + familyTree.size() + " человек:\n";
        for (int i = 0; i < familyTree.size(); i++) {
            res += (i + 1) + ") " + familyTree.get(i).toString() + "\n";
        }
        return res;
    }

    public T getByName(String humanName) {
        for (T human : familyTree) {
            if (human.getName().equalsIgnoreCase(humanName)) {
                return human;
            }
        }
        return null;
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new PetIterator<T>(familyTree);
    }

    public void saveObject(WorkWithFile save) {
        save.save("FamilyTree.txt", this);
    }

}