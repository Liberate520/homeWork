import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        //        List<Human> tree = new ArrayList<>();
        FamilyTree tree = new FamilyTree();

        Human man1 = new Human("Николай", "Иванов", Gender.Male, "Петр",
                "", new Date(1950, 01, 01)); // Петрович
        Human man2 = new Human("Светлана", "Иванова", Gender.Female, "Иван",
                "", new Date(1950, 01, 02));
        Human man3 = new Human("Петр", "Иванов", Gender.Male, "Николай",
                "Светлана", new Date(1970, 02, 03)); // Ивановна
        Human man4 = new Human("Лиза", "Иванова", Gender.Female, "Николай",
                "Светлана", new Date(1970, 11, 03));
        Human man5 = new Human("Наталья", "Сидорова", Gender.Female, "Петровна",
                "", new Date(1970, 05, 05));
        Human man6 = new Human("Николай", "Иванов", Gender.Male, "Петр",
                "Наталья", new Date(1990, 03, 03));
        Human man7 = new Human("Татьяна", "Иванова", Gender.Female, "Петр",
                "Наталья", new Date(1995, 01, 05));
        System.out.println(man1.getInfo());
        System.out.println(man7.getInfo());
        tree.add(man1);
        tree.add(man2);
        tree.add(man3);
        tree.add(man4);
        tree.add(man5);
        tree.add(man6);
        tree.add(man7);
        System.out.println(tree);

        System.out.println(tree.getListChildren("Петр", "Иванов"));

    }
}
