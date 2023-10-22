package tree;

import member.FamilyMember;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<FamilyMember> familyMembers;

    public FamilyTree(){
        familyMembers = new ArrayList<>();
    }

    public void addFamilyMember(FamilyMember member){
        familyMembers.add(member);
    }

    public String getFamilyMembersInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Members of family tree:\n");
        for (FamilyMember member: familyMembers){
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}