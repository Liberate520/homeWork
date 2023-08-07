import model.Service.FileHandler;
import view.ConsoleUI;

public class Main {
    static String filePath = "familytree.out";
    public static void main(String[] args)  {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
//        GenealogicalTree family1 = new GenealogicalTree<>();
//
//        Human grandmother1 = new Human("Valentina", "Nazarova", Gender.female, LocalDate.of(1938, Month.JANUARY, 4),LocalDate.of(2020, Month.MARCH, 1),null, null, null, new ArrayList<>() );
//        Human grandfather1 = new Human("Eduard", "Nazarov", Gender.male, LocalDate.of(1937, Month.MAY, 20),LocalDate.of(1999, Month.AUGUST, 14),null, null, null,  new ArrayList<>()  );
//        Human grandmother2 = new Human("Zhanna", "Ivanova", Gender.female, LocalDate.of(1942, Month.DECEMBER, 14),null, null, null, null,  new ArrayList<>() );
//        Human grandfather2 = new Human("Sergei", "Ivanov", Gender.male, LocalDate.of(1930, Month.MAY, 10), LocalDate.of(2012, Month.APRIL, 11), null, null, null,  new ArrayList<>() );
//        Human father = new Human("Mickail", "Ivanov", Gender.male, LocalDate.of(1966, Month.JUNE, 12), null, null, null, null,  new ArrayList<>() );
//        Human mother = new Human("Victoria", "Ivanova", Gender.female, LocalDate.of(1972, Month.FEBRUARY, 13), null, null, null, null,  new ArrayList<>() );
//        Human daughter = new Human("Marina", "Ivanova", Gender.female, LocalDate.of(1993, Month.NOVEMBER, 13), null,null, null, null, new ArrayList<>() );
//        Human son = new Human("Matvei", "Ivanov", Gender.male, LocalDate.of(2000, Month.SEPTEMBER, 23), null, null, null, null, new ArrayList<>() );
//
//        family1.addHuman(grandmother1);
//        family1.addHuman(grandmother2);
//        family1.addHuman(grandfather1);
//        family1.addHuman(grandfather2);
//
//        family1.addHuman(father);
//        family1.addHuman(mother);
//        family1.addHuman(daughter);
//        family1.addHuman(son);
//
//
//        grandmother1.addSpouse(grandfather1);
//        grandfather1.addSpouse(grandmother1);
//
//        grandmother2.addChildren(father);
//        grandmother2.addSpouse(grandfather2);
//        grandfather2.addSpouse(grandmother2);
//        grandfather2.addChildren(father);
//
//
//        father.addFather(grandfather2);
//        father.addMother(grandmother2);
//        father.addSpouse(mother);
//        father.addChildren(son);
//        father.addChildren(daughter);
//
//        mother.addSpouse(father);
//        mother.addChildren(son);
//        mother.addChildren(daughter);
//
//        son.addMother(mother);
//        son.addFather(father);
//
//        daughter.addMother(mother);
//        daughter.addFather(father);
//
//        //Проверка вывода всеx в семье
//
////      family1.showAllHumans();
//
//        //Проверка на вывод поиска по имени или фамилии
////      System.out.println(family1.getHumanByLastName("Ivanov"));
////      System.out.println(family1.getHumanByName("Matvei"));
////
//
//        //Проверка на вывод детей у человека
////      mother.getChildren();
////      grandmother2.getChildren();
//
//        FileHandler fh = new FileHandler();
//        fh.saveFile(grandfather1);
//        fh.saveFile(son);
//        fh.saveFile(family1);
//
////        System.out.println(fh.readFile(filePath));
//
////        System.out.println(family1.getInfo());
//
//        //Iterator
////        for (Human module.module.human.human: family1
////             ) {
////            System.out.println(module.module.human.human);
////        }
//        System.out.println(family1.getInfo());
//        System.out.println("------------------");
//        family1.sortByAge();
//        System.out.println(family1.getInfo());
//        family1.sortByName();
//        System.out.println("------------------");
//        System.out.println(family1.getInfo());

    }
}
