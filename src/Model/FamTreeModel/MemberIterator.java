package Model.FamTreeModel;

import Model.FamTreeModel.Human.Member;

import java.util.Iterator;
import java.util.List;

public class MemberIterator<E extends Member> implements Iterator<E>{
    private int ind;
    private List<E> memberList;
    public  MemberIterator(List<E> memberListList){
        this.memberList = memberListList;
    }



    @Override
    public boolean hasNext() {
        return memberList.size()> ind;
    }

    @Override
    public E next() {
        return memberList.get(ind++);
    }
}
