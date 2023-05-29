import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human h1 = new Human("Галина", "Гусина", LocalDate.of(1961, 4, 17), null, null);
        Human h2 = new Human("Вячеслав", "Гусин", LocalDate.of(1959, 6, 25), null, null);
        Human h3 = new Human("Сергей", "Гусин", LocalDate.of(1982, 12, 15), h1, h2);
        Human h4 = new Human("Евгения", "Петрова", LocalDate.of(1985, 9, 20), h1, h2);
        Human h5 = new Human("Александр", "Петров", LocalDate.of(2010, 5, 7), h4, null);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(h1);
        familyTree.addHuman(h2);
        familyTree.addHuman(h3);
        familyTree.addHuman(h4);
        familyTree.addHuman(h5);

        System.out.println("--------------------------------");
        System.out.println("Фамильное дерево:");
        System.out.println(familyTree.getHumanList());

        String name = "Галина";
        System.out.println("--------------------------------");
        System.out.println("Поиск по имени:");
        Human findHuman = familyTree.findHumanByName(name);
        System.out.println(name);
        System.out.println(findHuman);

        String year = "2010";
        System.out.println("--------------------------------");
        System.out.println("Поиск по дате рождения: ");
        Human findHumanByDate = familyTree.findHumanByBirthDate(year);
        System.out.println(year);
        System.out.println(findHumanByDate);

        System.out.println("--------------------------------");
        System.out.println("Сколько лет человеку:");
        System.out.println(h4);
        Integer humanYearsOld = familyTree.getHumanYearsOld(h4);
        System.out.println(humanYearsOld + " полных лет");

        System.out.println("--------------------------------");
        System.out.println("Поиск родителей: ");
        List<Human> parents = familyTree.getParents(h3);
        System.out.println(h3);
        System.out.println(parents);

        System.out.println("--------------------------------");
        System.out.println("Поиск детей: ");
        List<Human> children = familyTree.getChildren(h2);
        System.out.println(h2);
        System.out.println(children);
    }
}