package family;

import human.Human;
import human.comparator.*;
import member.Member;
import member.comparator.MemberComparator;
import member.comparator.MemberComparatorByName;

import java.io.Serializable;
import java.util.*;

public class Family<E extends Member> implements Serializable, Iterable<E>, Comparable<Family<E>> {
    private final String familyName;
    private List<E> members;

    public Family(String name) {
        this.familyName = name;
        members = new ArrayList<>();
    }

    //    private boolean humanInMembers(Human humanToCheck) {
    private boolean containMember(E memberToCheck) {
        for (E member : members) {
            if (memberToCheck.equals(member)) return true;
        }
        return false;
    }

    public void addHuman(E member) {
        if (!containMember(member)) members.add(member);
    }
    public List<E> getMembers() {
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
        for (E member:this) {
            stringBuilder.append(member);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    // TODO: unsure how to get rid of "Raw use of parameterized class"
    //  cause HumanComparatorByBirthDate does not need a parameter
    private void sort(MemberComparator comparator) {
        members.sort(comparator);
    }

    public void sort() {
        this.sort(null);
    }
    public void sortByName() {
        this.sort(new MemberComparatorByName<E>());
    }

    public void sortByBirthDate() {
        this.sort(new HumanComparatorByBirthDate());
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family<E> family = (Family<E>) o;
        try {
            // check if other object contain correct elements by iterate over them
            for (E member : family);
        } catch (ClassCastException e) {
            return false;
        }
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
    public Iterator<E> iterator() {
        return new MemberIterator<E>(members);
    }

    @Override
    public int compareTo(Family otherFamily) {
        return familyName.compareTo(otherFamily.familyName);
    }
}
