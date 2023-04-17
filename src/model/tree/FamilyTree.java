package model.tree;

import model.Human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {
    private final List<E> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void add(E o) {
        this.tree.add(o);
    }
    @Override
    public String toString() {
        for (E item : tree) {
            if (item.getFather() != null & item.getMother() != null) {
                System.out.println(item + " Мама:" + item.getMother() + " Папа: " + item.getFather());
            }
        }
        return " ";
    }

    public List<E> searchForSurnameAndName(String surname, String name) {
        List<E> temp = new ArrayList<>();
//        Object res = null;
        for (Human item : tree) {
            if (item.getName().equals(name) && item.getSurname().equals(surname)) {
                temp.add((E) item);
                if (item.getFather() != null && item.getMother() != null) {
                    temp.add((E) item.getFather());
                    temp.add((E) item.getMother());
                }
            }
        }
        return  temp;
//        for (E item : tree) {
//            if (item.getFather() != null | item.getMother() != null) {
//                if (item.getFather().getSurname().equals(surname) && item.getFather().getName().equals(name) ||
//                        item.getMother().getSurname().equals(surname) && item.getMother().getName().equals(name)) {
//                    temp.add(item);
//                }
//            }
//        }

//        if (res != null) {
//            if (!temp.isEmpty()) {
//                System.out.println(res + " Дети: " + temp);
//            } else {
//                System.out.println(res + " Детей нет");
//            }
//        } else System.out.println("Такого человека в дереве нет!");

    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(tree);
    }

    public List<E> getTree() {
        return tree;
    }
}
