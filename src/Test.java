public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human people1 = new Human("Мария",Gender.Female);
        Human people2 = new Human("Павел", Gender.Male);
        Human people3 = new Human("Екатерина", Gender.Female,people1,people2);

        FamilyTree.addHuman(people1);
        FamilyTree.addHuman(people2);
        FamilyTree.addHuman(people3);
        System.out.println(familyTree.getInfo());
    }

}
