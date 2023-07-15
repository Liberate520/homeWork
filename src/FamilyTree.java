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
}
