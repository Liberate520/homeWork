package familytree;

import human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree extends Human implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public Tree(){
        this(new ArrayList<>());
    }
    public Tree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
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





    public List<Human> getHumanList(){
        return humanList;
    }

    public Human findHumanName(String name) {
        for (Human human : humanList) {
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
        for (Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}