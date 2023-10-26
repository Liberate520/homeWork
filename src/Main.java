public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(1);

        Human human1 = new Human("Виталий", "Иванов", Gender.Male);
        Human human2 = new Human("Елена", "Иванова", Gender.Female);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);

        System.out.println(familyTree.getHumansInfo());
    }
}