import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Family_tree family1 = new Family_tree();

        
        Human father = new Human("Sergey", "Zhukov", Gender.male, LocalDate.of(1974, Month.OCTOBER, 11), null, null, null, null,  new ArrayList<>() );
        Human mother = new Human("Natalya", "Zhukova", Gender.female, LocalDate.of(1974, Month.MARCH, 12), null, null, null, null,  new ArrayList<>() );
        Human daughter = new Human("Anastasiya", "Nikolaeva", Gender.female, LocalDate.of(1995, Month.NOVEMBER, 2), null,null, null, null, new ArrayList<>() );
        Human son = new Human("Andrey", "Zhukov", Gender.male, LocalDate.of(2007, Month.JANUARY, 23), null, null, null, null, new ArrayList<>() );


        family1.addHuman(father);
        family1.addHuman(mother);
        family1.addHuman(daughter);
        family1.addHuman(son);

        father.addChildren(son);
        father.addChildren(daughter);

        mother.addChildren(son);
        mother.addChildren(daughter);

        son.addMother(mother);
        son.addFather(father);

        daughter.addMother(mother);
        daughter.addFather(father);

        //Проверка вывода всеx в семье

        family1.showAllHumans();

        //Проверка на вывод поиска по имени или фамилии
//      System.out.println(family1.getHumanByLastName("Ivanov"));
//      System.out.println(family1.getHumanByName("Matvei"));
//

        //Проверка на вывод детей у человека
        mother.getChildren();
      



    }
}