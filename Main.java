import Input_output.FileHandler;
import members.Human;
import tree_structure.FamilyTree;

/**
 * Main
 */


 public class Main {

    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree(100);
        Human human1 = new Human("Alexey", "Petrenko" , null);
        Human human2 = new Human("Sergey", "Ivanov", "Sergeevich");
        
        System.out.println(familyTree.getHumanInfo());
        FileHandler.ObjectOutputStream(human1);
        FileHandler.ObjectInputStream(human1);
    }
}