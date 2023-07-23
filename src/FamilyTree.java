import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public Human findHumanByName(String name) {
        for (Human human : humans) {
            if (human.getFirstName().equals(name) || human.getLastName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public Human findHumanByFullName(String fullName) {
        for (Human human : humans) {
            String fullNameFromHuman = human.getFirstName() + " " + human.getLastName();
            if (fullNameFromHuman.equals(fullName)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getAllFamilyMembers() {
        return humans;
    }

    public List<Human> getChildrenOfFather(Human father) {
        List<Human> children = new ArrayList<>();
        for (Human human : humans) {
            if (human.getFather() != null && human.getFather().equals(father)) {
                children.add(human);
            }
        }
        return children;
    }

    public List<Human> getChildrenOfMother(Human mother) {
        List<Human> children = new ArrayList<>();
        for (Human human : humans) {
            if (human.getMother() != null && human.getMother().equals(mother)) {
                children.add(human);
            }
        }
        return children;
    }

    public Iterator<Human> iterator() {
        return humans.iterator();
    }

    public void sortByFirstName() {
        humans.sort(Comparator.comparing(Human::getFirstName));
    }

    public void sortByBirthDate() {
        humans.sort(Comparator.comparing(Human::getBirthDate));
    }
}

