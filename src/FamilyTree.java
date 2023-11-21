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
    
    public List<Human> getFamilyTree() {
        return this.familyTree;
    }

    public void addToParents(Human person) {
        if (person.getFather() != null) {
            person.getFather().addChild(person);
        }
        if (person.getMother() != null) {
            person.getMother().addChild(person);
        }
    }
    
    public boolean addParent(Human parent, Human recipient) {
        if (parent.getSex().toString() == "Female") {
            return recipient.setMother(parent);
        } else {
            return recipient.setFather(parent);
        }
    }

    public boolean addPerson(Human person) {
        if (!this.familyTree.contains(person)) {
            this.familyTree.add(person);
            return true;
        }
        return false;
    }
    
    public boolean removePerson(Human person) {
        if (this.familyTree.contains(person)) {
            this.familyTree.remove(person);
            return true;
        }
        return false;
    }
    
    public boolean removePerson(long id) {
        return this.familyTree.remove(this.getById(id));
    }

    private Human getById(long id) {
        if (this.checkId(id)) {
            for (Human person : familyTree) {
                if (person.getId() == id) return person;
            }
        }
        return null;
    }

    private boolean checkId(long id) {
        if ((id > 0) && (id < this.familyTree.size())) return true;
        return false;
    }

    public List<Human> getSiblings(Human person) {
        List<Human> siblings = new ArrayList<>();
        if (person.getMother() != null) {
            for (Human child : person.getMother().getChildren()) {
                if (!siblings.contains(child) && !child.equals(person)) siblings.add(child);
            }
        }
        if (person.getFather() != null) {
            for (Human child : person.getFather().getChildren()) {
                if (!siblings.contains(child) && !child.equals(person)) siblings.add(child);
            }
        }
        return siblings;
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