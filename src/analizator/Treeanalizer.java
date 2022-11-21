package analizator;

import java.util.ArrayList;
import java.util.Objects;

import classes.Human;
import classes.Parent;

public class Treeanalizer {
    /* показывает дерево детей */
    public static void showChildrenTree(Parent person, String spacer) {
        if (person.getChildren().isEmpty()) {
            return;
        } else {
            System.out.printf("%sParent: %s %s, %s%n", spacer, person.getName(), person.getFamilyname(),
                    person.getGender());

            System.out.printf("%sChildren:%n", spacer);

            for (Human child : person.getChildren()) {
                System.out.printf("%s%s %s, %s, %s%n", spacer, child.getName(), child.getFamilyname(),
                        child.getGender(), child.getMarigeStatus());

                if (child instanceof Parent) {
                    spacer += " |";
                    showChildrenTree((Parent) child, spacer);
                }
            }

        }
        System.out.println();
    }

    /* показывает только родных детей */
    public static void showChildren(Parent person) {
        if (person.getChildren().isEmpty()) {
            System.out.println("No children found");
        } else {
            System.out.println("Person:");
            person.getInfo();
            System.out.println("Children:");
            person.showChildren();
        }
    }

//    private static void printPeople(ArrayList<Human> people) {
//        for (Human person : people) {
//            person.getInfo();
//        }
//    }

    private static void printPeople(Human[] people) {
        for (Human person : people) {
            person.getInfo();
        }
    }

    /* показывает братьев и сестёр */
    public static void showSiblings(Human person) {
        Parent[] parents = person.getParents();
        if (parents[0] == null) {
            System.out.println("No parents found");
        } else {
            System.out.println("Person:");
            person.getInfo();
            System.out.println("Siblings:");
            for (Parent parent : parents) {
                ArrayList<Human> children = parent.getChildren();
                if (children.size() < 2) {
                    System.out.println("There are no siblings in this family.");
                } else {
                    for (Human child : children) {
                        if (!Objects.equals(child.getName(), person.getName())) { // проверка на схожесть имён
                            child.getInfo();
                        }
                    }
                }
            }
        }
    }

    public static void showParents(Human person) {
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
    public static void showFamilyMembers(Human[] family) {
        System.out.println("Father and mother:");
        printPeople(family);
        System.out.println("\nChildren:");
        if (family[0] instanceof Parent) {
            if (!((Parent) family[0]).getChildren().isEmpty()) {
                ((Parent) family[0]).showChildren();
            }
        } else {
            System.out.println("No children found.");
        }
        System.out.println("\nGrand parents:");
        for (Human parent : family) {
            showParents(parent);
            System.out.println();
        }
    }
}
