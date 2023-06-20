package familytree;

import comparator.HumanComparatorByAge;
import comparator.HumanComparatorById;
import comparator.HumanComparatorByName;
import human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<T extends TreeItem> implements Serializable, Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    private List<T> humanList;

    public Tree(){
        this(new ArrayList<>());
    }
    public Tree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean add(T human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }





    public List<T> getHumanList(){
        return humanList;
    }

    public T findHumanName(String name) {
        for (T human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortById(){
        humanList.sort(new HumanComparatorById<>());
    }


//    @Override
//    public Iterator<Human> iterator() {
//        return humanList.iterator();
//    }
//
//    @Override
//    public int getId() {
//        return 0;
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
//
//    @Override
//    public int getAge() {
//        return 0;
//    }
}