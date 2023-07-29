package Tree;

import Tree.FamilyMember;
import Tree.Human;
import Service.FamilyMemberComparatorByAge;
import Service.FamilyMemberComparatorByName;

import java.io.Serializable;
import java.util.*;

public class Family extends FamilyMember implements Serializable, Iterable<FamilyMember> {
    private List<FamilyMember> family;
    public Family() {
        family = new ArrayList<>();
    }
    public void addFamilyMember(String status, Human human) {
        FamilyMember familyMember = setFamilyMember(status, human);
        family.add(familyMember);
    }
    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Состав семьи: " + "\n");

        Iterator<FamilyMember> iterator = family.iterator();
        while (iterator.hasNext()){
            FamilyMember familyMember = iterator.next();
            stringBuilder.append(familyMember);
        }

        return stringBuilder.toString();
    }

    @Override
    public Iterator<FamilyMember> iterator() {
        return new FamilyMemberIterator(family);
    }
//    @Override
//    public int compareTo(Tree.FamilyMember o) {
//        return 0;
//    }
    public void sortByAge() {
        family.sort(new FamilyMemberComparatorByAge());
    }
    public void sortByName() {
        family.sort(new FamilyMemberComparatorByName());
    }

}