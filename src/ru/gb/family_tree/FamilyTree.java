package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> members;
    public FamilyTree(){
        members = new ArrayList<>();
    }
    public void addMember(Human human){
        members.add(human);
    }
    public void printMember(){
        for (Human member: members){
            member.getName();
        }
    }
}
