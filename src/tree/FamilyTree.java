package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comparators.HumanComparatorByAge;
import comparators.HumanComparatorByName;

public class FamilyTree<F extends FamilyTreeItem> implements Serializable, Iterable<F> {
    private List<F> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<F> humanList) {
        this.humanList = humanList;
    }

    public boolean add(F human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if ((human.getMother() != null)) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public F getByFirstName(String name){
       for (F human: humanList){
            if (human.getFirstName().equals(name)){
                return human;
            }
        }
       return null;
    }
    
   public void sortByFirstName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

    @Override
    public Iterator<F> iterator() {
        return humanList.iterator();
    }
}
