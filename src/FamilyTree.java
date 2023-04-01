import java.util.ArrayList;
import java.util.List;

/**
 * FamilyTree работает со списком людей, пока непонятно как)))
 */
public class FamilyTree {
    private final List<Human> people;

    FamilyTree(List<Human> lstHumans) {
        this.people = lstHumans;
    }

    FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void printChildren(Human human) {
        if (human.getChildren()!= null) {
            System.out.printf("Дети %s %s:", human.getName(), human.getSurname());
            for (Human child : human.getChildren()) {
                System.out.println(child);
            }
        }
    }
}