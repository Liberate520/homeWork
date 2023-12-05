public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human people1 = new Human("Маша",Gender.Female);
        Human people2 = new Human("Паша", Gender.Male);
        Human people3 = new Human("Катя", Gender.Female,people1,people2);

        FamilyTree.addHuman(people1);
        FamilyTree.addHuman(people2);
        System.out.println();
    }

}
