package famalyTree;

import human.Human;
import human.HumanComporatorByAge;
import human.HymanComporatorByName;

import java.io.Serializable;
import java.util.*;

public class Family<E extends HumanItem> implements Iterable<Human>, Serializable {
    private List<E> humanList;
    public Family(){
        this(new ArrayList<>());
    }
    public Family(List<E> humanList){
        this.humanList = humanList;
    }
    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild((Human) human);
            }
            if (human.getMother() != null){
                human.getMother().addChild((Human) human);
            }
            return true;
        }
        return false;
    }
    public E getByName(String name){
        for (E human: humanList){
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
        for (E human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public Iterator iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName(){
        humanList.sort(new HymanComporatorByName<>());
    }
    public void sortByAge(){
        humanList.sort(new HumanComporatorByAge<>());
    }

}
