package family_tree;

import java.time.LocalDate;
// import java.util.List;

public class Main {
    public static void main (String [] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human ("Анна", Gender.Female, 
        LocalDate.of(1981, 1, 11),
        tree.getByName("Нина"), tree.getByName("Иван")));

        tree.add(new Human ("Борис", Gender.Male, 
        LocalDate.of(1980, 2, 15)));

        tree.add(new Human ("Арина", Gender.Female, 
        LocalDate.of(2010, 3, 30),
        tree.getByName("Анна"), tree.getByName("Борис")));

        tree.add(new Human ("Глеб", Gender.Male, 
        LocalDate.of(2015, 4, 21),
        tree.getByName("Анна"), tree.getByName("Борис")));

        tree.add(new Human ("Нина", Gender.Female, 
        LocalDate.of(1975, 5, 7)));

        tree.add(new Human ("Иван", Gender.Male, 
        LocalDate.of(1970, 6, 28)));


        Human grandMother = new Human("Клавдия", Gender.Female, LocalDate.of(1950, 8, 15));
        grandMother.addChild(tree.getByName("Нина"));
        grandMother.addChild(tree.getByName("Анна"));
        tree.add(grandMother);

        System.out.println(tree.getInfo());
    }
}