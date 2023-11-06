package homeWork.src.tree;

import homeWork.src.member.FamilyMember;

import java.util.Iterator;
import java.util.List;

public class FamilyMemberIterator implements Iterator<FamilyMember> {
    private int index;
    private List<FamilyMember> myFamiliMembers;

    public FamilyMemberIterator(List<FamilyMember> myFamiliMembers) {
        this.myFamiliMembers = myFamiliMembers;
    }

    @Override
    public boolean hasNext() {
        return index < myFamiliMembers.size();
    }

    @Override
    public FamilyMember next() {
        return myFamiliMembers.get(index++);
    }
}
