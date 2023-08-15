package homeWork.familytree;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Tree implements FamilyTree {
    private List<FamilyMember> members;

    public Tree() {
        members = new ArrayList<>();
    }

    @Override
    public void addMember(FamilyMember member) {
        members.add(member);
    }

    @Override
    public List<FamilyMember> getAllMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public List<FamilyMember> getChildren(String parentName) {
        List<FamilyMember> children = new ArrayList<>();
        for (FamilyMember member : members) {
            if (member.getName().equals(parentName)) {
                children.addAll(member.getChildren());
            }
        }
        return children;
    }
}

