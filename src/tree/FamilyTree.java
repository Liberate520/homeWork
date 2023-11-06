package tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import human.Human;
import human.comparators.HumanComparatorByName;
import human.comparators.HumanComparatorBySurname;

public class FamilyTree implements Serializable, Iterable<Human>{
    private int id;
    private int humanId;
    private List<Human> humanList;

    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        human.setId(humanId++);
        humanList.add(human);
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortBySurname() {
        humanList.sort(new HumanComparatorBySurname());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

}