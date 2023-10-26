package ru.gb.family_tree.tree;

import ru.gb.family_tree.person.Person;
import java.util.ArrayList;


public class FamilyTree {
    private final Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public Person getRoot() {
        return root;
    }

    public ArrayList<Person> getChildrenOfPerson(Person person) {
        return person.getChildren();
    }

    public ArrayList<Person> getParentsOfPerson(Person person) {
        return person.getParents();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*".repeat(30)).append("\n");
        if (!root.getParents().isEmpty()) {
            stringBuilder.append(getRoot().getName()).append("` parents: ").append("\n");
            for (Person parent : getParentsOfPerson(this.root)) {
                stringBuilder.append(parent).append("\n");
            }
            stringBuilder.append("\n");
        }
        if (root.getChildren().isEmpty()) {
            stringBuilder.append(getRoot().getName()).append(" doesn't have children").append("\n");
        } else {
            stringBuilder.append(this.getRoot().getName()).append("`s children: ").append("\n");
            for (Person child : getChildrenOfPerson(this.root)) {
                stringBuilder.append(child).append("\n");
            }
        }
        stringBuilder.append("*".repeat(30)).append("\n");
        return stringBuilder.toString();
    }
}
