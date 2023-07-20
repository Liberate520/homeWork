package classes.familyTree;

import classes.human.comparators.HumanComparatorByBrithDate;
import classes.human.comparators.HumanComparatorById;
import classes.human.comparators.HumanComparatorByName;
import classes.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {
    public List<E> humanList;


    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public String getInfo() {
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("Дерево содержит персон :");
        tmpSb.append(humanList.size());
        tmpSb.append("\n");
        for (E human : humanList) {
            tmpSb.append(human.getInfo());
            tmpSb.append("\n");
        }
        return tmpSb.toString();
    }

    public String toString() {
        return getInfo();
    }

    public boolean add(E human) {
        //       if(human==null){
        //          return false;}
        //      if(humanList.contains(human)){
        humanList.add(human);
        //           addToParents(human);
        //           addToChildren(human);
        //           return true;
        //       }
        return false;
    }

    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
        //Collections.sort(humanList);//РАБОТАЕТ
    }

    public void sortById() {
        //  humanList.sort(new HumanComparatorByName());
        Collections.sort(humanList, new HumanComparatorById<>());
    }

    public void sortByBrithDate() {
        //  humanList.sort(new HumanComparatorByName());
        Collections.sort(humanList, new HumanComparatorByBrithDate<>());
    }
//    public Human getByName(String name){
//
//    }
}


