package homeWork.familytree;

import java.util.List;

public interface FamilyTree {
    void addMember(FamilyMember member);
    List<FamilyMember> getAllMembers();
    List<FamilyMember> getChildren(String parentName);
}
