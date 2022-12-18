public class Main {

    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Vitaliy", "male");
        Human human2 = new Human("Natalia", "female");
        Human human3 = new Human("Lidia", "female", human1, human2);
        Human human4 = new Human("Ilya", "male");
        Human human5 = new Human("Roman", "male", human4, human3);
        Human human6 = new Human("Victor", "male", human4, human3);
        Human human7 = new Human("Ivan", "male", human4, human3);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        System.out.println("Family tree: ");
        System.out.println(familyTree);

        System.out.println("Find by name: ");
        System.out.println(familyTree.getHumanByName("Lidia"));
    }
}
