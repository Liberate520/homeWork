package tree.model.humanService;

import tree.model.familyTree.Tree;
import tree.model.familyTree.TreeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindHumanService<T extends TreeItem<T>>{

    public T findHuman(String name, Tree<T> tree) {
        for (T human : tree) {
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

    public boolean containsHumanInTree(T human, Tree<T> tree) {
        return human != null && findHuman(human.getName(), tree) != null;
    }
}
