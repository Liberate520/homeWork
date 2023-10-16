import Input_output.FileHandler;
import members.Dog;
import members.Human;
//import service.HumanSort;
//import service.Service;
import tree_structure.FamilyTree;
import tree_structure.Subject;

/**
 * Main
 */


 public class Main {

    public static void main(String[] args) {


        FamilyTree familyTree = new FamilyTree(1);
        Human human1 = new Human("Alexey", "Petrenko" , null, "Moscow");
        Human human2 = new Human("Sergey", "Ivanov", "Sergeevich", "Vladimir");
        Human human3 = new Human("Boris", "Alexandrov" , null, "Nizhni Novgorod");
        Human human4 = new Human("Dmitry", "Borisov", "Sergeevich", "SPb");
        Dog dog1 = new Dog ("Sharik", true, 31122022);


        String filepath = "FamilyTree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filepath);
        System.out.println(tree);

        fileHandler.save(tree, filepath);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addDog(dog1);
        
        System.out.println(familyTree.getHumanInfo());

        familyTree.sortbyName();
        System.out.println(familyTree.getHumanInfo());
        familyTree.sortbyBirthdate();
        System.out.println(familyTree.getHumanInfo());
        familyTree.sortbySurname();
        System.out.println(familyTree.getHumanInfo());

        System.out.println(familyTree.getDogInfo());




    
    }
}