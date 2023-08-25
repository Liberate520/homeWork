package ru.gb.Tree.FamilyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.gb.Tree.Human.Human;
import ru.gb.Tree.Human.Comparators.HumanComparatorByBirthDate;
import ru.gb.Tree.Human.Comparators.HumanComparatorByAge;
import ru.gb.Tree.Human.Comparators.HumanComparatorByName;



public class Tree implements Serializable, Iterable<Human>{
    private List<Human>humanList;

    public Tree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public Human getById(int id){
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }
    public void setWedding(int firstHumanId, int secondHumanId){
        Human human1 = getById(firstHumanId);
        Human human2 = getById(secondHumanId);
        if (human1.getSpouse()== null && human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        } 
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder(); 
        stringBuilder.append("Семья состоит из:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
   
    @Override
    public String toString(){
        return getFamilyTreeInfo();
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }
     
}
