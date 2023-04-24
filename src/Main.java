import family.FamilyTree;
import model.Service;

import person.Human;
import person.Person;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Person> testFamily = new FamilyTree<>();
        Service<Person> service = new Service<>(testFamily);

//        service.setFileName("test4.fml");
//        testFamily = service.loadTree();
        generateTree(service);

        View view = new Console();
        Presenter presenter = new Presenter(view, service);
        view.setPresenter(presenter);
        view.start();

//        service.setFileName("test4.fml");
//        service.saveTree();

    }

    private static void generateTree (Service<Person> service) {
        service.addPerson(new Human(), "Алексей", "Яковлев",
                new Date(54, Calendar.JANUARY, 1),
                new Date(114, Calendar.JANUARY, 1), null, null, 1);
        service.addPerson(new Human(), "Алевтина", "Яковлева",
                new Date(64, Calendar.FEBRUARY, 2), null, null, null, 0);
        service.addPerson(new Human(), "Борис", "Яковлев",
                new Date(91, Calendar.FEBRUARY, 1), null, 1, 0, 6);
        service.addPerson(new Human(), "Бьянка", "Юргент",
                new Date(92, Calendar.FEBRUARY, 2), null, 1, 0, 7);
        service.addPerson(new Human(), "Богдан", "Яковлев",
                new Date(93, Calendar.MARCH, 3), null, 1, 0, 8);
        service.addPerson(new Human(), "Белла", "Юшкова",
                new Date(94, Calendar.APRIL, 4), null, 1, 0, 9);
        service.addPerson(new Human(), "Белка", "Яковлева",
                new Date(91, Calendar.MAY, 5), null, null, null, 2);
        service.addPerson(new Human(), "Билл", "Юргент",
                new Date(92, Calendar.JUNE, 5), null, null, null, 3);
        service.addPerson(new Human(), "Бибигуль", "Яковлева",
                new Date(93, Calendar.JULY, 5), null, null, null, 4);
        service.addPerson(new Human(), "Булат", "Юшков",
                new Date(94, Calendar.AUGUST, 5), null, null, null, 5);
        service.addPerson(new Human(), "Валера", "Яковлев",
                new Date(111, Calendar.SEPTEMBER, 1), null, 6, 2, null);
        service.addPerson(new Human(), "Виолетта", "Яковлева",
                new Date(112, Calendar.OCTOBER, 1), null, 6, 2, null);
        service.addPerson(new Human(), "Вилор", "Юргент",
                new Date(113, Calendar.NOVEMBER, 2), null, 3, 7, null);
        service.addPerson(new Human(), "Валя", "Юргент",
                new Date(114, Calendar.DECEMBER, 3), null, 3, 7, null);
        service.addPerson(new Human(), "Веня", "Яковлев",
                new Date(115, Calendar.MARCH, 4), null, 8, 4, null);
        service.addPerson(new Human(), "Вера", "Яковлева",
                new Date(116, Calendar.JULY, 5), null, 8, 4, null);
        service.addPerson(new Human(), "Вано", "Юшков",
                new Date(117, Calendar.AUGUST, 6), null, 5, 9, null);
        service.addPerson(new Human(), "Вета", "Юшкова",
                new Date(118, Calendar.SEPTEMBER, 7), null, 5, 9, null);
    }
}
