import presenter.Presenter;
import tree.FamilyTree;
import tree.Service;
import tree.fileHandler.FileHandler;
import tree.fileHandler.Writable;
import tree.human.Cat;
import tree.human.Gender;
import tree.human.Human;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args) {
        // Human human1 = new Human(Gender.Male, "Steven Tyler", 70);
        // Human human2 = new Human(Gender.Female, "Beverle Buell", 68);
        // Human human3 = new Human(Gender.Female, "Liv Tyler", 45);
        // Human human4 = new Human(Gender.Male, "Liv's brother", 46);
        // Human human5 = new Human(Gender.Male, "Stiven's father", 95);
        // Human human6 = new Human(Gender.Female, "Stiven's mother", 90);
        // Human human7 = new Human(Gender.Male, "Beverle's father", 92);
        // Human human8 = new Human(Gender.Female, "Beverle's mother", 91);
        

        // human1.addChild(human3);
        // human1.addChild(human4);
        // human1.addHusband(human2);
        // human1.setFather(human5);
        // human2.setFather(human7);
        // human1.setMother(human6);
        // human2.setMother(human8);

        // FamilyTree<Human> familyTree = new FamilyTree<>();
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

        // String filePath = "src/tree/familyTreeFile.txt";
        // Writable writable = new FileHandler();

        // FamilyTree familyTree = (FamilyTree) writable.read(filePath);
        // writable.save(familyTree, filePath);
        // System.out.println(familyTree.getInfo());
        // familyTree.sortByAge();
        // System.out.println("--------------------");
        // System.out.println(familyTree.getInfo());


        // Cat cat1 = new Cat(Gender.Male, "Кокос", 2, null, null, null, "Британец");
        // Cat cat2 = new Cat(Gender.Female, "Мандаринка", 7, null, null, null, "Британец");
        // Cat cat3 = new Cat(Gender.Male, "Персик", 3, null, null, null, "Мейн кун");
        // cat2.addChild(cat1);
        // FamilyTree<Cat> catsFamilyTree = new FamilyTree<>();
        // catsFamilyTree.addHuman(cat1);
        // catsFamilyTree.addHuman(cat2);
        // catsFamilyTree.addHuman(cat3);
        // System.out.println("--------------------");
        // System.out.println(catsFamilyTree.getInfo());

        Writable writable = new FileHandler();
        View view = new Console();
        Service service = new Service(writable);
        new Presenter(view, service);

        view.start();
        
    }
}
