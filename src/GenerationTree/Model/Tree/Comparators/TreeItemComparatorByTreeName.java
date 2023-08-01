package GenerationTree.Model.Tree.Comparators;

import java.util.Comparator;

import GenerationTree.Model.Tree.GenTreeItem;

public class TreeItemComparatorByTreeName implements Comparator<GenTreeItem> {

    @Override
    public int compare(GenTreeItem o1, GenTreeItem o2) {
        return o1.getTreeName().compareTo(o2.getTreeName());
    }

}
