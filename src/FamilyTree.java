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
        if(!contains(human)){
            family.add(human);
        }
    }

    /** added new child for member */
    public void addNewMemberChild(Human child, Human human) {
        addNewMember(child);
        if(human.getGender() == Gender.male){
            child.setFather(human);
        }
        if(human.getGender() == Gender.female){
            child.setMother(human);
        }
        human.addChild(child);
    }

    /** checked contains member in family list */
    private Boolean contains(Human search) {
        for (Human human : family) {
            if (human.equals(search)) {
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
