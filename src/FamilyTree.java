import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    public List<E> people;

    FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(E human) {
        people.add(human);
//        if (human.getMother() != null) {
//            human.getMother().addKid(human);
//        }
//        if (human.getFather() != null) {
//            human.getFather().addKid(human);
//        }
    }

    public String showAllRelatives() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E human: people) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public E findHumanByName(String name) {
        for (E human : people) {
            if (human.getFullName().equals(name)) {
                return human;
            }
        }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        people.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        people.sort(new HumanComparatorByAge());
    }
}
