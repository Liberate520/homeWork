package family;

import human.Human;
import human.comparator.*;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable, Iterable<Human>, Comparable<Family> {
    private final String familyName;
    private List<Human> members;

    public Family(String name) {
        this.familyName = name;
        members = new ArrayList<>();
    }

    private boolean humanInMembers(Human humanToCheck) {
        for (Human human : members) {
            if (humanToCheck.equals(human)) return true;
        }
        return false;
    }

    public void addHuman(Human human) {
        if (!humanInMembers(human)) members.add(human);
    }
    public List<Human> getMembers() {
        return members;
    }

    public String getName() {
        return familyName;
    }

    /**
     * Build and return string of family members
     */
    public String getFamiliesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human:this) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void sort(HumanComparator comparator) {
        members.sort(comparator);
    }

    public void sort() {
        this.sort(null);
    }
    public void sortByName() {
        this.sort(new HumanComparatorByName());
    }

    public void sortByBirthDate() {
        this.sort(new HumanComparatorByBirthDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(familyName, family.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName);
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", members=" + members +
                '}';
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(members);
    }

    @Override
    public int compareTo(Family otherFamily) {
        return familyName.compareTo(otherFamily.familyName);
    }
}
