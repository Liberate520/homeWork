package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.comporators.ComparatorByAge;
import ru.gb.family_tree.model.human.comporators.ComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E>{
        private List<E> humanList;
    public FamilyTree() {
        humanList = new ArrayList<>();}

    public void addHuman(E human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
//            // добавление связей
            addToParents(human);
            addToChildren(human);
        }
    }

//    public void addConnect(E human) {
//        addToParents(human);
//        addToChildren(human);
//    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }

    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public E getByFullName(String fullName) {
        for (E human: humanList){
            if (human.getFullName().equals(fullName)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (E human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public Iterator<E> iterator() {
        return new TIterator<>(humanList);
    }

    public void sortByFullName(){
        humanList.sort(new ComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge());
    }
}


