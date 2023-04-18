import tree.FamilyTree;
import tree.Gender;
import tree.Human;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(Gender.Male, "Steven Tyler");
        Human human2 = new Human(Gender.Female, "Beverle Buell");
        Human human3 = new Human(Gender.Female, "Liv Tyler", human2, human1);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        // System.out.println(human3);
        // System.out.println(human2);
        System.out.println(familyTree.getInfo());
    }
}
