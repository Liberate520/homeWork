package Model.FamilyTreeObject.Humans;

import Model.FamilyTreeObject.FamilyTreeObject;

import java.util.*;

public class Human extends FamilyTreeObject {


    public Human(String name, String surname, Date dateOfBirth, Date dateOfDead, Human mother, Human father, String gender, List children) {
        super(name, surname, dateOfBirth, dateOfDead, mother, father, gender, children);
    }

    public Human(String name, String surname, String gender) {
        super(name, surname, gender);
    }
}

