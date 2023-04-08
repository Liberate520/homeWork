import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private ArrayList<T> familyTree = new ArrayList<>();

    public ArrayList<T> getFamilyTree() {
        return familyTree;
    }

    public void addHuman(T human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }



    public T find(String name) {
        for (T human : familyTree) {
            if (human.getName().equals(name)) {
                System.out.println(human);
                return human;
            }

        }
        return null;
    }


    @Override
    public String toString() {
        return familyTree.toString();
    }
    @Override
    public Iterator<T> iterator(){
        return new HumanIterator<T>(familyTree);
    }
    public void sortByDate() {
        familyTree.sort(new DateComparator());
    }
    public void sortByName() {
        familyTree.sort(new NameComparator());
    }


}
