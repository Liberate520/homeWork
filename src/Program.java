import human.*;
import family.*;
import services.FileHandler;
import services.Service;
import services.Writable;

import java.io.IOException;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree family = new FamilyTree();
        family.addHuman(new Human(
                Gender.male,
                "Пётр",
                "Аркадьевич",
                "Иванов",
                LocalDate.of(1964, 6, 20),
                LocalDate.of(2020,5,5)
        ));
        family.addHuman(new Human(
                Gender.female,
                "Лариса",
                "Викторовна",
                "Иванова",
                LocalDate.of(1965, 4, 22)
        ));
        family.addHuman(new Human(
                Gender.male,
                "Михаил",
                "Юрьевич",
                "Сидоров",
                LocalDate.of(1965, 4, 14)
        ));
        family.addHuman(new Human(
                Gender.female,
                "Светлана",
                "Анатольевна",
                "Сидорова",
                LocalDate.of(1966, 2, 2)
        ));
        family.addHuman(new Human(
                Gender.male,
                "Иван",
                "Петрович",
                "Иванов",
                LocalDate.of(1980, 10, 10),
                null,
                family.getByName("Пётр Аркадьевич Иванов"),
                family.getByName("Лариса Викторовна Иванова")
        ));
        family.addHuman(new Human(
                Gender.female,
                "Татьяна",
                "Михайловна",
                "Иванова",
                LocalDate.of(1985, 3, 30),
                null,
                family.getByName("Михаил Юрьевич Сидоров"),
                family.getByName("Светлана Анатольевна Сидорова")
        ));
        family.addHuman(new Human(
                Gender.female,
                "Фаина",
                "Ивановна",
                "Иванова",
                LocalDate.of(2015, 5, 5),
                null,
                family.getByName("Иван Петрович Иванов"),
                family.getByName("Татьяна Михайловна Иванова")
        ));
        family.addHuman(new Human(
                Gender.male,
                "Фёдор",
                "Иванович",
                "Иванов",
                LocalDate.of(2020, 1, 1),
                null,
                family.getByName("Иван Петрович Иванов"),
                family.getByName("Татьяна Михайловна Иванова")
        ));

        System.out.println(family.getByName("Пётр Аркадьевич Иванов"));
        System.out.println("--------------------------------");
        family.printChildren(family.getByName("Иван Петрович Иванов"));
        System.out.println("--------------------------------");
        family.printChildren(family.getByName("Татьяна Михайловна Иванова"));
        System.out.println("--------------------------------");
        family.printChildren(family.getByName("Фёдор Иванович Иванов"));

        // урок 2
        System.out.println("----------------L2----------------");
        Writable writable = new FileHandler();
        family.save(writable);
        FamilyTree familySave = (FamilyTree) writable.read();
        familySave.printChildren(family.getByName("Иван Петрович Иванов"));

        // урок 3
        System.out.println("----------------L3----------------");
        for (Human human : familySave) {
            System.out.println(human);
        }
        System.out.println("\nСортировка по имени:");
        Service service = new Service((FamilyTree) writable.read());
        service.sortHuman(new CompHumanByName());
        for (Human human : service.getFamily()) {
            System.out.println(human);
        }
        System.out.println("\nСортировка по дате рождения в обратном порядке:");
        service.sortHuman(new CompHumanByDBR());
        for (Human human : service.getFamily()) {
            System.out.println(human);
        }

    }
}
