package tree_structure;


//import members.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import comparators.HumanComparatorByBirthdayDate;
import comparators.HumanComparatorByName;
import comparators.HumanComparatorBySurname;
import iterators.HumanIterator;





public class FamilyTree <E extends Subject> implements Serializable, Iterable<E>{
    private int id;
    private int humanId;
    private int dogId;
    private List<E> humanList;
    private List<E> dogList;


    public FamilyTree(int id){
        this.id = id;
        humanList = new ArrayList<>();
        dogList = new ArrayList<>();
    }

    public void addHuman(E human){
        ((Subject) human).setId(humanId++);
        humanList.add(human);
    }

    public void addDog(E dog){
        ((Subject) dog).setId(dogId++);
        dogList.add(dog);
    }

    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Members list:\n");
        for (E human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
            
        }
        return stringBuilder.toString();
    }
    public String getDogInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Members list:\n");
        for (E dog: dogList){
            stringBuilder.append(dog);
            stringBuilder.append("\n");
            
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator(){
        return new HumanIterator<>(humanList);
    }
    public void sortbyName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortbyBirthdate(){
        humanList.sort(new HumanComparatorByBirthdayDate<>());
    }
   
    public void sortbySurname(){
        humanList.sort(new HumanComparatorBySurname<>());
    }
}

