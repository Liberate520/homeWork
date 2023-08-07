package homeWork.familytree;

import java.util.List;

public interface FamilyTreeModel {
    void addMember(Human member);
    List<Human> getAllMembers();
    // Add other methods for interactions with the family tree data
}