package ru.gb.Tree.Model.FamilyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import ru.gb.Tree.Model.Human.Comparators.HumanComparatorByBirthDate;
import ru.gb.Tree.Model.Human.Comparators.HumanComparatorByAge;
import ru.gb.Tree.Model.Human.Comparators.HumanComparatorByName;


public class Tree <E extends TreeItem<E>> implements Serializable, Iterable<E>{
    private List<E>humanList;

    public Tree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        humanList.add(human);
    }

    public E getById(Integer id){
        for (E human: humanList){
            if (Objects.equals(human.getId(), id)){
                return human;
            }
        }
        return null;
    }
    public void setWedding(Integer firstHumanId, Integer secondHumanId){
        E human1 = getById(firstHumanId);
        E human2 = getById(secondHumanId);
        if (human1.getSpouse()== null && human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        } 
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder(); 
        stringBuilder.append("Семья состоит из:\n");
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

//    public Integer getLastIndex(){
//        return humanList.size()- 1;
//    }

    @Override
    public String toString(){
        return getFamilyTreeInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }
     
}
