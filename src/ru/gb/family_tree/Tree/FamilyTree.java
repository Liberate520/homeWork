package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Human.Human;
import ru.gb.family_tree.Servise.TreeItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E> {
    private int idHuman;   //
    private final List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public E addHuman(E human) {
        if (!humanList.contains(human)) {
            human.setId(idHuman++);
            humanList.add((E) human);
            addToParents((Human) human);     //    добавляем связи
            addToKids((Human) human);
//            addToPartner(human);
        }
        return human;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addKid(human);
        }
    }

    private void addToKids(Human human) {
        for (Human kids : human.getParents()) {
            kids.addParent(human);
        }
    }

    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tГенеалогическое дерево: \n");
        for (E human : humanList) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Поиск по Фамилии либо имени либо номеру паспорта
     */
    public E searchHuman(String value) {
        for (E human : humanList) {
            if (human.getSurname().equalsIgnoreCase(value) ||
                    human.getName().equalsIgnoreCase(value) ||
                    human.getNumPassport().equalsIgnoreCase(value)) {
                return (E) human;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {    // переопределили! см FamilyTreeIterator
        return new FamilyTreeIterator<>(humanList);
    }

    //    public void sortByName(){   //  доп. переопределили compareTo в Human
//        Collections.sort(humanList);
//    }
    public void sortByName() {    // создаем отдельный класс с методом (compare) implements Comparator
        Collections.sort(humanList, new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortByBirthday() {    // создаем отдельный класс
        humanList.sort(new HumanComparatorByBirthday<>());
    }
}

