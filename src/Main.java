import familyTree.FamilyTree;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        familyTree.readFromFile("Human.txt");
        System.out.println(familyTree.getPeople());

        familyTree.saveToFile("Human.txt");

    }

}
