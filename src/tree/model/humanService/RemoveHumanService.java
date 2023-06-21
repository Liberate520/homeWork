package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;

public class RemoveHumanService<T extends TreeItem<T>> {

    public boolean removeHumanFromTree(T human, Tree<T> tree) {
        if (human != null) {
            tree.getFamilyTree().remove(human);
            return true;
        }
        return false;
    }
}
