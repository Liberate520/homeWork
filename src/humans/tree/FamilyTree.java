package humans.tree;

import humans.Human;
import humans.comporator.HumanBirthdayComporator;
import humans.comporator.HumanNameComporator;

import java.io.Serializable;
import java.util.*;


public class FamilyTree implements Serializable, Iterable<Human> {

    private List<Human> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    /**
     * Добавить нового члена семьи в дерево
     */
    public void addHumanOfFamilyTree(Human human) {

        familyTree.add(human);
    }

    /**
     * Показать список имен и фамилий в генеалогическое дереве
     */
    public void listOfNames() {
        int count = 0;
        for (Human human : familyTree) {
            count++;
            System.out.println(count + " " + human.getFullName());
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

    public Set<Human> birthdaySort() {
        Set<Human> humanSet = new TreeSet<Human>(new HumanBirthdayComporator());
        for (Human human : familyTree) {
            humanSet.add(human);
        }
        return humanSet;
    }

    public Set<Human> firstNameSort() {
        Set<Human> humanSet = new TreeSet<>(new HumanNameComporator());
        for (Human human : familyTree
        ) {
            humanSet.add(human);
        }
        return humanSet;
    }

    public void printFamilySet(Set<Human> humanSet) {
        for (Human humah : humanSet) {
            System.out.println(humah.toString());
        }
    }


}

