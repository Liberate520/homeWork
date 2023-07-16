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

    public String sortBy_choice(String sort_by, FamilyTree<Human> familyTree) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (sort_by) {
            case "2" -> stringBuilder.append(sortByName(familyTree));
            case "3" -> stringBuilder.append(sortByAge(familyTree));
            default -> stringBuilder.append(sortById(familyTree));
        }
        return stringBuilder.toString();
    }
}
