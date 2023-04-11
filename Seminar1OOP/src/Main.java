// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        familyTree.addHuman(new Human("Сабина", 1965, "f"));
        familyTree.addHuman(new Human("Сергей", 1959, "m"));
        familyTree.addHuman(new Human("Диана", 1989, "f"));
        familyTree.addHuman(new Human("Тимур", 1994, "m"));
        familyTree.addHuman(new Human("Томирис", 1987, "f"));

        System.out.println(familyTree.getHumanByName("Тимур"));
        System.out.println(familyTree.getAllHuman());
    }
}