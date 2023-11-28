package fam_tree.family_tree;


import fam_tree.human.HumanComparatorByAge;
import fam_tree.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <T extends TreeItem<T>> implements Serializable, Iterable<T> {
    private final List<T> humanList;
    private int humanId;

    public FamilyTree(List<T> humanList){
        this.humanList = humanList;
    }



    public FamilyTree() {
        this(new ArrayList<>());
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humanList=" + humanList +
                ", humanId=" + humanId +
                '}';
    }

    public void sortByName() {
        Collections.sort(humanList);

    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortById() {
    }

    public void addFamilyTree(T human) {
        if (!humanList.contains(human)) {
            human.setId(humanId++);
            humanList.add((T) human);
            addToParrents(human);
//            addToChildren(human);
        }}

    public void addToTheTree(T human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
//            addToChildren(human);
        }
    }
    private void addToParents (T human){
        for (T parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

//    private void addToChildren (T human){
//        for (T child : human.getChildren()) {
//            child.addParents(human);
//        }
//    }
    public void addToParrents(T human){
        for (T parent: human.getParents()){
            parent.addChildren(human);
        }
    }
    public void addToChildren(T human){
        for (T child: human.getChildren()){
            child.addParents(human);
        }
    }

    private boolean checkId(int id){
        return id < humanId && id >= 0;
    }

    public T findById(int id){
        if (!checkId(id)){
            return null;
        }
        for (T human: humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<T> findSiblings(int id){
        T human = findById(id);
        if (human == null){
            return null;
        }
        List<T> siblings = new ArrayList<>();
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human) && !(siblings.contains(child))){
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public List<T> findByName(String name){
        List<T> names = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)){
                names.add(human);
            }
        }
        return names;
    }



    public String familyTreeInfo () {
        StringBuilder sb = new StringBuilder();
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humanList);
    }
}

