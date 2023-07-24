import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
       
      FamilyTree familyTree = new FamilyTree(123);
      
      Human human=new Human("Алексей",Gender.male,LocalDate.of(1979, 05, 22));
      Human human1=new Human("Сергей", Gender.male,LocalDate.of(2023, 06, 04));
      Human human2=new Human("Антон",Gender.male, LocalDate.of(2023, 06, 04));

      Human human3=new Human("Фаина",Gender.female, LocalDate.of(1949, 01, 13));
      Human human4=new Human("Валерий",Gender.female, LocalDate.of(1947, 01, 13),
                              LocalDate.of(2000, 11, 14));

      familyTree.addHuman(human);
      familyTree.addHuman(human1);
      familyTree.addHuman(human2);
      familyTree.addHuman(human3);
      familyTree.addHuman(human4);
      //System.out.println(familyTree.getHumansInfo());

      
      human.addKinship(human1,Kinship.child);
      human.addKinship(human2,Kinship.child);
      human.addKinship(human3, Kinship.parent);
      human.addKinship(human4, Kinship.parent);
      
      //System.out.println(human.getKinshipInfo(Kinship.child));
      //System.out.println(human.getKinshipInfo(Kinship.parent));
      
      FileHandler fileHandler=new FileHandler();
      

      try {
         fileHandler.save(human.getKinshipInfo(Kinship.child));
         fileHandler.save(human.getKinshipInfo(Kinship.parent));
         fileHandler.save(familyTree.getHumansInfo());
         
      } 
      catch (Exception e) {
         System.out.println("Что-то пошло не так!");
      }
      //FileHandler fileHandler2=new FileHandler();
      System.out.println(fileHandler.load());

   }

}
