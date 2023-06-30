import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree("myFamilyTree");
        Human andrey = new Human("Andrey", "Shevchuk", "Alexandrovich",
                new GregorianCalendar(1983, Calendar.JULY, 1),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(), Gender.male);

        Human alexandr = new Human("Alexandr", "Shevchuk", "Borisovich",
                new GregorianCalendar(1959, Calendar.APRIL, 30),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(), Gender.male);
        Human natalia = new Human("Natalia", "Shevchuk", "Alexandrovna",
                new GregorianCalendar(1961, Calendar.FEBRUARY, 22),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(Arrays.asList(new Human(),
                        new Human())), Gender.female);
        Human anna = new Human("Anna", "Tihomirova", "Alexandrovna",
                new GregorianCalendar(1985, Calendar.MAY, 12),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(), Gender.female);
        Human anastasia = new Human("Anastasia", "Shevchuk", "Andreevna",
                new GregorianCalendar(2013, Calendar.APRIL, 6),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(), Gender.female);
        Human alexandrJ = new Human("Alexandr", "Shevchuk", "Andreevich",
                new GregorianCalendar(2018, Calendar.FEBRUARY, 4),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(),Gender.male);
        Human olga = new Human("Olga", "Shevchuk", "Alexandrovna",
                new GregorianCalendar(1987, Calendar.MAY, 20),//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),
                new ArrayList<Human>(), Gender.female);
        Human alexandrP = new Human("Alexandr", "Popov", "Valerevich");
        Human galina = new Human("Galina", "Popova", "Arkadevna");
        Human boris = new Human("Boris", "Shevchuk", "Filipovich");
        Human alexandra = new Human("Alexandra", "Shevchuk", "Pavlovna");
        Human alexandrM = new Human("Alexandr", "Miheev", "Iosifovich");
        Human alexandraM = new Human("Alexandra", "Miheeva", "Andreevna");

        andrey.setFatherAndMother(alexandr, natalia);
        anna.setFatherAndMother(alexandr, natalia);
        anastasia.setFatherAndMother(andrey, olga);
        alexandrJ.setFatherAndMother(andrey, olga);
        olga.setFatherAndMother(alexandrP, galina);
        alexandr.setFatherAndMother(boris, alexandra);
        natalia.setFatherAndMother(alexandrM, alexandraM);

        familyTree.addHumanAll(andrey, olga, alexandr, alexandrJ, natalia, anna, anastasia);

        andrey.setChildren(Arrays.asList(anastasia, alexandrJ));
        alexandr.setChildren(Arrays.asList(andrey, anna));
        natalia.setChildren(Arrays.asList(andrey, anna));

        System.out.println(familyTree.getAllChildren(andrey));
        System.out.println(familyTree.getAllChildren(alexandr));
        System.out.println(familyTree.getAllChildren(natalia));
    }
}
