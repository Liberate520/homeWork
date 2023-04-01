import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Human> people = new ArrayList<>();
        people.add(new Human(Gender.male, "Петр", "Петров", LocalDate.of(1930, 1, 1), LocalDate.of(2010, 12, 31)));
        people.add(new Human(Gender.female, "Прасковья", "Петрова", LocalDate.of(1940, 1, 1), LocalDate.of(2020, 12, 31)));
        people.add(new Human(Gender.male, "Иван", "Иванов", LocalDate.of(1935, 1, 1), LocalDate.of(2020, 12, 31)));
        people.add(new Human(Gender.female, "Иванка", "Иванова", LocalDate.of(1945, 1, 1), LocalDate.of(2020, 12, 31)));

        people.add(new Human(Gender.male, "Фёдор", "Петров", LocalDate.of(1960, 1, 1)));
        people.add(new Human(Gender.female, "Фаина", "Петрова", LocalDate.of(1965, 1, 1)));
        people.add(new Human(Gender.male, "Филип", "Петров", LocalDate.of(1970, 1, 1)));

        people.add(new Human(Gender.female, "Людмила", "Иванова", LocalDate.of(1965, 1, 1)));
        people.add(new Human(Gender.male, "Леонид", "Иванов", LocalDate.of(1970, 1, 1)));

        people.add(new Human(Gender.female, "Игнат", "Петров", LocalDate.of(1975, 1, 1)));
        people.add(new Human(Gender.female, "Ирина", "Иванова", LocalDate.of(1980, 1, 1)));

        System.out.println(people);
        System.out.println("-----");
        people.get(4).setFather(people.get(0));

        FamilyTree family01 = new FamilyTree(people);

        family01.printChildren(people.get(0));
    }
}
