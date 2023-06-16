package tree.model.humanService;

import tree.model.familyTree.TreeItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindHumanService<T extends TreeItem<T>> {

    private List<T> familyTree;

    public FindHumanService(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public T findHuman(String name) {
        for (T human : familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<T> findParent(T human) {
        List<T> parents = new ArrayList<>();
        T father, mother;
        if (human != null) {
            father = human.getFather();
            if (father != null) parents.add(father);
            mother = human.getMother();
            if (mother != null) parents.add(mother);
        }
        return parents;
    }

    public Set<T> findChildren(T human) {
        return human.getChildrenList();
    }

    public boolean containsHumanInTree(T human) {
        return human != null && findHuman(human.getName()) != null;
    }
}
