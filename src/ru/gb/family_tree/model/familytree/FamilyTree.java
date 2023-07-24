package ru.gb.family_tree.model.familytree;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <E extends TreeItem<E>> implements Iterable<E>, Serializable {
    private List<E> humanList;
    private FamilyTree familyTree;
    private int id;
    private int humanId;

    public int getId() {
        return id;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public int getHumanId() {
        return humanId;
    }

    public FamilyTree() {

        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        if (!humanList.contains(human) ) {
            human.setId(humanId++);
            humanList.add(human);
            addToParents(human);
            addToChildren(human);

        }
    }
    public void addToParents(E human){
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChildren(E human){
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }



    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

    public String getInfo( ){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (E human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
    /*


 */
}
