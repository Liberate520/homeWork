package familyTree;

import human.Human;
import human.HumanComparatorByGender;
import human.HumansComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans;

//    public familyTree.FamilyTree(List<human.Human> humans) {
//        this.humans = humans;
//    }

    public FamilyTree() {
        humans = new ArrayList<>();
    }



    /**
     * Метод возвращающий Коллекцию типа List
     */
    public List<Human> getHumanList() {
        return humans;
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(this.humans);
    }


    public void sortByName() {
        Collections.sort(humans);
    }

    public void sortByAge() {
        humans.sort(new HumansComparatorByAge());
    }

    public void sortByGender(){
        humans.sort(new HumanComparatorByGender());
    }
}
