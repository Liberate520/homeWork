import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree = new ArrayList<>();

    public void addPeople(Human human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }


    @Override
    public String toString() {
        return familyTree.toString();
    }
    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(familyTree);
    }
    public void sortByDate() {
        familyTree.sort(new DateComparator());
    }
    public void sortByName() {
        familyTree.sort(new NameComparator());
    }


}
