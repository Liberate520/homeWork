import java.io.*;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {

//        WorkingWithFiles workingWithFiles = new FileHandler();

        Service service = new Service();
        service.addHuman("Дмитрий", "Бохан", Gender.Male, "12.11.1990");
        service.addHuman("Ирина", "Бохан", Gender.Female, "31.10.1965");
        service.addHuman("Анна", "Новикова", Gender.Female, "23.10.1988");
        service.addHuman("Павлина", "Мищенко", Gender.Female, "13.03.1934");

        //System.out.println(service.searchByName("Павлина"));
        //System.out.println(service.searchByID(2));
        service.searchByName("Ирина").setMother(service.searchByName("Павлина"));

        //service.searchByName("Павлина").setDateOfDeath("06.04.2008");

//        workingWithFiles.save(familyTree);
//
//        FamilyTree tree = workingWithFiles.write();
//
//        tree.listOfNames();
         //System.out.println(service.getInfo());

        // service.PrintBirthdaySort();
         service.PrintFirstNameSort();


    }
}
