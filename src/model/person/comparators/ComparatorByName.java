package model.person.comparators;

import model.familyTree.TreeNode;

import java.util.Comparator;

public class ComparatorByName<Person extends TreeNode<Person>> implements Comparator<Person> {
    @Override
    public int compare(Person one, Person two) {
        String nameOne = one.getName() + one.getPatronymic();
        String nameTwo = two.getName() + two.getPatronymic();
        return nameOne.compareTo(nameTwo);
    }
}
