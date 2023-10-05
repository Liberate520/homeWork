package tree_structure;


import members.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import comparators.HumanComparatorByBirthdayDate;
import comparators.HumanComparatorByName;
import comparators.HumanComparatorBySurname;
import iterators.HumanIterator;





public class FamilyTree implements Serializable, Iterable<Human>{
    private int id;
    private int humanId;
    private List<Human> humanList;


    public FamilyTree(int id){
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        human.setId(humanId++);
        humanList.add(human);
    }

    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Members list:\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
            
        }
        return stringBuilder.toString();
    }
    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(humanList);
    }
    public void sortbyName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortbyBirthdate(){
        humanList.sort(new HumanComparatorByBirthdayDate());
    }
   
    public void sortbySurname(){
        humanList.sort(new HumanComparatorBySurname());
    }
}
