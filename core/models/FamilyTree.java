package homeWork3.core.models;

import homeWork3.core.mvp.Model;
import homeWork3.core.infrastructure.PetIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Model> implements Iterable<T>, Serializable {
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
        StringBuilder res = new StringBuilder("В семье " + familyTree.size() + " человека:\n");
        for (int i = 0; i < familyTree.size(); i++) {
            res.append((i + 1)).append(") ").append(familyTree.get(i).toString()).append("\n");
        }
        return res.toString();
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
        return new PetIterator<>(familyTree);
    }

    public void saveObject(FileStream save) {
        save.save("FamilyTree.txt", this);
    }

}