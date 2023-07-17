package family_tree.ui;

import family_tree.familytree.FamilyTree;
import family_tree.familytree.FamilyTreeItem;
import family_tree.person.Person;

public interface View<T extends FamilyTreeItem<T>> {
    void start(FamilyTree<T> tree);
    void print(String text);
}
