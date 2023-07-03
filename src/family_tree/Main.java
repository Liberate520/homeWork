package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human zhenya = new Human("Евгений", Gender.Male, LocalDate.of(1985, 9, 1));
        Human anya = new Human("Анна", Gender.Female, LocalDate.of(1987, 7, 26 ));
        tree.add(zhenya);
        tree.add(anya);
        tree.setWedding(zhenya.getId(), anya.getId());

        Human artem = new Human("Артем", Gender.Male, LocalDate.of(2013, 10, 11), zhenya, anya);
        Human styapa = new Human("Степан", Gender.Male, LocalDate.of(2015, 10, 19), zhenya, anya);
        tree.add(artem);
        tree.add(styapa);

        Human luba = new Human("Любовь", Gender.Female, LocalDate.of(1962, 6, 13));
        Human galya = new Human("Галина", Gender.Female, LocalDate.of(1968, 8, 29));
        luba.addChild(zhenya);
        galya.addChild(anya);
        tree.add(luba);
        tree.add(galya);

        Human yura = new Human("Юрий", Gender.Male, LocalDate.of(1962, 4, 24));
        Human ruslan = new Human("Руслан", Gender.Male, LocalDate.of(1968, 11, 25));
        yura.addChild(zhenya);
        ruslan.addChild(anya);
        tree.add(yura);
        tree.add(ruslan);

        System.out.println(tree);
        FileHandler serializer = new FileHandler();
        serializer.save(tree, "tree.txt");

        FamilyTree loadedFamilyTree = (FamilyTree) serializer.load("tree.txt");
        System.out.println("Загруженное дерево: " + loadedFamilyTree.toString());
    }
}
