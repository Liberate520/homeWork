
import familyTree.Tree;
import fileWorker.fileHandlers.FileHandler;
import human.Gender;
import human.Human;

public class program {
    public static void main(String[] args) {
        Human<Family> kostya = new Human("Kostya", "la", Gender.Male, 199);
        Human<Family> marina = new Human("Marina", "ma", Gender.Female, 199);
        Human<Family> kot = new Human("Kot", "alakr", Gender.Male, 201, kostya, marina);
        Human<Family> daria = new Human("dar", "dar", Gender.Female, 201);
        Human<Family> kotchild = new Human("Kotchild", "lakr", Gender.Male, 201, kot, daria);
        System.out.println(kostya.childs());
        Tree<Human<Family>> familyTree = new Tree<Human<Family>>(kostya);
        System.out.println(familyTree.relations);
        Service familyTreeService = new Service(familyTree);
        FileHandler saver = new FileHandler();
        familyTreeService.save(saver, "Test.json");
        familyTreeService.readFromfile("Test.json");
        familyTreeService.sortBySurName();
        familyTreeService.save(saver, "Test.json");
        familyTreeService.readFromfile("Test.json");

        

    }
}
