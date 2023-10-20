package Model.FamTreeModel.Human;

import Model.FamTreeModel.TreeMembers;

import java.util.Comparator;

public class ComparatorName<T extends Member> implements Comparator<Member> {


    @Override
    public int compare(Member member, Member t1) {
        return member.getFirstName().compareTo(t1.getFirstName());
    }
}
