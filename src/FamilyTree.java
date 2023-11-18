import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public List<Human> familyTree;
    
    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<Human>());
    }

    public void addPerson(Human person) {
        this.familyTree.add(person);
    }
    
    public void removePerson(Human person) {
        this.familyTree.remove(person);
    }

    public List<Human> getFamilyTree() {
        return this.familyTree;
    }

    public double medianAge() {
        double ageSum = 0;
        for (Human person : this.familyTree) {
            if (person.getDeathDate() == null) ageSum += person.getAge();
        }

        return ageSum / this.familyTree.size();
    }

    public double medianLifeSpan() {
        double lifeSpanSum = 0;
        for (Human person : this.familyTree) {
            if (person.getDeathDate() != null) lifeSpanSum += person.getAge();
        }

        return lifeSpanSum / this.familyTree.size();
    }
    
    public double medianChildrenAmount() {
        double sumChildrenAmount = 0;
        for (Human person : this.familyTree) {
            sumChildrenAmount += person.getChildrenAmount();
        }

        return sumChildrenAmount / this.familyTree.size();
    }
}