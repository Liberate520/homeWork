import geotree.GeoTree;
import geotree.GeoTreeIO;
import geotree.Research;
import person.Gender;
import person.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.IOException;

import presenter.Presenter;
import ui.DesktopUI;
import ui.View;


public class Main {
    public static void main(String[] args) {
        View view = new DesktopUI();
        GeoTree gt = new GeoTree();
        Person irina = new Person("Ирина", new GregorianCalendar(1985, Calendar.JANUARY, 13), Gender.Female);
        Person igor = new Person("Игорь", new GregorianCalendar(1984, Calendar.OCTOBER, 25),Gender.Male);
        Person vasya = new Person("Вася", new GregorianCalendar(2001, Calendar.MARCH, 17),Gender.Male, irina, igor);
        Person masha = new Person("Маша", new GregorianCalendar(1997, Calendar.MAY, 20),Gender.Female, irina, igor);
        gt.appendPerson(irina);
        gt.appendPerson(masha);
        gt.appendPerson(igor);
        gt.appendPerson(vasya);
        gt.autoAppendChildren();
        Research research = new Research(gt);
        Presenter presenter = new Presenter(view, research);
        view.start();
    }
}
