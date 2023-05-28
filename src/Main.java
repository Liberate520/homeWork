import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        // Create humans
        Human sergey = new Human("Пушкин Сергей Львович", Gender.MALE,
                new GregorianCalendar(1770, Calendar.JUNE, 3),
                new GregorianCalendar(1848, Calendar.JULY, 11)); // parent to olga, aleksandr, lev
        Human nadezhda = new Human("Пушкина Надежда Осиповна", Gender.FEMALE,
                new GregorianCalendar(1775, Calendar.JUNE, 21),
                new GregorianCalendar(1836, Calendar.MARCH, 29)); // parent to olga, aleksandr, lev
        Human olga = new Human("Павлищева Ольга Сергеевна", Gender.FEMALE,
                new GregorianCalendar(1797, Calendar.DECEMBER, 1),
                new GregorianCalendar(1868, Calendar.MAY, 14)); // Пушкина -> Павлищева
        Human aleksandr = new Human("Пушкин Александр Сергеевич", Gender.MALE,
                new GregorianCalendar(1799, Calendar.JUNE, 6),
                new GregorianCalendar(1837, Calendar.FEBRUARY, 10));
        Human lev = new Human("Пушкин Лев Сергеевич", Gender.MALE,
                new GregorianCalendar(1805, Calendar.APRIL, 21),
                new GregorianCalendar(1852, Calendar.JULY, 31));
        Human natalya = new Human("Ланская Наталья Николаевна", Gender.FEMALE,
                new GregorianCalendar(1812, Calendar.SEPTEMBER, 8),
                new GregorianCalendar(1863, Calendar.DECEMBER, 8)); // Гончарова -> Пушкина -> Ланская

        // create family trees
        FamilyTree pushkinsTree = new FamilyTree("Пушкины");
        FamilyTree goncharovsTree = new FamilyTree("Гончаровы", natalya);
        FamilyTree pavlishevsTree = new FamilyTree("Павлищевы", olga);
        FamilyTree lanskieTree = new FamilyTree("Ланские", natalya);

        // add connections
        pushkinsTree.add(sergey);
        pushkinsTree.add(nadezhda);
        pushkinsTree.setConnection(sergey, FamilyConnection.HUSBAND, nadezhda);
        pushkinsTree.addChildren(Arrays.asList(sergey, nadezhda), Arrays.asList(olga, aleksandr, lev));
        pushkinsTree.addWife(aleksandr, natalya);
        // У natalya в goncharovsTree был некий неизвестный потомок.
        // Конструкцию с пустым FamilyMember можно использовать например когда точно не известны часть поколений, а связи построить нужно
        goncharovsTree.addParent(natalya, null);

        /*
        System.out.println(pushkinsTree);
        System.out.println(lanskieTree);
        System.out.println(goncharovsTree);
        System.out.println(pavlishevsTree);
        */

        // find all members, to who $sergey is FamilyConnection.PARENT
        System.out.println(pushkinsTree.findRelatedMembers(sergey, FamilyConnection.PARENT));

        // find all families connected to this family in any way
        System.out.println(pushkinsTree.findConnectedFamilies());
    }
}
