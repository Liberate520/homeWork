package service.analizator;

import service.classes.Person;
import service.tree.RelationType;

import java.util.ArrayList;
import java.util.HashMap;

/*
Класс для анализа семьи объекта Person
 */
public class PersonAnalizer implements Analizer {
    protected final Person testPerson;

    protected String stats;
    protected StatWorker line = new StatWorker();

    public PersonAnalizer(Person person) {
        this.testPerson = person;
    }

    @Override
    public void analyze() {
        line.addPosition("\n__________________________________All family members__________________________\n");
        this.showFamilyMembers();
        this.stats = line.toString();
    }

    // Скрыто на будующее

    /* показывает только родных детей */
//    public void showChildren() {
//        if (this.testParent.getChildren().isEmpty()) {
//            stats = "No children found";
//        } else {
//            line.addPosition("Person: " + "\n" + this.testParent + "\n");
//            line.addPosition("Children: " + "\n");
//            for (Person child : this.testParent.getChildren()) {
//                line.addPosition(child.toString());
//            }
//        }
//        this.stats = line.toString();
//    }

    /* показывает братьев и сестёр */
//    public void showSiblings() {
//        line.addPosition("Person: " + "\n" + this.testPerson.toString() + "\n");
//        line.addPosition("Siblings:" + "\n");
//        if (this.testPerson.checkMember(FATHER)) {
//            if (this.testPerson.checkMember(BROTHER)) {
//                line.addPosition("BROTHERS:\n");
//                for (Person member : this.testPerson.getMember(BROTHER)) {
//                    line.addPosition(member.toString());
//                }
//            } else {
//                line.addPosition("No brothers found." + "\n");
//            }
//
//            if (this.testPerson.checkMember(SISTER)) {
//                line.addPosition("SISTERS:\n");
//                for (Person member : this.testPerson.getMember(SISTER)) {
//                    line.addPosition(member.toString());
//                }
//            } else {
//                line.addPosition("No sisters found." + "\n");
//            }
//        } else {
//            line.addPosition("No parents found.");
//        }
////        this.stats = line.toString();
//    }


//    public void showParents() {
//        line.addPosition("Person:" + "\n");
//        line.addPosition(testPerson.toString());
//        if (this.testPerson.checkMember(FATHER)) {
//            line.addPosition("FATHER:\n");
//            line.addPosition(this.testPerson.getMember(FATHER).get(0).toString());
//            line.addPosition("MOTHER:\n");
//            line.addPosition(this.testPerson.getMember(MOTHER).get(0).toString());
//        } else {
//            line.addPosition("No parents found." + "\n");
//        }
////        this.stats = line.toString();
//    }

    /*
    показывает всех близких родственников
     */
    public void showFamilyMembers() {
        line.addPosition("Person:\n");
        line.addPosition(testPerson.toString());
        HashMap<RelationType, ArrayList<Person>> family = testPerson.getFamily();

        for (RelationType item : family.keySet()) {
            line.addPosition(item.toString() + "\n");
            if (testPerson.checkMember(item)) {
                for (Person member : testPerson.getMember(item)) {
                    line.addPosition(member.toString());
                }
            } else {
                line.addPosition("No" + item + " found." + "\n");
            }
        }
        line.addPosition("\n");
    }


    @Override
    public String getStats() {
        return this.stats;
    }
}
