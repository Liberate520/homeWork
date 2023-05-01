package Comparator;

import FamilyTreeObject.FamilyTreeObject;
import FamilyTreeObject.Humans.Human;

import java.util.Comparator;

public class FamilyTreeObjectComparatorByGender implements Comparator<FamilyTreeObject> {

    @Override
    public int compare(FamilyTreeObject o1, FamilyTreeObject o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
