import tree.FamilyTree;
import tree.FileHandler;
import tree.Gender;
import tree.Human;
import tree.Writable;

public class Main {
    public static void main(String[] args) {
        // Human human1 = new Human(Gender.Male, "Steven Tyler");
        // Human human2 = new Human(Gender.Female, "Beverle Buell");
        // Human human3 = new Human(Gender.Female, "Liv Tyler");
        // Human human4 = new Human(Gender.Male, "Liv's brother");
        // Human human5 = new Human(Gender.Male, "Stiven's father");
        // Human human6 = new Human(Gender.Female, "Stiven's mother");
        // Human human7 = new Human(Gender.Male, "Beverle's father");
        // Human human8 = new Human(Gender.Female, "Beverle's mother");

        // human1.addChild(human3);
        // human1.addChild(human4);
        // human1.addHusband(human2);
        // human1.setFather(human5);
        // human2.setFather(human7);
        // human1.setMother(human6);
        // human2.setMother(human8);

        // FamilyTree familyTree = new FamilyTree();
        // familyTree.addHuman(human1);
        // familyTree.addHuman(human2);
        // familyTree.addHuman(human3);
        // familyTree.addHuman(human4);
        // familyTree.addHuman(human5);
        // familyTree.addHuman(human6);
        // familyTree.addHuman(human7);
        // familyTree.addHuman(human8);

        // System.out.println(human1);
        // System.out.println(human2);
        // System.out.println(human3);
        
        // System.out.println();
        
        // System.out.println(human1.getChildren());
        // System.out.println(human1);
        // System.out.println(human3.getParents());
        // System.out.println(human2);
        // System.out.println(human3);
        // System.out.println(human3.getGrandParents());
        // System.out.println(familyTree.getInfo());
        // System.out.println(familyTree.getHumanByName("Liv Tyler"));
        // System.out.println(familyTree.getFamilyTreeByName("Liv Tyler"));

        String filePath = "src/tree/familyTreeFile.txt";
        Writable writable = new FileHandler();

        FamilyTree tree = (FamilyTree) writable.read(filePath);
        // writable.save(familyTree, filePath);
        System.out.println(tree.getInfo());
    }
}
