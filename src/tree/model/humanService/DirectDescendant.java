package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;

public class DirectDescendant<T extends TreeItem<T>> {
    private Tree<T> familyTree;
    private boolean isDD;

    public DirectDescendant(Tree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public boolean getIsDD() { return isDD; }
    public void setIsDDFalse() { isDD = false; }

    public void isDirectDescendant(T human1,T human2) {
        isDD = false;
        if (human1.getFather() == human2 || human1.getMother() == human2) {
           // System.out.println("YEEEEEEEEEEEEEEES");
            isDD = true;
            return;
        }
        if (human1.getFather() != null && familyTree.getFamilyTree().contains(human1.getFather()))
            isDirectDescendant(human1.getFather(), human2);
        if (human1.getMother() != null && familyTree.getFamilyTree().contains(human1.getMother())) {
            isDirectDescendant(human1.getMother(), human2);
        }
    }
}
