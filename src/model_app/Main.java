package model_app;

import family_tree.FamilyTree;
import family_tree.Human;
import static family_tree.FamilyTree.createTree;


public class Main {
    public static void main(String[] args) {
        Human root = createTree();
        FamilyTree t = new FamilyTree();
        t.display(root,1);
    }

}
