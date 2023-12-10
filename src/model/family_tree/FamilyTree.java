package model.family_tree;

import model.creatures.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Creature<T>> implements Iterable<T>, Serializable {
    private final List<T> familyTree;
    private final List<T> notInTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
        this.notInTree = new ArrayList<>();
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    public List<T> getNotInTree() {
        return notInTree;
    }

    public boolean setSpouse(T firstSpouce, T secondSpouce) {
        if (firstSpouce.getSpouse() == null && secondSpouce.getSpouse() == null) {
            firstSpouce.setSpouse(secondSpouce);
            secondSpouce.setSpouse(firstSpouce);
        } else {
            return false;
        }
        if (!firstSpouce.isInTree()) {
            familyTree.add(firstSpouce);
            firstSpouce.setInTree();
            notInTree.remove(firstSpouce);
        }
        if (!secondSpouce.isInTree()) {
            familyTree.add(secondSpouce);
            secondSpouce.setInTree();
            notInTree.remove(secondSpouce);
        }
        return true;
    }

    public boolean divorce(T firstSpouce, T secondSpouce) {
        if (firstSpouce.equals(secondSpouce.getSpouse())) {
            firstSpouce.setSpouse(null);
            secondSpouce.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean setMother(T child, T mother) {
        child.setMother(mother);
        if (!child.isInTree()) {
            familyTree.add(child);
            child.setInTree();
            notInTree.remove(child);
        }
        if (!mother.isInTree()) {
            familyTree.add(mother);
            mother.setInTree();
            notInTree.remove(mother);
        }
        if (mother.getChildren() != null && mother.getChildren().contains(child)) {
            return false;
        } else {
            mother.setChildren(child);
            return true;
        }
    }

    public boolean setChildren(T parent, T child) {
        if (!child.isInTree()) {
            familyTree.add(child);
            child.setInTree();
            notInTree.remove(child);
        }
        if (!parent.isInTree()) {
            familyTree.add(parent);
            parent.setInTree();
            notInTree.remove(parent);
        }
        if (parent.getChildren() != null && parent.getChildren().contains(child)) {
            return false;
        } else {
            parent.setChildren(child);
            return true;
        }
    }

    public boolean setFather(T child, T father) {
        child.setFather(father);
        if (!child.isInTree()) {
            familyTree.add(child);
            child.setInTree();
            notInTree.remove(child);
        }
        if (!father.isInTree()) {
            familyTree.add(father);
            father.setInTree();
            notInTree.remove(father);
        }
        if (father.getChildren() != null && father.getChildren().contains(child)) {
            return false;
        } else {
            father.setChildren(child);
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Члены данной семьи: \n");
        for (T human : familyTree) {
            sb.append(human.getName()).append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        familyTree.sort(new CreatureComporatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new CreatureComporatorByAge());
    }

    public void sortByID() {
        familyTree.sort(new CreatureComporatorById());
    }

    public T searchById(Integer id) {
        familyTree.sort(new CreatureComporatorById());
        notInTree.sort(new CreatureComporatorById());
        int finalId = Collections.binarySearch(familyTree,
                new Human(id, null, null, null, null), new CreatureComporatorById());
        if (finalId > 0) {
            return familyTree.get(finalId);
        } else if (finalId < 0) {
            finalId = Collections.binarySearch(notInTree,
                    new Human(id, null, null, null, null),
                    new CreatureComporatorById());
            return notInTree.get(finalId);
        } else {
            return null;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<T>(familyTree);
    }


}



