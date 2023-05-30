import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Василий", "Иванов", Gender.Male, LocalDate.of(1991, 12, 25)));
        tree.add(new Human("Кристина", "Иванова", Gender.Female, LocalDate.of(1988, 1, 2)));

        tree.add(new Human("Ольга", "Иванова",Gender.Female, LocalDate.of(1988, 1, 2),
                null, tree.getByFirstName("Василий"),tree.getByFirstName("Кристина")));
        tree.add(new Human("Иван", "Иванов",Gender.Male, LocalDate.of(1988, 5, 6),
                null, tree.getByFirstName("Василий"),tree.getByFirstName("Кристина")));

        tree.add(new Human("Нина", "Крылатова",Gender.Female, LocalDate.of(1971, 5, 9),
                null, tree.getByFirstName("Иван"),tree.getByFirstName("Кристина")));

        System.out.println(tree.getInfo());

    }

}
