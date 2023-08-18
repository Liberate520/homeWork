import java.io.*;
import java.time.LocalDate;

public class Main  {

    public static void main(String[] args) {

        Service service = new Service();
        Human Andrey = new Human("C - Andrey");
        Human Olga = new Human("B - Olga");
        Human Viktoria = new Human("A - Viktoria");


        service.addFamily("C - Andrey", Gender.Male, null, null, Viktoria, LocalDate.of(1977, 4, 6), null);

        service.addFamily("B - Olga", Gender.Female, null, null, Viktoria, LocalDate.of(1978, 4, 6), null);

        service.addFamily("A - Viktoria", Gender.Female, Andrey, Olga, null, LocalDate.of(1999, 4, 6), null);


        System.out.println(service.getInfo());

        service.sortByName();
        System.out.println(service.getInfo());

        service.sortByAge();
        System.out.println(service.getInfo());



/*



        String filePath = "src/person.out";
        FileHandler fileHandler = new FileHandler();

       FamilyTree family = testFamily();
       //System.out.println(family.getFamilyList());

       //fileHandler.save(family, filePath);
       // FamilyTree family = (FamilyTree) fileHandler.read(filePath);
       //System.out.println(family.getFamilyList());

    }
        static  FamilyTree testFamily() {
            // создал экземпляр FamilyTree
            FamilyTree family = new FamilyTree();

            //создал семью
            Human Igor = new Human("Igor", Gender.Male, null, null, "Irina", LocalDate.of(1977, 4, 6), null);
            Human Olga = new Human("Olga", Gender.Female, null, null, "Irina", LocalDate.of(1978, 4, 6), null);
            Human Irina = new Human("Irina", Gender.Female, Igor, Olga, null, LocalDate.of(1999, 4, 6), null);

            // добавил семью в семейное древо

            family.familyAdd(Igor);
            family.familyAdd(Olga);
            family.familyAdd(Irina);

            family.familyInfo();




            return family;
             */
        }





}