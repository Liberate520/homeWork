import convertible.BinaryConverter;
import convertible.CSVConverter;
import convertible.Convertible;
import familyRecords.*;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //Create main record object
        FamilyRecords records = new FamilyRecords();

        // Create some humans
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

        // add some Humans to record object
        records.addHuman(sergey);
        records.addHumans(Arrays.asList(nadezhda, olga, aleksandr, lev));

        // create family trees
        records.addFamily("Пушкины");
        records.addFamily("Гончаровы", natalya);
        records.addFamily("Павлищевы", records.searchHumanByName("Павлищева Ольга Сергеевна"));
        records.addFamily("Ланские", natalya);

        // get some family objects
        Family pushkins = records.searchFamilyBeName("Пушкины");

        // add connections
        records.addHumanToFamily(sergey, pushkins);
        records.addWife(pushkins, sergey, nadezhda);
        records.addChildren(pushkins, Arrays.asList(sergey, nadezhda), Arrays.asList(olga, aleksandr, lev));
        records.addWife(pushkins, aleksandr, natalya);


        /*
        System.out.println(pushkins);
        System.out.println(lanskieTree);
        System.out.println(goncharovsTree);
        System.out.println(pavlishevsTree);


        // find all members, to who $sergey is FamilyConnection.PARENT
        System.out.println(records.findRelatedMembers(sergey, FamilyConnection.PARENT));

        // find all families connected to this family in any way
        System.out.println(records.findConnectedFamilies(pushkins));

        System.out.println("-".repeat(10));
        */

        // export data
        Convertible binaryConverter = new BinaryConverter();
        Convertible csvConverter = new CSVConverter();
        Convertible binaryConverterErrorPath = new BinaryConverter(String.join(File.separator, Arrays.asList("bla", "bla")));
        records.save(binaryConverter);
        System.out.printf("Результат выгрузки %s\n", binaryConverter.convertStatus());
        records.save(binaryConverterErrorPath);
        System.out.printf("Результат выгрузки %s\n", binaryConverterErrorPath.convertStatus());
        records.save(csvConverter);
        System.out.printf("Результат выгрузки в csv %s\n", csvConverter.convertStatus());

        System.out.println("-".repeat(10));

        // import data
        FamilyRecords loadedRecords = FamilyRecords.load(binaryConverterErrorPath);
        System.out.printf("Результат загрузки %s\n", binaryConverterErrorPath.convertStatus());
        loadedRecords = FamilyRecords.load(binaryConverter);
        System.out.printf("Результат загрузки %s\n", binaryConverter.convertStatus());
        loadedRecords = FamilyRecords.load(csvConverter);
        System.out.printf("Результат загрузки из csv %s\n", csvConverter.convertStatus());
    }
}
