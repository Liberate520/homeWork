package family_tree.model.tree.tree_service;
import family_tree.model.human.Human;
import family_tree.model.tree.FamilyTree;

public class Tree_service {

    public FamilyTree<Human> sortById(FamilyTree<Human> family_tree){
        family_tree.sortById();
        return  family_tree;
    }
    public FamilyTree<Human> sortByName(FamilyTree<Human> family_tree){
         family_tree.sortByName();
         return  family_tree;
    }

    public FamilyTree<Human> sortByAge(FamilyTree<Human> family_tree){
         family_tree.sortByAge();
        return  family_tree;
    }
}
