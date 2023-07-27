package genealogicalTree;

import human.ComparatorByAge;
import human.ComparatorByName;
import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenealogicalTree<T extends Human > implements Serializable, Iterable<T> {

    private List<T> humanList;

    public GenealogicalTree() {
        humanList = new ArrayList<>();
    }

    public GenealogicalTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        for (T human: humanList
             ) {
            String part = human.getInfo();
            sb.append(part);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addHuman(T human){
        if(!humanList.contains(human)) {
            humanList.add(human);
        }
    }

    public void showAllHumans(){
        for (T human: this.humanList
        ) {
            System.out.println(human);
        }
    }

    public List<T> getHumanByLastName(String lastName) {
        List<T> result = new ArrayList<>();
        for (T human:humanList
        ) {
            String lastNameHuman = getLastName((Human) human);
            if(lastNameHuman.equalsIgnoreCase(lastName)) result.add(human);
        }
        return result;
    }

    private String getLastName(Human human) {
        return human.getLastName();
    }

    public List<Human> getHumanByName(String name) {
        List<Human> result = new ArrayList<>();
        for (T human:humanList
        ) {
            String nameHuman = getName((Human) human);
            if(nameHuman.equalsIgnoreCase(name)) result.add((Human) human);
        }
        return result;
    }

    private String getName(Human human) {
        return getName(human);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T human: humanList
        ) {
            sb.append(human.toString());
            sb.append("--------------------");
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    public void sortByAge(){
        humanList.sort(new ComparatorByAge());
    }

    public void sortByName(){
        humanList.sort(new ComparatorByName());
    }
}

