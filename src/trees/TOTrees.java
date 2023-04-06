package trees;

import familyTree.FamilyTree;

import java.util.List;

public interface TOTrees extends Iterable<FamilyTree> {
    void addFamilyTree(FamilyTree fTree);

    List<FamilyTree> getFamilyTreeList();
}