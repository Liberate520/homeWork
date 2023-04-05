package tree;

import human.Human;
import iterAndComp.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Family {
    private List<Human> members;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> members) {
        this.members = members;
    }
    public boolean  addMembers(Human member){
        if (member == null) {
            return  false;
        }
        if (!members.contains(member)) {
            members.add(member);
            if (member.getFather() != null) {
                member.getFather().addChild(member);
            }
            if (member.getMother() != null) {
                member.getMother().addChild(member);
            }
            return true;
        }
        return false;
    }
    public Human getByName(String name){
        for (Human member: this.members) {
            if (member.getName().equals(name)) {
                return member;
            }

        }
        return null;
    }
    public void printMembers(){
        System.out.println("Members of Family");
        for (Human member: this.members
             ) {
            System.out.println(member.getAllInfo());

        }
    }
    @Override
    public Iterator<Human> iterator(){
        return new FamilyTreeIterator(members);
    }

    public List<Human> getMembers() {
        return members;
    }
}
