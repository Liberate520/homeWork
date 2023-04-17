import java.util.ArrayList;
import java.util.List;
public class FamilyTree {
    private List<Human> people;

    FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addRelative(Human human) {
        people.add(human);
    }

    public void showAllRelatives() {
        System.out.println("Список родственников:");
        for (Human human : people) {
            System.out.println(human);
        }
    }

    public Human findRelative(String name) {
        for (Human human : people) {
            if (human.getFullName().equals(name)) {
                return human;
            }
        }

        return null;
    }

    public void updateKids() {
        for (Human human: people) {
            if (human.getMother() != null) {
                human.getMother().addKid(human);
            }
            if (human.getFather() != null) {
                human.getFather().addKid(human);
            }
        }
    }
}
}

