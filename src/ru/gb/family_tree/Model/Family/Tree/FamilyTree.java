package ru.gb.family_tree.Model.Family.Tree;

import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByAge;
import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByGender;
import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByName;
import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByDateOfBirth;
import ru.gb.family_tree.Model.Family.Family.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Iterable<E>,Serializable {
    private long humanId;
    private List<E> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humans) {
        this.humans = humans;
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            human.setId(humanId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public E getById(long id) {
        for (E human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    private void addToParents(E human) {
        E mother = human.getMother();
        E father = human.getFather();
        if (mother != null) {
            mother.addChild(human);
        }
        if (father != null) {
            father.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id) {
        E human = (E) getById(id);
        if (human == null) {
            return null;
        }
        List<E> siblings = new ArrayList<>();
        E mother = human.getMother();
        E father = human.getFather();

        for (E child : mother.getChildren()) {
            if (!child.equals(human)) {
                siblings.add(child);
            }
        }
        for (E child : father.getChildren()) {
            if (!child.equals(human) && siblings.contains(child)) {
                siblings.add(child);
            }
        }
        return siblings;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding( human1, human2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= humanId || id < 0) {
            return false;
        }
        return true;
    }

    public void addHuman(E human) {
        humans.add(human);
    }

    public String getHumansNames() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family:\n");
        for (E human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumansNames();
    }

    public String getHumanInfo() {
        FamilyTree familyTree =new FamilyTree(humans);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FamilyInfo:\n");
        for (Object human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByAge<>());
    }

    public void sortByGender() {
        humans.sort(new HumanComparatorByGender<>());
    }

    public void sortByDateOfBirth() {
        humans.sort(new HumanComparatorByDateOfBirth<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }




}