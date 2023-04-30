package humans.tree;

import humans.FamilyTreeItem;
import humans.Human;
import humans.comporator.HumanBirthdayComporator;
import humans.comporator.HumanNameComporator;

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
    public void listOfNames() {
        int count = 0;
        for (E human : familyTree) {
            count++;
            System.out.println(count + " " + human.getFullName());
        }
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

