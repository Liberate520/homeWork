package tree;

import human.Comparators.SortByAgeComparator;
import human.Comparators.SortByNameComporator;

import human.Gender;
import human.Human;
import tree.itrator.TreeIterable;

import java.io.Serializable;
import java.util.*;


public class FamilyTree<E extends TreeCreaturable<E>> implements Serializable, Iterable<E> {
    private List<E> familyList;

    public Iterator<E> iterator() {
        return new TreeIterable(familyList);
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> familyList) {
        this.familyList = familyList;
    }

    public void add(E hum) {
        if (!familyList.contains(hum)) {
            familyList.add(hum);
            addToMother(hum);
            addToFather(hum);
            addToChild(hum);
        }
    }

    public void weading(E hum1, E hum2) {
        hum1.setSpouse(hum2);
        hum2.setSpouse(hum1);
    }

    public void divorce(E human) {
        human.getSpouse().addOldSpouse(human);
        human.addOldSpouse(human.getSpouse());
    }

    private void addToMother(E human) {
        if (human.getMother() != null) human.getMother().addChild(human);
    }

    private void addToFather(E human) {
        if (human.getFather() != null) human.getFather().addChild(human);
    }

    private void addToChild(E human) {
        for (E child : human.getChildrenList()) {
            if (human.getgGender() == Gender.Man) child.setFather(human);
            else child.setMother(human);
        }
    }

    public String getInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append("В дерево добавлено: ");
        sb.append(familyList.size());
        sb.append(" человек \n");
        for (E human : familyList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        familyList.sort(new SortByNameComporator());
    }

    public void sortByAge() {
        familyList.sort(new SortByAgeComparator());
    }


}
