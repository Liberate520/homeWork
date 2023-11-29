package FamilyTree_homework.Family;

import FamilyTree_homework.Comparator.HumanComparatorByBirthday;
import FamilyTree_homework.Comparator.HumanComparatorByName;
import FamilyTree_homework.Humans.Human;
import FamilyTree_homework.Humans.HumanIterator;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }


    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthday(){
        humanList.sort(new HumanComparatorByBirthday());
    }
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }


    public boolean add(Human human){
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

    public void saveToFile(String s) {
    }

    public void setFilePath(String filePath) {
    }
}
