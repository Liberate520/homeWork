package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;

import static tree.model.human.Gender.man;

public class AddHumanService<T extends TreeItem<T>> {

    public void addHuman(T human, Tree<T> tree) {
        tree.addHuman(human);
      }

    public void addHuman(T human, T father, T mother, Tree<T> tree) {
        tree.addHuman(human);
        addParent(human, father);
        addParent(human, mother);
      }

    public boolean addParent(T child, T parent) {

        if (child != null && parent != null) {
            if (parent.getGender() == man) {
                if (child.getFather() == null) {
                    child.setFather(parent);
                    parent.setChildren(child);
                    return true;
                }
            } else if (child.getMother() == null) {
                child.setMother(parent);
                parent.setChildren(child);
                return true;
            }
        }
        return false;
    }

    private void addChildren(T parent, T child) {
        if (parent != null && child != null)
            parent.setChildren(child);
    }
}
