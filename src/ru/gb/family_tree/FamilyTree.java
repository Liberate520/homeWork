package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class FamilyTree implements Serializable, Iterable<Human>{
//    private List<Human> humanList;

    public class FamilyTree<T> implements Serializable, Iterable<Human>{
        private List<Human> T;


//    public FamilyTree(List<Human> humanList) {
//        this.humanList = humanList;
//    }
//    public FamilyTree() {
//        this(new ArrayList<>());
//    }
//    public FamilyTree() {humanList = new ArrayList<>();}
//
//    public void addHuman(Human human) {
//        if (!humanList.contains(human)) {
//            humanList.add(human);

    public FamilyTree() {T = new ArrayList<>();}

    public void addHuman(Human human) {
        if (!T.contains(human)) {
            T.add(human);

            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }
    public  Human getByFullName(String fullName) {
//        for (Human human: humanList){
        for (Human human: T){
            if (human.getFullName().equals(fullName)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
//        for (Human human :humanList) {
        for (Human human: T){
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
    public Iterator<Human> iterator() {
//        return humanList.iterator();
        return T.iterator();
    }

    public void sortByFullName(){
//        humanList.sort(new ComparatorByName());
        T.sort(new ComparatorByName());
    }

    public void sortByAge() {
//        humanList.sort(new ComparatorByAge());
        T.sort(new ComparatorByAge());
    }
}


