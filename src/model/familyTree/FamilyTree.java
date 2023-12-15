package model.familyTree;

import model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E>{

    private List<E> humanList;


    public FamilyTree(List<E> humanList){
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(E human){
        if(human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

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

    public boolean setWedding(E human1, E human2) {
        if (human1.getCouple() == null && human2.getCouple() == null) {
            human1.setCouple(human2);
            human2.setCouple(human1);
            return true;
        } else {
            return false;
        }
    }



    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new FamilyComparatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new FamilyComparatorByBirthDate());
    }

}
