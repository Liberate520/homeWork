package familyTree;

import human.Human;
import human.HumanComparatorByBirthday;
import human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int id;

    public List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByBirthday());
    }
    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(id++);
        }
    }
    public void addMother(Human human){

    }
    public void addFather(Human human){

    }
//TODO убрать все проверки, позже - заменить на логирование
    public void addChild(Human parent, Human child){
        if (!parent.getChildren().contains(child)){
//            System.out.println("проверка два");
            parent.setChildren(child);
        }
        else System.out.println("что-то не так");
        //TODO настроить ничегонеделание, если ребёнок уже добавлен
    }//TODO добавить автоматическое добавление родителя к ребёнку по полу.
    public void getMarried(Human wife, Human husband ){


    }
    public String getFamilyTree(){
        StringBuilder humanStringBuilder = new StringBuilder();
        humanStringBuilder.append("Семейное древо: \n");
        for (Human human: humanList){
            humanStringBuilder.append(human);
            humanStringBuilder.append("\n");
        }
        return humanStringBuilder.toString();
    }

    @Override
    public String toString() {
        return getFamilyTree().toString();
    }


    @Override//вроде так
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
