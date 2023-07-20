package Model.FamilyTreeObject.Humans;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTreeObject.FamilyTreeObject;

import java.util.*;

public class Human extends FamilyTreeObject {


    public Human(FamilyTree familyTree, String name, String surname, Date dateOfBirth, Date dateOfDead, Human mother, Human father, String gender, List children) {
        super(familyTree, name, surname, dateOfBirth, dateOfDead, mother, father, gender, children);
    }

    public Human(FamilyTree familyTree, String name, String surname, String gender) {
        super(familyTree, name, surname, gender);
    }
}

