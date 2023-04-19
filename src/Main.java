public class Main {


    public static void main(String[] args) {

        Human human1 = new Human("Anton", "Repov", "02.12.2000", Gender.Male);
        Human human2 = new Human("Anna", "Repova", "12.05.2002", Gender.Female);
        Human human3 = new Human("Fergat", "Repov", "12.05.2020", Gender.Female, human1, human2, null);
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        System.out.println(familyTree.getInfo());
        System.out.println(familyTree.getHumanByName("Fergat"));
    }
}
