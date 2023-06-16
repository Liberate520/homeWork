package tree.model.humanService;

import tree.model.familyTree.TreeItem;
import java.util.List;

public class RemoveHumanService<T extends TreeItem<T>> {

    private List<T> familyTree;

    public RemoveHumanService(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public boolean removeHumanFromTree(T human) {
        if (human != null) {
            familyTree.remove(human);
            return true;
        }
        return false;
    }
}
