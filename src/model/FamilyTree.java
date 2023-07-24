package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class FamilyTree<Creature extends Entities> implements Serializable, Iterable<Creature> {
    
    private ArrayList<Creature> creatureList;

    public FamilyTree() {
        creatureList = new ArrayList<>();
    }

    public void add(Creature creature) {
        if (!creatureList.contains(creature)) {
            creatureList.add(creature);
        }
    }

        
    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (Creature human : creatureList) {
            strb.append(human);
        }
        return strb.toString();
    }

    
    @Override
    public Iterator<Creature> iterator() {
        return creatureList.iterator();
    }

    public void sortByAge() {
        creatureList.sort(new HumanComparatorByAge<>());

    }

    public void sortByBirthdate() {
        creatureList.sort(new HumanComparatorByBirthDate<>());
    }

    public void sortByName() {
        creatureList.sort(new HumanComparatorByName<>());
    }

    

}
