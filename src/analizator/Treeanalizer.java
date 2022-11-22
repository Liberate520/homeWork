package analizator;

import classes.Parent;

import java.util.ArrayList;
import java.util.Objects;

public class Treeanalizer {
    /* показывает дерево детей */
    public void showChildrenTree(Parent person, String spacer) {
        if (person.getChildren().isEmpty()) {
            return;
        } else {
            System.out.printf("%sParent: %s %s, %s%n", spacer, person.getName(), person.getFamilyname(),
                    person.getGender());

            System.out.printf("%sChildren:%n", spacer);

            for (Parent child : person.getChildren()) {
                System.out.printf("%s%s %s, %s, %s%n", spacer, child.getName(), child.getFamilyname(),
                        child.getGender(), child.getMarigeStatus());

                spacer += " |";
                showChildrenTree(child, spacer);
            }

        }
        System.out.println();
    }

    /* показывает только родных детей */
    public void showChildren(Parent person) {
        if (person.getChildren().isEmpty()) {
            System.out.println("No children found");
        } else {
            System.out.println("Person:");
            person.getInfo();
            System.out.println("Children:");
            person.showChildren();
        }
    }

//    private void printPeople(ArrayList<Parent> people) {
//        for (Parent person : people) {
//            person.getInfo();
//        }
//    }

    private void printPeople(Parent[] people) {
        for (Parent person : people) {
            person.getInfo();
        }
    }

    /* показывает братьев и сестёр */
    public void showSiblings(Parent person) {
        Parent[] parents = person.getParents();
        if (parents[0] == null) {
            System.out.println("No parents found");
        } else {
            System.out.println("Person:");
            person.getInfo();
            System.out.println("Siblings:");
            ArrayList<Parent> children = parents[0].getChildren();
            if (children.size() < 2) {
                System.out.println("There are no siblings in this family.");
            } else {
                for (Parent child : children) {
                    if (!equals(child.getName(), person.getName())) { // проверка на схожесть имён
                        child.getInfo();
                    }
                }
            }
        }
    }

    public boolean equals(String name, String nameOther) {
        return Objects.equals(name, nameOther);
    }

    public void showParents(Parent person) {
        Parent[] parents = person.getParents();
        if (parents[0] == null) {
            System.out.println("No parents found");
        } else {
            System.out.println("Person:");
            person.getInfo();
            System.out.println("Parents:");
            printPeople(parents);
        }
    }

    /*
    показывает всех близких родственников
     */
    public void showFamilyMembers(Parent[] family) {
        System.out.println("Father and mother:");
        printPeople(family);
        System.out.println("\nChildren:");
        if (!family[0].getChildren().isEmpty()) {
            family[0].showChildren();
        } else {
            System.out.println("No children found.");
        }
        System.out.println("\nGrand parents:");
        for (Parent parent : family) {
            showParents(parent);
            System.out.println();
        }
    }
}
