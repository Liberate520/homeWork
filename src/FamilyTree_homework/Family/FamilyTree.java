package FamilyTree_homework.Family;

import FamilyTree_homework.Humans.HumanComparatorByBirthday;
import FamilyTree_homework.Humans.HumanComparatorByName;
import FamilyTree_homework.Humans.Human;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable,Iterable<E>{
    private long humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }


    public void sortByName(){
        humanList.sort((Comparator<? super E>) new HumanComparatorByName());
    }
    public void sortByBirthday(){
        humanList.sort((Comparator<? super E>) new HumanComparatorByBirthday());
    }
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }


    public boolean add(E human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

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

    public void saveToFile(String s) {
    }

    public void setFilePath(String filePath) {
    }
}
