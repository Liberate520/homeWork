public class Main {
    public static void main(String[] args) {
        // FamilyTree familyTree = new FamilyTree(1);
        FamilyTree familyTree = load();

        Human human1 = new Human("Виталий", "Иванов", Gender.Male);
        Human human2 = new Human("Елена", "Иванова", Gender.Female);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);

        System.out.println(familyTree.getHumansInfo());

        write(familyTree);
    }

    private static void write(FamilyTree familyTree) {
        String filepath = "src/text/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(familyTree, filepath);
    }

    private static FamilyTree load() {
        String filepath = "src/text/tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = (FamilyTree) fileHandler.read(filepath);
        return familyTree;
    }
}