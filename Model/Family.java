package Model;

import Model.Service.*;
import java.io.Serializable;
import java.util.*;

public class Family implements Serializable, Iterable<FamilyMember> {
    private List<FamilyMember> family;
    public Family() {
        family = new ArrayList<>();
    }
    public void addFamilyMember(FamilyMember familyMember) {
        family.add(familyMember);
    }
    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Состав семьи: " + "\n");

        Iterator<FamilyMember> iterator = family.iterator();
        while (iterator.hasNext()){
            Human familyMember = iterator.next();
            stringBuilder.append(familyMember);
        }

        return stringBuilder.toString();
    }

    @Override
    public Iterator<FamilyMember> iterator() {
        return new FamilyMemberIterator(family);
    }

    public void sortByAge() {
        family.sort(new FamilyMemberComparatorByAge());
    }
    public void sortByName() {
        family.sort(new FamilyMemberComparatorByName());
    }

}