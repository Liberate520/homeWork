import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    public List<Human> people;

    FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        people.add(human);
        if (human.getMother() != null) {
            human.getMother().addKid(human);
        }
        if (human.getFather() != null) {
            human.getFather().addKid(human);
        }
    }

    public String showAllRelatives() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: people) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public Human findHumanByName(String name) {
        for (Human human : people) {
            if (human.getFullName().equals(name)) {
                return human;
            }
        }

        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        people.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        people.sort(new HumanComparatorByAge());
    }
}
