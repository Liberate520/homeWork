import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import homeWork.geotree.GeoTree;
import homeWork.geotree.Research;
import homeWork.io.GeoTreeIO;
import homeWork.io.Service;
import homeWork.person.Gender;
import homeWork.person.Person;
import homeWork.presenter.Presenter;
import homeWork.ui.DesktopUI;
import homeWork.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new DesktopUI();
        GeoTree gt = new GeoTree();
        Service serv = new Service(new GeoTreeIO(), gt);
        Person irina = new Person("Ирина", new GregorianCalendar(1985, Calendar.JANUARY, 13), Gender.Female);
        Person igor = new Person("Игорь", new GregorianCalendar(1984, Calendar.OCTOBER, 25),Gender.Male);
        Person vasya = new Person("Вася", new GregorianCalendar(2001, Calendar.MARCH, 17),Gender.Male, irina, igor);
        Person masha = new Person("Маша", new GregorianCalendar(1997, Calendar.MAY, 20),Gender.Female, irina, igor);
        gt.appendPerson(irina);
        gt.appendPerson(masha);
        gt.appendPerson(igor);
        gt.appendPerson(vasya);
        gt.autoAppendChildren();
        serv.restoreTree();
        Research research = new Research(gt);
        Presenter presenter = new Presenter(view, research);
        view.start();
    }
}