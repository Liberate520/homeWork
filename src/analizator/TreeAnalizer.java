package analizator;

import classes.Person;
import dataBase.DataBase;
import generator.GetRandom;

import static tree.RelationType.*;

public class TreeAnalizer implements Analizer {
    private final Person testParent;
    private final Person testChild;
    private final Person[] testFamily;


    String stats;

    public TreeAnalizer(DataBase db) {
        this.testChild = GetRandom.getRandomChild(db);
        this.testParent = GetRandom.getRandomParent(db);
        this.testFamily = GetRandom.getRandomFamily(db);
    }

    /* показывает дерево детей */

    public void showChildrenTree(String spacer) {
        childrenTreeWorker(this.testParent, spacer);
    }

    private void childrenTreeWorker(Person person, String spacer) {
        if (person.getChildren().isEmpty()) {
            return;
        } else {
            System.out.printf("%sParent: %s %s, %s%n", spacer, person.getName(), person.getFamilyname(),
                    person.getGender());

            System.out.printf("%sChildren:%n", spacer);

            for (Person child : person.getChildren()) {
                System.out.printf("%s%s %s, %s, %s%n", spacer, child.getName(), child.getFamilyname(),
                        child.getGender(), child.getMarigeStatus());

                spacer += " |";
                childrenTreeWorker(child, spacer);
            }

        }
        System.out.println();
    }

    /* показывает только родных детей */
    public void showChildren() {

        if (this.testParent.getChildren().isEmpty()) {
            System.out.println("No children found");
        } else {
            System.out.println("Person:");
            this.testParent.getInfo();
            System.out.println("Children:");
            this.testParent.showChildren();
        }
    }

    /* показывает братьев и сестёр */
    public void showSiblings() {
        System.out.println("Person:");
        this.testChild.getInfo();
        System.out.println("Siblings:");
        if (this.testChild.checkMember(FATHER)) {
            if (this.testChild.checkMember(BROTHER)) {
                this.testChild.showMember(BROTHER);
            } else {
                System.out.println("No brothers found.");
            }

            if (this.testChild.checkMember(SISTER)) {
                this.testChild.showMember(SISTER);
            } else {
                System.out.println("No sisters found.");
            }
        } else {
            System.out.println("No parents found.");
        }
    }


    public void showParents() {
        System.out.println("Person:");
        this.testChild.getInfo();
        if (this.testChild.checkMember(FATHER)) {
            this.testChild.showMember(FATHER);
            this.testChild.showMember(MOTHER);
        } else {
            System.out.println("No parents found.");
        }
    }

    /*
    показывает всех близких родственников
     */
    public void showFamilyMembers() {
        for (Person parent : this.testFamily) {
            System.out.println("Person");
            parent.getInfo();
            parent.showFamily();
            System.out.println();
        }

    }

    @Override
    public String getStats() {
        return this.stats;
    }
}
