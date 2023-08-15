package homeWork.familytree;

import java.util.List;

public class FamilyTreeModelImpl implements FamilyTreeModel {
    private Tree familyTree;

    public FamilyTreeModelImpl() {
        familyTree = new Tree();
    }

    @Override
    public void addMember(Human member) {
        familyTree.addMember(member);
    }

    @Override
    public List<Human> getAllMembers() {
        return familyTree.getAllMembers();
    }

    // Implement other methods for interactions with the family tree data
}
