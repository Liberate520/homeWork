package tree.model.humanService;

import tree.model.familyTree.TreeItem;
import java.util.List;
import static tree.model.human.Gender.man;

public class AddHumanService<T extends TreeItem<T>> {
    private List<T> familyTree;

    public AddHumanService(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(T human) {
        familyTree.add(human);
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
