package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;
import tree.model.human.Gender;
import tree.model.human.Human;

import static tree.model.human.Gender.man;

public class AddHumanService<T extends TreeItem<T>> {

    private Tree<T> familyTree;

    public AddHumanService(Tree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(T human) {
        familyTree.addHuman(human);
      }

    public void addHuman(T human, T father, T mother) {
        addHuman(human);
        addParent(human, father);
        addParent(human, mother);
      }

    public void addParent(T child, T parent) {

        if (child != null && parent != null) {
            if (parent.getGender() == man) {
                if (child.getFather() == null) {
                    child.setFather(parent);
                    parent.setChildren(child);
                } else {
                    System.out.printf("У %s уже есть отец %s\n", child.getName(), child.getFather().getName());
                }
            } else if (child.getMother() == null) {
                child.setMother(parent);
                parent.setChildren(child);
                } else {
                System.out.printf("У %s уже есть мать %s\n", child.getName(), child.getMother().getName());
            }
        }
    }

    private void addChildren(T parent, T child) {
        if (parent != null && child != null)
            parent.setChildren(child);
    }
}
