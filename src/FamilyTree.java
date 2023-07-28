import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
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

    public void sortByName() {
        family.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
    }

    public void sortByBirthDate() {
        family.sort((h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()));
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

    @Override
    public Iterator<Human> iterator() {
        return family.iterator();
    }
}