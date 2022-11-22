package analizator;

import classes.Parent;

import java.util.Objects;

import static tree.RelationType.*;

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
        System.out.println("Person:");
        person.getInfo();
        System.out.println("Siblings:");
        if (person.checkMember(FATHER)) {
            if (person.checkMember(BROTHER)) {
                person.showMember(BROTHER);
            } else {
                System.out.println("No brothers found");
            }

            if (person.checkMember(SISTER)) {
                person.showMember(SISTER);
            } else {
                System.out.println("No sisters found");
            }
        } else {
            System.out.println("No parents found");
        }
    }

    public boolean equals(String name, String nameOther) {
        return Objects.equals(name, nameOther);
    }

    public void showParents(Parent person) {
        System.out.println("Person:");
        person.getInfo();
        if (person.checkMember(FATHER)) {
            person.showMember(FATHER);
            person.showMember(MOTHER);
        } else {
            System.out.println("No parents found");
        }
    }

    /*
    показывает всех близких родственников
     */
    public void showFamilyMembers(Parent[] family) {
        for (Parent parent : family) {
            parent.getInfo();
        }
        family[0].showFamily();
    }
}
