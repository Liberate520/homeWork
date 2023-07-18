import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
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
}

