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

    public String sortBy_id(FamilyTree<Human> familyTree) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sortById(familyTree));
        return stringBuilder.toString();
    }

    public String sortBy_age(FamilyTree<Human> familyTree) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sortByAge(familyTree));
        return stringBuilder.toString();
    }

    public String sortBy_name(FamilyTree<Human> familyTree) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sortByName(familyTree));
        return stringBuilder.toString();
    }



}
