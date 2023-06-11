import model.dog.Dog;
import model.human.*;
import model.family.*;
import model.familyRecords.*;
import model.member.Gender;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //Create main record object
        FamilyRecords<Human> humanRecords = new FamilyRecords<>();

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


        // create model.family trees
        humanRecords.addFamily("Пушкины");
        humanRecords.addFamily("Гончаровы", natalya);
        humanRecords.addFamily("Павлищевы", olga);
        humanRecords.addFamily("Ланские", humanRecords.searchHumanByName("Ланская Наталья Николаевна"));

        // get some model.family objects
        Family<Human> pushkins = humanRecords.searchFamilyByName("Пушкины");

        // add connections
        humanRecords.addToFamily(sergey, pushkins);
        humanRecords.addWife(pushkins, sergey, nadezhda);
        humanRecords.addChildren(pushkins, Arrays.asList(sergey, nadezhda), Arrays.asList(olga, aleksandr, lev));
        humanRecords.addWife(pushkins, aleksandr, natalya);


        /*
        System.out.println(pushkins);
        System.out.println(lanskieTree);
        System.out.println(goncharovsTree);
        System.out.println(pavlishevsTree);


        // find all members, to who $sergey is FamilyConnection.PARENT
        System.out.println(humanRecords.findRelatedMembers(sergey, Connection.PARENT));

        // find all families connected to this model.family in any way
        System.out.println(humanRecords.findConnectedFamilies(pushkins));

        System.out.println("-".repeat(10));

        // export data
        Converter<Human> binaryConverter = new BinaryConverter<>();
        Converter<Human> csvConverter = new CSVConverter();
        Converter<Human> binaryConverterErrorPath = new BinaryConverter<>(String.join(File.separator, Arrays.asList("bla", "bla")));
        humanRecords.save(binaryConverter);
        System.out.printf("Результат выгрузки %s\n", binaryConverter.convertStatus());
        humanRecords.save(binaryConverterErrorPath);
        System.out.printf("Результат выгрузки %s\n", binaryConverterErrorPath.convertStatus());
        humanRecords.save(csvConverter);
        System.out.printf("Результат выгрузки в csv %s\n", csvConverter.convertStatus());

        System.out.println("-".repeat(10));

        // import data
        FamilyRecords<Human> loadedRecords = FamilyRecords.load(binaryConverterErrorPath);
        System.out.printf("Результат загрузки %s\n", binaryConverterErrorPath.convertStatus());
        loadedRecords = FamilyRecords.load(binaryConverter);
        System.out.printf("Результат загрузки %s\n", binaryConverter.convertStatus());
        loadedRecords = FamilyRecords.load(csvConverter);
        System.out.printf("Результат загрузки из csv %s\n", csvConverter.convertStatus());


        System.out.printf(humanRecords.getFamiliesString()); // print families as is
        System.out.println("-".repeat(10));
        humanRecords.sort(); // sort families by names
        System.out.printf(humanRecords.getFamiliesString());
        System.out.println("-".repeat(10));

        System.out.printf(pushkins.getFamiliesString()); // print humans in model.family as is
        pushkins.sort(); // sort by name
        System.out.println("-".repeat(10));
        System.out.printf(pushkins.getFamiliesString());
        pushkins.sortByBirthDate(); // sort by birthdate
        System.out.println("-".repeat(10));
        System.out.printf(pushkins.getFamiliesString());
         */
        FamilyRecords<Dog> dogRecords = new FamilyRecords<>();

        Dog layka = new Dog("Лайка", Gender.FEMALE,
                new GregorianCalendar(1954, Calendar.JANUARY, 12),
                new GregorianCalendar(1957, Calendar.NOVEMBER, 3));
        Dog sharik = new Dog("Шарик", Gender.MALE,
                new GregorianCalendar(1955, Calendar.JUNE, 21),
                new GregorianCalendar(1958, Calendar.MARCH, 29));

        dogRecords.addFamily("Хорошие мальчики", sharik);
        dogRecords.addToFamily(layka, dogRecords.searchFamilyByName("Хорошие мальчики"));
        dogRecords.addWife(dogRecords.searchFamilyByName("Хорошие мальчики"), sharik, layka);

        System.out.printf(dogRecords.searchFamilyByName("Хорошие мальчики").getFamiliesString());
    }
}
