import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree familyTree = new FamilyTree("myFamilyTree");
        Human andrey = new Human("Andrey", "Shevchuk", "Alexandrovich",
                LocalDate.of(1983, Calendar.JULY, 1), null,//, new GregorianCalendar(2100,0,1),
                new Human(), new Human(), Gender.male);

        Human alexandr = new Human("Alexandr", "Shevchuk", "Borisovich",
                LocalDate.of(1959, Calendar.APRIL, 30), null, //, new GregorianCalendar(2100,0,1),
                new Human(), new Human(), Gender.male);
        Human natalia = new Human("Natalia", "Shevchuk", "Alexandrovna",
                LocalDate.of(1961, Calendar.FEBRUARY, 22), null, //, new GregorianCalendar(2100,0,1),
                new Human(), new Human(), Gender.female);
        Human anna = new Human("Anna", "Tihomirova", "Alexandrovna",
                LocalDate.of(1985, Calendar.MAY, 12), null, //, new GregorianCalendar(2100,0,1),
                new Human(), new Human(), Gender.female);
        Human anastasia = new Human("Anastasia", "Shevchuk", "Andreevna",
                LocalDate.of(2013, Calendar.APRIL, 6), null, //, new GregorianCalendar(2100,0,1),
                new Human(), new Human(), Gender.female);
        Human alexandrJ = new Human("Alexandr", "Shevchuk", "Andreevich",
                LocalDate.of(2018, Calendar.FEBRUARY, 4), null, //, new GregorianCalendar(2100,0,1),
                new Human(), new Human(),Gender.male);
        Human olga = new Human("Olga", "Shevchuk", "Alexandrovna",
                LocalDate.of(1987, Calendar.MAY, 20), null, //, new GregorianCalendar(2100,0,1),
                new Human(), new Human(), Gender.female);
        Human alexandrP = new Human("Alexandr", "Popov", "Valerevich");
        Human galina = new Human("Galina", "Popova", "Arkadevna");
        Human boris = new Human("Boris", "Shevchuk", "Filipovich");
        Human alexandra = new Human("Alexandra", "Shevchuk", "Pavlovna");
        Human alexandrM = new Human("Alexandr", "Miheev", "Iosifovich");
        Human alexandraM = new Human("Alexandra", "Miheeva", "Andreevna");
        Human matvey = new Human("Matvey", "Tikhomirov", "Evgenievich",
                LocalDate.of(2014, Calendar.MARCH, 15),null, null, null, Gender.male);
        andrey.setFatherAndMother(alexandr, natalia);
        anna.setFatherAndMother(alexandr, natalia);
        anastasia.setFatherAndMother(andrey, olga);
        alexandrJ.setFatherAndMother(andrey, olga);
        olga.setFatherAndMother(alexandrP, galina);
        alexandr.setFatherAndMother(boris, alexandra);
        natalia.setFatherAndMother(alexandrM, alexandraM);
        // TODO подумать над перегрузкой метода setWedding для передачи только имени, без id
        familyTree.setWedding(alexandr.getId(), natalia.getId());

        anna.addChild(matvey);
        familyTree.setWedding(andrey.getId(), olga.getId());
        andrey.setSpouse(olga);
        olga.setSpouse(andrey);

        familyTree.addHumanAll(andrey, olga, alexandr, alexandrJ, natalia, anna, anastasia);

        familyTree.addHumanAll(andrey, olga);
        //System.out.println(familyTree.getAllChildren(andrey));

        alexandr.setChildren(Arrays.asList(andrey, anna));
        natalia.setChildren(Arrays.asList(andrey, anna));

        File file = new File("familyTree.out");
        FileHandler fileHandler = new FileHandler();

        // сериализация в файл
        //fileHandler.writToFile(familyTree, file);

        System.out.println(familyTree.getSize());

        // сериализация из файла
        System.out.println((fileHandler.readFromFile(file).getSize()));


        familyTree.setWedding(andrey.getId(), olga.getId());
        andrey.setChildren(Arrays.asList(anastasia, alexandrJ));
        alexandr.setChildren(Arrays.asList(andrey, anna));
        natalia.setChildren(Arrays.asList(andrey, anna));

//        System.out.println(familyTree.getAllChildren(andrey));
//        System.out.println(familyTree.getAllChildren(alexandr));
//        System.out.println(familyTree.getAllChildren(natalia));
    }
}
