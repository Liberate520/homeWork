import presenter.Presenter;
import treeUnits.*;
import tree.*;
import treeUnits.comparators.*;
import svc.FileHandler;
import svc.Service;
import svc.Writable;
import ui.*;

import java.io.IOException;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Service<TreeUnit> service = new Service<>();
//        service.addUnit(new Human(
//                Gender.male,
//                "Пётр",
//                "Аркадьевич",
//                "Иванов",
//                LocalDate.of(1964, 6, 20),
//                LocalDate.of(2020, 5, 5)
//        ));
//        service.addUnit(new Human(
//                Gender.female,
//                "Лариса",
//                "Викторовна",
//                "Иванова",
//                LocalDate.of(1965, 4, 22)
//        ));
//        service.addUnit(new Human(
//                Gender.male,
//                "Михаил",
//                "Юрьевич",
//                "Сидоров",
//                LocalDate.of(1965, 4, 14)
//        ));
//        service.addUnit(new Human(
//                Gender.female,
//                "Светлана",
//                "Анатольевна",
//                "Сидорова",
//                LocalDate.of(1966, 2, 2)
//        ));
//        service.addUnit(new Human(
//                Gender.male,
//                "Иван",
//                "Петрович",
//                "Иванов",
//                LocalDate.of(1980, 10, 10),
//                null,
//                (Human) service.getUnitByName("Пётр Аркадьевич Иванов"),
//                (Human) service.getUnitByName("Лариса Викторовна Иванова")
//        ));
//        service.addUnit(new Human(
//                Gender.female,
//                "Татьяна",
//                "Михайловна",
//                "Иванова",
//                LocalDate.of(1985, 3, 30),
//                null,
//                (Human) service.getUnitByName("Михаил Юрьевич Сидоров"),
//                (Human) service.getUnitByName("Светлана Анатольевна Сидорова")
//        ));
//        service.addUnit(new Human(
//                Gender.female,
//                "Фаина",
//                "Ивановна",
//                "Иванова",
//                LocalDate.of(2015, 5, 5),
//                null,
//                (Human) service.getUnitByName("Иван Петрович Иванов"),
//                (Human) service.getUnitByName("Татьяна Михайловна Иванова")
//        ));
//        service.addUnit(new Human(
//                Gender.male,
//                "Фёдор",
//                "Иванович",
//                "Иванов",
//                LocalDate.of(2020, 1, 1),
//                null,
//                (Human) service.getUnitByName("Иван Петрович Иванов"),
//                (Human) service.getUnitByName("Татьяна Михайловна Иванова")
//        ));

//        System.out.println("\nСортировка по имени:");
//        Service service = new Service((FamilyTree) writable.read());
//        service.sortHuman(new CompHumanByName());
//        for (Human human : service.getFamily()) {
//            System.out.println(human);
//        }
//        Writable writable = new FileHandler();
//        service.save(writable);
//
//        service.getUnitByName("Иван Петрович Иванов").printFullInfo();
//
//        System.out.println("Сортировка по дате рождения:");
//        service.sortHuman(new CompHumanByDB());
//        for (TreeUnit human : service.getFamilyTree()) {
//            System.out.println(human.getInfo());
//        }

        View view = new Console();
        new Presenter(view);
        view.start();

    }
}
