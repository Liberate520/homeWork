package home_work_class.FamilyTree;

import home_work_class.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humansList;

    public FamilyTree() {
        humansList = new ArrayList<>();
    }

    public String showHumansList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----Список корневого древа-----\n");
        for (Human human: humansList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
            stringBuilder.append("----------------------------\n");
        }
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
        if (! humansList.contains(human)){
            humansList.add(human);}
    }

    public List<Human> findHumanByName(String name){
        List<Human> findHuman = new ArrayList<>();
        for (Human human: humansList) {
            if (human.getName().equals(name)){findHuman.add(human);}
        }
        return findHuman;
    }

    public void sortByName(){
        humansList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humansList.sort(new HumanComparatorByAge());
    }

    public void  sortById() { humansList.sort(new HumanComparatorById());}
    @Override
    public Iterator<Human> iterator() {return humansList.iterator(); }
}
