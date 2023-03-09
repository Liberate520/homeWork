import java.util.ArrayList;



public class FamilyTree {
    ArrayList<Human> treeHuman = new ArrayList<Human>();


    public void PreOreder (Human tree, String space) {
        if (tree != null)
            System.out.println(space + tree.name);
        else {
            System.out.println(space + "nil");
            return;
        }

        for (int i = 0; i < tree.son.size(); i++){
            PreOreder(tree.son.get(i).getH2(), space + " ");
        }

    }

}