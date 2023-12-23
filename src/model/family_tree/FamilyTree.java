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

    public T getFirstMember() {
        return familyTree.getFirst();
    }

    public boolean setSpouse(T firstSpouce, T secondSpouce) {
        if (firstSpouce == null || secondSpouce == null || firstSpouce.equals(secondSpouce)) {
            return false;
        } else {

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
    }

    public boolean divorce(T firstSpouce, T secondSpouce) {
        if (firstSpouce == null || secondSpouce == null) {
            return false;
        } else {
            return firstSpouce.equals(secondSpouce.getSpouse()) && firstSpouce.setSpouse(null)
                    && secondSpouce.setSpouse(null);
        }
    }

    public boolean setMother(T child, T mother) {
        if (child == null || mother == null || !child.equals(mother)) {
            return false;
        } else {
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
    }

    public boolean setChildren(T parent, T child) {
        if (parent == null || child == null || parent.equals(child)) {
            return false;
        } else {
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
    }

    public boolean setFather(T child, T father) {
        if (child == null || father == null || child.equals(father)) {
            return false;
        } else {
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
                new Human(id, null, null, null, null),
                new CreatureComporatorById());
        if (finalId >= 0) {
            return familyTree.get(finalId);
        } else {
            finalId = Collections.binarySearch(notInTree,
                    new Human(id, null, null, null, null),
                    new CreatureComporatorById());
            if (finalId >= 0) {
                return notInTree.get(finalId);
            }

        }
        return null;
    }

    public boolean addCreature(T creature) {
        if (getNotInTree().contains(creature) || familyTree.contains(creature)) {
            return false;
        } else {
            getNotInTree().add(creature);
            return true;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<T>(familyTree);
    }

    public boolean emptyCheck() {
        if (familyTree.isEmpty())
            return false;
        else {
            return true;
        }
    }

    public String showIsNotInTree() {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (notInTree.isEmpty()) {
            sb.append("Элементы вне дерева отсутствуют");
            return sb.toString();
        } else {
            sb.append("Еще не добавлены в дерево:\nID  Name  BirthDate\n");
            for (Creature creature : notInTree) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
                flag = true;
            }
            return sb.toString();
        }
    }

    public String showTree() {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        if (familyTree.isEmpty()) {
            return sb.append("Дерево пустое").toString();
        } else {
            sb.append("Дерево состоит из следующих членов\n(ID)  Name  Birthdate\n");
            for (Creature creature : familyTree) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
                flag = true;
            }
        }
        return sb.toString();
    }

    public String showAll() {
        StringBuilder sb = new StringBuilder();
        if (familyTree.isEmpty() && notInTree.isEmpty()) {
            return sb.append("Добавленных людей нет").toString();
        } else {
            boolean flag1;
            sb.append("Все добавленные люди:\nID  Name  Birthdate");
            for (Creature creature : familyTree) {
                sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
            }
            for (Creature creature : notInTree) {
                sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
            }
        }
        return sb.toString();
    }
}



