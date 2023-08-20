package modell.file_handler;

import modell.fam_tree.FamilyTree;
import modell.fam_tree.TreeNode;

public interface SaveToFile<E extends TreeNode<E>> {
    public boolean saveToFile(FamilyTree<E> tree);
    public FamilyTree<E> loadFromFile();
}
