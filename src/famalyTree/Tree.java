package famalyTree;

import human.Human;
import human.HumanComporatorByAge;
import human.HymanComporatorByName;

import java.io.Serializable;
import java.util.*;

public class Tree implements Iterable<Human>, Serializable {
    private List<Human> humanList;
    public Tree(){
        this(new ArrayList<>());
    }
    public Tree(List<Human> humanList){
        this.humanList = humanList;
    }
    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }
    public Human getByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(humanList.size());
        sb.append("объектов: \n");
        for (Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName(){
        humanList.sort(new HymanComporatorByName());
    }
    public void sortByAge(){
        humanList.sort(new HumanComporatorByAge());
    }

}
