package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;

public class RemoveHumanService<T extends TreeItem<T>> {

    private Tree<T> familyTree;

    public RemoveHumanService(Tree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public boolean removeHumanFromTree(T human) {
        if (human != null) {
            familyTree.getFamilyTree().remove(human);
            return true;
        }
        return false;
    }
}
