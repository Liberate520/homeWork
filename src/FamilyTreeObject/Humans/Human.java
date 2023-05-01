package FamilyTreeObject.Humans;

import FamilyTreeObject.FamilyTreeObject;

import java.io.Serializable;
import java.util.*;

public class Human extends FamilyTreeObject {


    public Human(String name, String surname, Date dateOfBirth, Date dateOfDead, Human mother, Human father, String gender, List children) {
        super(name, surname, dateOfBirth, dateOfDead, mother, father, gender, children);
    }

    public Human(String name, String surname, String gender) {
        super(name, surname, gender);
    }
}

