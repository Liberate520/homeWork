package Comparator;

import java.util.Comparator;

import FamilyTreeObject.FamilyTreeObject;
import FamilyTreeObject.Humans.Human;

public class FamilyTreeObjectComparatorByName implements Comparator<FamilyTreeObject> {

    @Override
    public int compare(FamilyTreeObject o1, FamilyTreeObject o2) {
        return o1.getName().compareTo(o2.getName());
    }



}
