import model.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        Service service = new Service();

//        createTestFamilyTree(service);

        new Presenter(view, service);
        view.run();
    }

    public static void createTestFamilyTree(Service service) {
        service.addHuman("Галина", "Гусина", LocalDate.of(1961, 4, 17), null, null, null, null, null);
        service.addHuman("Вячеслав", "Гусин", LocalDate.of(1959, 6, 25), null, null, null, null, null);
        service.addHuman("Сергей", "Гусин", LocalDate.of(1980, 12, 15), null, "Галина", "Гусина", "Вячеслав", "Гусин");
        service.addHuman("Евгения", "Петрова", LocalDate.of(1985, 9, 20), null, "Галина", "Гусина", "Вячеслав", "Гусин");
        service.addHuman("Александр", "Петров", LocalDate.of(2010, 5, 7), null, "Евгения", "Петрова", null, null);
    }
}
