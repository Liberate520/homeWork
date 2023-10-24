package home_work_class.FamilyTree;

import home_work_class.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable {
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
        }
        stringBuilder.append("-----Окончание списка корневого дерева-----\n");
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
        if (! humansList.contains(human)){
            humansList.add(human);}
    }

    public Human findHumanByName(String name){
        for (Human human: humansList) {
            if (human.getName().equals(name)){return human;}
        }
        return null;
    }

    public void sortByName(){
        humansList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humansList.sort(new HumanComparatorByAge());
    }
    @Override
    public Iterator<Human> iterator() {
        return humansList.iterator();
    }
}
