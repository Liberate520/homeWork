package familyTree;
import Human.*;
import Service.*;
import Human.Comparators.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree extends Saver implements Iterable<Human>{
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<Human>();
    }
    public void addHuman(Human human) {
        humanList.add(human);
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }
    public List<Human> getHumanList () {
        return humanList;
    }

    public Human findByName(String name) {
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        for (Human human: humanList) {
            stringbuilder.append(human + "\n");
        }
        return stringbuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }
}
