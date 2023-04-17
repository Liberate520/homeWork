package tree;

import human.Human;
import iterAndComp.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Family<E> {
    private List<E> members;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> members) {
        this.members = members;
    }
    public boolean  addMembers(E member){
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

    public void addMother(Human member, String nameMother){
        Human mother = getByName(nameMother);
        if(mother != null) {
            member.setMother(mother);
        }
    }

    public void addFather(Human member, String nameFather){
        Human father = getByName(nameFather);
        if (father != null) {
            member.setFather(father);
        }
    }


    @Override
    public Iterator<E> iterator(){
        return new FamilyTreeIterator((List<E>) members);
    }

    public List<E> getMembers() {
        return (List<E>) members;
    }
}
