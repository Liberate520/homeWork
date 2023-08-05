import java.io.*;
import java.time.LocalDate;

public class Main  {

    public static void main(String[] args) {
        String filePath = "src/person.out";
        FileHandler fileHandler = new FileHandler();


       //FamilyTree family = testFamily();
       //System.out.println(family.getFamilyList());

       //fileHandler.save(family, filePath);

        FamilyTree family = (FamilyTree) fileHandler.read(filePath);
       System.out.println(family.getFamilyList());

    }
        static  FamilyTree testFamily() {
            // создал экземпляр FamilyTree
            FamilyTree family = new FamilyTree();

            //создал семью
            Human Igor = new Human("Igor", Gender.Мужской, null, null, "Irina", LocalDate.of(1977, 4, 6), null);
            Human Olga = new Human("Olga", Gender.Женский, null, null, "Irina", LocalDate.of(1978, 4, 6), null);
            Human Irina = new Human("Irina", Gender.Женский, Igor, Olga, null, LocalDate.of(1999, 4, 6), null);

            // добавил семью в семейное древо
            family.familyAdd(Igor);
            family.familyAdd(Olga);
            family.familyAdd(Irina);

            family.familyInfo();


            return family;
        }





}