package family_tree.model.tree.tree_service;
import family_tree.model.tree.FamilyTree;

public class Tree_service {

    public FamilyTree sortById(FamilyTree family_tree){
        family_tree.sortById();
        return  family_tree;
    }
    public FamilyTree sortByName(FamilyTree family_tree){
         family_tree.sortByName();
         return  family_tree;
    }

    public FamilyTree sortByAge(FamilyTree family_tree){
         family_tree.sortByAge();
        return  family_tree;
    }
}
