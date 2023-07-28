import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import Enum.Gender;
import Enum.Kinship;

import Servis.Service;


public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
      Service service=new Service();
      service.addHuman("Алексей",Gender.male,LocalDate.of(1979, 5, 22), null, null, null);
      service.addHuman("Фаина",Gender.female,LocalDate.of(1949,1,13), null, null, null);
      service.addHuman("Ольга", Gender.female,LocalDate.of(1980, 9, 28), null, null, null);
      service.addHuman("Антон", Gender.male , LocalDate.of(2001, 12, 11), null, null, null);
      //System.out.println(service.getInfo());
      
      service.addKinship(0,Kinship.child,1);
      service.addKinship(1,Kinship.parent,0);
      service.addKinship(3,Kinship.child,0);
      service.addKinship(0,Kinship.parent,3);
      service.addKinship(2,Kinship.parent,3);
      service.addKinship(3,Kinship.child,2);

      System.out.println(service.getInfo());

      service.sortByAge();
      System.out.println(service.getInfo());
      service.sortByName();
      System.out.println(service.getInfo());
      service.sortById();
      System.out.println(service.getInfo());

      // service.save();
      // System.out.println(service.load());
      // Human Alexey = new Human("Алексей",Gender.male,LocalDate.of(1979, 5, 22));
      
      // Human Faina=new Human ("Фаина",Gender.female,LocalDate.of(1949,1,13));
      

      
      
   }

}
