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
        Human styapa = new Human("Степан", Gender.Male, LocalDate.of(2015, 10, 19),
                zhenya, anya);
        tree.add(artem);
        tree.add(styapa);

        Human luba = new Human("Любовь", Gender.Female, LocalDate.of(1962, 6, 13));
        luba.addChild(zhenya);
        tree.add(luba);

        System.out.println(tree);
    }
}
