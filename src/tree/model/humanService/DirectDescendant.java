package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;

import java.util.ArrayList;
import java.util.List;

public class DirectDescendant<T extends TreeItem<T>> {

    private List<T> getListOfDirectDescendants(List<T> descendants, T human, Tree<T> tree) {

        if (human.getFather() != null && tree.getFamilyTree().contains(human.getFather())) {
            descendants.add(human.getFather());
            getListOfDirectDescendants(descendants, human.getFather(), tree);
        }
        if (human.getMother() != null && tree.getFamilyTree().contains(human.getMother())) {
            descendants.add(human.getMother());
            getListOfDirectDescendants(descendants, human.getMother(), tree);
        }
        return descendants;
    }

    public boolean isDirectDescendant(T descendant, T human, Tree<T> tree)
    {
        List<T> descendants = new ArrayList<>();
        descendants = getListOfDirectDescendants(descendants, descendant, tree);

        if (descendants.contains(human)) return true;
        else return false;
    }
}
