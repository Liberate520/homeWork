import java.util.ArrayList;
import java.util.List;

/**
 * Family tree
 */
public class FamilyTree {
    private List<Human> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    /** added new member */
    public void addNewMember(Human human) {
        family.add(human);
    }

    /** added new child for member */
    public void addNewMemberChild(Human child, Human human) {

        if (!Contains(child)) {
            family.add(child);
        }
        human.addChild(child);
    }

    /** checked contains member in family list */
    private Boolean Contains(Human searchableHuman) {
        for (Human human : family) {
            if (human.equals(searchableHuman)) {
                return true;
            }
        }
        return false;
    }

    /** representation */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Human human : family) {
            builder.append(human);
            builder.append("\n");
        }
        return builder.toString();
    }
}
