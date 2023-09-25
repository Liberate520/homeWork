import members.Human;
import tree_structure.FamilyTree;

/**
 * Main
 */


 public class Main {

    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree(1);
        Human human1 = new Human("Alexey", "Petrenko" , null);
        Human human2 = new Human("Sergey", "Ivanov", "Sergeevich");
        
        System.out.println(familyTree.getHumanInfo());
    }
}