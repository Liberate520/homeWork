package model.familyTree;

import model.human.Human;
import model.human.HumanComparatorByBirthDate;
import model.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{

    private List<Human> humanList;


    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(Human human){
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

    public boolean setWedding(Human human1, Human human2) {
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
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }

}
