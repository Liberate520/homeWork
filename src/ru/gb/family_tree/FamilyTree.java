package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class FamilyTree<T extends TreeItem> implements Serializable, Iterable<T>{
        private List<T> humanList;
    public FamilyTree() {
        humanList = new ArrayList<>();}

    public void addHuman(T human) {
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents(T h){
//        for (Human parent: h.getParents()){
//            parent.addChild((Human) h);
//        }

    }

    private void addToChildren(T human){
        for (Human child: human.getChildren()){
            child.addParent((Human) human);
        }
    }

    public  T getByFullName(String fullName) {
        for (T human: humanList){
            if (human.getFullName().equals(fullName)){
                return (T) human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (T human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
    @Override
    public Iterator<T> iterator() {
        return new TIterator<>(humanList);
    }

    public void sortByFullName(){
        humanList.sort(new ComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge());
    }
}


