import java.util.ArrayList;

public class FamilyTree {

    ArrayList<Human> treeHuman = new ArrayList<Human>();


    // вывод в виде дерева
    public void preOrder(Human tree, String space) {
        if (tree != null)
            System.out.println(space + tree.name);
        else {
            System.out.println(space + "nil");
            return;
        }

        for (int i = 0; i < tree.son.size(); i++){
            preOrder(tree.son.get(i).getH2(), space + "  ");
        }
    }
}
