
public class Main {

    public static void main(String[] args) {
        String filePath = "src/tree.txt";
        Writable writable = new FileHandler();

        // Human human1 = new Human("Anton", "Repov", "02.12.2000", Gender.Male);
        // Human human2 = new Human("Anna", "Repova", "12.05.2002", Gender.Female);
        // Human human3 = new Human("Fergat", "Repov", "12.05.2020", Gender.Female, human1, human2);
        // FamilyTree familyTree = new FamilyTree();
        // familyTree.addHuman(human1);
        // familyTree.addHuman(human2);
        // familyTree.addHuman(human3);
        // System.out.println(familyTree.getInfo());
        // System.out.println("-----------------------------------");
        // System.out.println(familyTree.getHumanByName("Fergat"));
        // System.out.println("-----------------------------------");

        // writable.save(familyTree, filePath);
        FamilyTree familyTree = (FamilyTree) writable.read(filePath);
        System.out.println(familyTree.getInfo());
    }
}
