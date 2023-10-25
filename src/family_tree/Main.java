package family_tree;

//import java.io.File;
import java.time.LocalDate;

import family_tree.file_system.FS;
import family_tree.human.Human;
import family_tree.human.types_enum.Gender;
import family_tree.service.Service;

public class Main {
    public static void main(String[] args)
    {
       // FamilyTree familyTree = new FamilyTree();
       Service service = new Service();
        FS fileOperations = new FS();
        String file_path = "tree23.out";
        if(!fileOperations.fileExist(file_path))
        {
            //Human people1 = new Human("Pavel", LocalDate.of(1910, 8, 14), LocalDate.of(1993, 8, 2), null, null, Gender.Male);
           // Human people2 = new Human("Eva", LocalDate.of(1920, 3, 6), LocalDate.of(2006, 7, 1), null, null, Gender.Female);

            // Human people3 = new Human("Katya", LocalDate.of(1943, 2, 7), LocalDate.of(2021, 7, 1), people2, people1, Gender.Female);
            // Human people4 = new Human("Sveta", LocalDate.of(1953, 2, 7), null, people2, people1, Gender.Female);

            // Human people5 = new Human("Tolya", LocalDate.of(1940, 2, 7), LocalDate.of(1995, 7, 1), null, null, Gender.Male);
            // Human people6 = new Human("Dima", LocalDate.of(1948, 2, 7), null, null, null, Gender.Male);

            // Human people7 = new Human("Natasha", LocalDate.of(1977, 2, 7), null, people4, people6, Gender.Female);
            // Human people8 = new Human("Sergey", LocalDate.of(1972, 2, 7), LocalDate.of(1998, 12, 10), people4, people6, Gender.Male);
            // Human people9 = new Human("Dima", LocalDate.of(1975, 2, 7), null, null, null, Gender.Male);

            // Human people10 = new Human("Valya", LocalDate.of(2000, 9, 7), null, people7, people9, Gender.Female);
            // Human people11 = new Human("Lesha", LocalDate.of(1996, 2, 7), null, people7, people9, Gender.Male);

            // familyTree.addHuman(people1);
            // familyTree.addHuman(people1);
            // familyTree.addHuman(people2);
            // familyTree.addHuman(people3);
            // familyTree.addHuman(people4);
            // familyTree.addHuman(people5);
            // familyTree.addHuman(people6);
            // familyTree.addHuman(people7);
            // familyTree.addHuman(people8);
            // familyTree.addHuman(people9);
            // familyTree.addHuman(people10);
            // familyTree.addHuman(people11);
            
            Human people1 = service.addHuman("Pavel", LocalDate.of(1910, 8, 14), LocalDate.of(1993, 8, 2), null, null, Gender.Male);
            Human people2 = service.addHuman("Eva", LocalDate.of(1920, 3, 6), LocalDate.of(2006, 7, 1), null, null, Gender.Female);

            Human people3 = service.addHuman("Katya", LocalDate.of(1943, 2, 7), LocalDate.of(2021, 7, 1), people2, people1, Gender.Female);
            Human people4 = service.addHuman("Sveta", LocalDate.of(1953, 2, 7), null, people2, people1, Gender.Female);

            Human people5 = service.addHuman("Tolya", LocalDate.of(1940, 2, 7), LocalDate.of(1995, 7, 1), null, null, Gender.Male);
            Human people6 = service.addHuman("Dima", LocalDate.of(1948, 2, 7), null, null, null, Gender.Male);

            Human people7 = service.addHuman("Natasha", LocalDate.of(1977, 2, 7), null, people4, people6, Gender.Female);
            Human people8 = service.addHuman("Sergey", LocalDate.of(1972, 2, 7), LocalDate.of(1998, 12, 10), people4, people6, Gender.Male);
            Human people9 = service.addHuman("Dima", LocalDate.of(1975, 2, 7), null, null, null, Gender.Male);

            Human people10 =service.addHuman("Valya", LocalDate.of(2000, 9, 7), null, people7, people9, Gender.Female);
            Human people11 =service.addHuman("Lesha", LocalDate.of(1996, 2, 7), null, people7, people9, Gender.Male);
            
            System.out.println(service.getFamilyTreeHumansListInfo());
            service.sortByName();
            System.out.println(service.getFamilyTreeHumansListInfo());
            service.sortByAge();
            System.out.println(service.getFamilyTreeHumansListInfo());
            // service.getFamilyTreeHumansListInfo();
            fileOperations.save(service, file_path);
        }
        else
        {
            service = (Service)fileOperations.read(file_path);
            System.out.println(service.getFamilyTreeHumansListInfo());
            service.sortByName();
            System.out.println(service.getFamilyTreeHumansListInfo());
            service.sortByAge();
            System.out.println(service.getFamilyTreeHumansListInfo());
        }
    }
}
