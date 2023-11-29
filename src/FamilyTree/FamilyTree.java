package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import FamilyTree.Comparators.ComparatorByBirthYear;
import FamilyTree.Comparators.ComparatorByFirstName;
import FamilyTree.Comparators.ComparatorById;
import FamilyTree.Comparators.ComparatorByLastName;
import FamilyTreeItems.FamilyTreeItem;
import FamilyTreeItems.Sex;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<E>());
    }

    public List<E> getFamilyTree() {
        return this.familyTree;
    }

    private void addToParents(E person) {
        if (person.getFather() != null) {
            person.getFather().addChild(person);
        }
        if (person.getMother() != null) {
            person.getMother().addChild(person);
        }
    }

    private void addParent(E parent) {
        for (FamilyTreeItem child : parent.getChildren()) {
            if (parent.getSex().equals(Sex.Male))
                child.setFather(parent);
            else
                child.setMother(parent);
        }
    }

    public boolean addPerson(E person) {
        if (!this.familyTree.contains(person)) {
            this.familyTree.add(person);
            this.addToParents(person);
            this.addParent(person);
            return true;
        }
        return false;
    }

    public boolean removePerson(E person) {
        if (this.familyTree.contains(person)) {
            this.familyTree.remove(person);
            return true;
        }
        return false;
    }

    public boolean removePerson(long id) {
        return this.familyTree.remove(this.getById(id));
    }

    public E getById(long id) {
        if (this.checkId(id)) {
            for (E person : familyTree) {
                if (person.getId() == id)
                    return person;
            }
        }
        return null;
    }

    private boolean checkId(long id) {
        if (id > 0)
            return true;
        return false;
    }

    public List<FamilyTreeItem> getSiblings(E person) {
        List<FamilyTreeItem> siblings = new ArrayList<>();
        if (person.getMother() != null) {
            for (FamilyTreeItem child : person.getMother().getChildren()) {
                if (!siblings.contains(child) && !child.equals(person))
                    siblings.add(child);
            }
        }
        if (person.getFather() != null) {
            for (FamilyTreeItem child : person.getFather().getChildren()) {
                if (!siblings.contains(child) && !child.equals(person))
                    siblings.add(child);
            }
        }
        return siblings;
    }

    public List<FamilyTreeItem> getSiblings(long personId) {
        return this.getSiblings(this.getById(personId));
    }

    public void sortByFirstName() {
        this.familyTree.sort(new ComparatorByFirstName<>());
    }

    public void sortByLastName() {
        this.familyTree.sort(new ComparatorByLastName<>());
    }

    public void sortByBirthYear() {
        this.familyTree.sort(new ComparatorByBirthYear<>());
    }

    public void sortById() {
        this.familyTree.sort(new ComparatorById<>());
    }

    public double medianAge() {
        double ageSum = 0;
        int count = 0;
        for (E person : this.familyTree) {
            if (person.getDeathDate() == null) {
                ageSum += person.getAge();
                count++;
            }
        }

        return ageSum / count;
    }

    public double medianLifeSpan() {
        double lifeSpanSum = 0;
        int count = 0;
        for (E person : this.familyTree) {
            if (person.getDeathDate() != null) {
                lifeSpanSum += person.getAge();
                count++;
            }
        }

        return lifeSpanSum / count;
    }

    public double medianChildrenAmount() {
        double sumChildrenAmount = 0;
        for (E person : this.familyTree) {
            sumChildrenAmount += person.getChildrenAmount();
        }

        return sumChildrenAmount / this.familyTree.size();
    }

    @Override
    public String toString() {
        StringBuilder familyTreeBuilder = new StringBuilder();
        for (E person : this.familyTree) {
            familyTreeBuilder.append(person.getFullName()).append("\n");
        }
        return familyTreeBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return this.familyTree.iterator();
    }
}