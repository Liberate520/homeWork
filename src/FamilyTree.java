import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void showAllRelatives() {
        System.out.println("Список родственников:");
        for (Human human : people) {
            System.out.println(human);
        }
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
}
