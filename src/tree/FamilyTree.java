package tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import human.Human;
import human.comparators.HumanComparatorByName;
import human.comparators.HumanComparatorBySurname;

public class FamilyTree <E extends TreeItem> implements Serializable, Iterable<E>{
//    private int id;
//    private int humanId;
    private List<E> humanList;

    public FamilyTree(int id) {
  //      this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        human.setId(humanList.size()); //humanId++
        humanList.add(human);
    }

    public void setHumanList(List<E> humanList) {
        this.humanList = humanList;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortBySurname() {
        humanList.sort(new HumanComparatorBySurname<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

}