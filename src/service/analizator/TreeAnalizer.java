package service.analizator;

import service.classes.Person;
import service.dataBase.DataBase;
import service.generator.GetRandom;
import service.tree.RelationType;

import java.util.ArrayList;
import java.util.HashMap;

import static service.tree.RelationType.*;

public class TreeAnalizer implements Analizer {
    private final Person testParent;
    private final Person testChild;
    private final Person[] testFamily;

    String stats;
    StatWorker line = new StatWorker();

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
        if (!person.getChildren().isEmpty()) {
            line.addPosition(spacer + "Parent: " + person.getName() + " "
                    + person.getFamilyname() + " " + person.getGender() + "\n");
            line.addPosition(spacer + "Children: " + "\n");

            for (Person child : person.getChildren()) {
                line.addPosition(spacer + child.getName() + " " + child.getFamilyname() + " "
                        + child.getGender() + " " + child.getMarigeStatus() + "\n");

                spacer += " |";
                childrenTreeWorker(child, spacer);
            }
            this.stats = line.toString();
        }
    }

    /* показывает только родных детей */
    public void showChildren() {
        if (this.testParent.getChildren().isEmpty()) {
            stats = "No children found";
        } else {
            line.addPosition("Person: " + "\n" + this.testParent + "\n");
            line.addPosition("Children: " + "\n");
            for (Person child : this.testParent.getChildren()) {
                line.addPosition(child.toString());
            }
        }
        this.stats = line.toString();
    }

    /* показывает братьев и сестёр */
    public void showSiblings() {
        line.addPosition("Person: " + "\n" + this.testChild.toString() + "\n");
        line.addPosition("Siblings:" + "\n");
        if (this.testChild.checkMember(FATHER)) {
            if (this.testChild.checkMember(BROTHER)) {
                line.addPosition("BROTHERS:\n");
                for (Person member : this.testChild.getMember(BROTHER)) {
                    line.addPosition(member.toString());
                }
            } else {
                line.addPosition("No brothers found." + "\n");
            }

            if (this.testChild.checkMember(SISTER)) {
                line.addPosition("SISTERS:\n");
                for (Person member : this.testChild.getMember(SISTER)) {
                    line.addPosition(member.toString());
                }
            } else {
                line.addPosition("No sisters found." + "\n");
            }
        } else {
            line.addPosition("No parents found.");
        }
        this.stats = line.toString();
    }


    public void showParents() {
        line.addPosition("Person:" + "\n");
        line.addPosition(testChild.toString());
        if (this.testChild.checkMember(FATHER)) {
            line.addPosition("FATHER:\n");
            line.addPosition(this.testChild.getMember(FATHER).get(0).toString());
            line.addPosition("MOTHER:\n");
            line.addPosition(this.testChild.getMember(MOTHER).get(0).toString());
        } else {
            line.addPosition("No parents found." + "\n");
        }
        this.stats = line.toString();
    }

    /*
    показывает всех близких родственников
     */
    public void showFamilyMembers() {
        for (Person parent : this.testFamily) {
            line.addPosition("Person:\n");
            line.addPosition(parent.toString());
            HashMap<RelationType, ArrayList<Person>> family = parent.getFamily();

            for (RelationType item : family.keySet()) {
                line.addPosition(item.toString() + "\n");
                if (parent.checkMember(item)) {
                    for (Person member : parent.getMember(item)) {
                        line.addPosition(member.toString());
                    }
                } else {
                    line.addPosition("No" + item + " found." + "\n");
                }
            }
            line.addPosition("\n");
        }
        this.stats = line.toString();
    }

    @Override
    public String getStats() {
        return this.stats;
    }
}
