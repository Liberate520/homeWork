package family_tree.human;

import family_tree.human.comparators.HumanComparatorByAge;
import family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanGroup implements Iterable<Human>, Serializable {
    private List<Human> humans;
    public HumanGroup(){
        humans = new ArrayList<>();
    }

    public void add(Human h){
        humans.add(h);
    }

    public String getInfo(){
        List<String> listHumans = new ArrayList<>();
        for (Human h : humans)
            listHumans.add(h.getInfo());
        return String.join("\n", listHumans);
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }
    public void sortByAge(){
        humans.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);   //return humans.iterator();
    }
}
