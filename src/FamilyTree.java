import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    public void addFather(Human father) {
        for (Human human : family) {
            if (human.getGender() == Gender.MALE) {
                System.out.println("Error: Father already exists in the family tree.");
                return;
            }
        }
        family.add(father);
    }

    public void addMother(Human mother) {
        for (Human human : family) {
            if (human.getGender() == Gender.FEMALE) {
                System.out.println("Error: Mother already exists in the family tree.");
                return;
            }
        }
        family.add(mother);
    }

    public void addSon(Human son) {
        for (Human human : family) {
            if (human.getGender() == Gender.MALE && human.getName().equals(son.getFatherName())) {
                family.add(son);
                return;
            }
        }
        System.out.println("Error: Father not found in the family tree.");
    }

    public void addDaughter(Human daughter) {
        for (Human human : family) {
            if (human.getGender() == Gender.FEMALE && human.getName().equals(daughter.getFatherName())) {
                family.add(daughter);
                return;
            }
        }
        System.out.println("Error: Father not found in the family tree.");
    }

    public void addBrother(Human brother) {
        // TODO: implement
    }

    public void addSister(Human sister) {
        // TODO: implement
    }

    public List<Human> getFamilyMembers() {
        return family;
    }
}