package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> members;
    public FamilyTree(){
        members = new ArrayList<>();
    }
    public void addMember(Human human){
        members.add(human);
    }

    public List<Human> getMembers() {
        return members;
    }

    public void printMember(){
        for (Human member: members){
            member.getName();
        }
    }
}
