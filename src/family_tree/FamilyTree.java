package family_tree;

import family_tree.comparators.PersonComparatorByBirthDate;
import family_tree.comparators.PersonComparatorByName;
import serialization.FileHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem> extends FileHandler implements Iterable<E>{
    private List<E> peopleList;
    private String familyName;
    private int count = 1;

    public FamilyTree(String familyName) {
        this.familyName = familyName;
        peopleList = new ArrayList<>();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void addInFamily(E person) {
        person.setId(count++);
        peopleList.add(person);
    }

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(familyName);
        stringBuilder.append(":\n");
        for (E person: peopleList) {
            stringBuilder.append(person.getId());
            stringBuilder.append(". ");
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getFamilyInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(peopleList);
    }

    public void sortByName() {
        peopleList.sort(new PersonComparatorByName<>());
    }
    public void sortByBirthDate() {
        peopleList.sort(new PersonComparatorByBirthDate<>());
    }
}
