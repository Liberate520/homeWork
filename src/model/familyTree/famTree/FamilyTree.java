package model.familyTree.famTree;

import java.io.Serializable;
// import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.familyTree.HumanIterator;
import model.familyTree.TreeItem;
import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByName;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E> {
    private int id;
    // private int humanId;
    private List<E> humanList;

    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        // ((Human) human).setId(humanId++);
        humanList.add(human);
    }

    // public String getHumansInfo(){
    //     StringBuilder stringBuilder = new StringBuilder();
    //     stringBuilder.append("Члены семьи:\n");
    //     for (E human: humanList){
    //         stringBuilder.append(human);
    //         stringBuilder.append("\n");
    //     }
    //     return stringBuilder.toString();
    // }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

}