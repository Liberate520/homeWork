package family_tree.controller;

import family_tree.model.base.FileHandlerForTree;
import family_tree.model.base.TreeNode;
import family_tree.model.human.Human;
import family_tree.view.ConsoleUI;
import family_tree.view.View;
import family_tree.model.family_tree.FamilyTree;
import static family_tree.model.family_tree.FamilyTree.methodSortByLastName;

public class Controller {

    private View view;
    private FamilyTree familyTree;

    public Controller(View view) {
        this.view = view;
        familyTree = new FamilyTree();
    }

    public void getFamilyListInfo() {
        /*String info = */FileHandlerForTree.HandlerForTree();
//        view.printAnswer(info);
    }


    public void sortByAge() {
//        FamilyTree familyTree = new FamilyTree(); /* доработать до точных данных */
//        familyTree.methodSortByAge(humans);
    }
}
