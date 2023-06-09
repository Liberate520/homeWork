package model.humans.tree;

import model.humans.FamilyTreeItem;
import model.humans.comporator.HumanBirthdayComporator;
import model.humans.comporator.HumanNameComporator;

import java.io.Serializable;
import java.util.*;


public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {

    private List<E> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    /**
     * Добавить нового члена семьи в дерево
     */
    public void addHumanOfFamilyTree(E human) {
        familyTree.add(human);
    }

    /**
     * Показать список имен и фамилий в генеалогическое дереве
     */
    public String listOfNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E human : familyTree) {
            stringBuilder.append(human.getId() + " " + human.getFullName()+"\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }

    public Set<E> birthdaySort() {
        Set<E> humanSet = new TreeSet<E>(new HumanBirthdayComporator<>());
        for (E human : familyTree) {
            humanSet.add(human);
        }
        return humanSet;
    }

    public Set<E> firstNameSort() {
        Set<E> humanSet = new TreeSet<E>(new HumanNameComporator<>());
        for (E human : familyTree
        ) {
            humanSet.add(human);
        }
        return humanSet;
    }

    public void printFamilySet(Set<E> humanSet) {
        for (E humah : humanSet) {
            System.out.println(humah.toString());
        }
    }


}

