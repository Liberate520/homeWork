package familytree;

import comparator.ComparatorByChildrenCount;
import comparator.ComparatorByName;
import entity.Mammal;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Mammal> implements Serializable, Iterable<T> {

    private String name;
    private List<T> memberList;

    public FamilyTree(String name, List<T> memberList) {
        this.name = name;
        this.memberList = memberList;
    }

    public FamilyTree(String name) {
        this(name, new ArrayList<T>());
    }

    public FamilyTree() {
        this("", new ArrayList<T>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<T> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        String s = name + "\n";
        for (T member: memberList) {
            s += member + "\n";
        }
        return s;
    }

    public void addMember(T member) {memberList.add(member);
    }

    public T getMemberByName(String name){
        for (T member: memberList){
            String lowerName = member.getName().toLowerCase();
            if (lowerName.equals(name.toLowerCase())){
                return member;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyIterator(memberList);
    }

    public void sortById(){
        Collections.sort(getMemberList());
    }

    public void sortByName(){
        Collections.sort(getMemberList(), new ComparatorByName());
    }

    public void sortByChildrenCountDesc() {
        Collections.sort(getMemberList(), new ComparatorByChildrenCount());
    }
}
