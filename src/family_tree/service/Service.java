package family_tree.service;

import family_tree.family.FamilyTree;
import family_tree.family.TreeNode;

public class Service<T extends TreeNode<T>> {

    public Service() {
    }

    public String getHumanListInfo(FamilyTree<T> tree) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи:\n");
        for (T human : tree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(FamilyTree<T> tree){
        tree.sortByName();
    }

    public void sortByAge(FamilyTree<T> tree){
        tree.sortByAge();
    }
}
