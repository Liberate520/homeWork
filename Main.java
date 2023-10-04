import Input_output.FileHandler;
import members.Human;
import service.Service;
import tree_structure.FamilyTree;

/**
 * Main
 */


 public class Main {

    public static void main(String[] args) {


        FamilyTree familyTree = new FamilyTree(1);
        Human human1 = new Human("Alexey", "Petrenko" , null, "Moscow");
        Human human2 = new Human("Sergey", "Ivanov", "Sergeevich", "Vladimir");
        Human human3 = new Human("Alexey", "Petrenko" , null, "Nizhni Novgorod");
        Human human4 = new Human("Sergey", "Ivanov", "Sergeevich", "SPb");


        String filepath = "FamilyTree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filepath);
        //System.out.println(tree);

        fileHandler.save(tree, filepath);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        
        System.out.println(familyTree.getHumanInfo());
        
        //Service service = new Service();
        //service.sortByBirthdate();
        //service.sortByName();

        System.out.println(tree);




    
    }
}