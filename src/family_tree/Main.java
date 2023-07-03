package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Alex", LocalDate.of(1914, 7, 28), Gender.Male);
        Human human2 = new Human("Susan", LocalDate.of(1917, 3, 24), Gender.Female);
        Human human3 = new Human("Bob", LocalDate.of(1935, 3, 12), Gender.Male);
        human1.setDeathDate(LocalDate.of(1964, 3, 2));
        human2.setDeathDate(LocalDate.of(1964, 3, 2));
        human3.createFamily(human1, human2, human3);
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        System.out.println(familyTree.getFamilyTree());

        Human human4 = new Human("Olga", LocalDate.of(1915, 12, 5), Gender.Female);
        Human human5 = new Human("Mathew", LocalDate.of(1913, 7, 30), Gender.Male);
        Human human6 = new Human("Mary", LocalDate.of(1938, 5, 12), Gender.Female);
        human4.setDeathDate(LocalDate.of(1964, 3, 2));
        human5.setDeathDate(LocalDate.of(1964, 3, 2));
        human6.createFamily(human4, human5, human6);
        FamilyTree familyTree2 = new FamilyTree();
        familyTree2.addHuman(human4);
        familyTree2.addHuman(human5);
        familyTree2.addHuman(human6);
        System.out.println(familyTree2.getFamilyTree());

        Human human7 = new Human("Andrew", LocalDate.of(1958, 6, 13), Gender.Male);
        human7.createFamily(human3, human6, human7);
        FamilyTree familyTree3 = new FamilyTree();
        familyTree3.addHuman(human3);
        familyTree3.addHuman(human6);
        familyTree3.addHuman(human7);
        System.out.println(familyTree3.getFamilyTree());
    }
}
