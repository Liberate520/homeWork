import Tree.*;
//import Tree.Gender;
//import Tree.Human;
import Service.*;
import Service.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/station/Desktop/HomeWork/FamilyTree/familyTree.out";
        FileHandler fileHandler = new FileHandler();
        Object familyTree = dataLoad();
        fileHandler.save((Serializable) familyTree, filePath);

        Service service = new Service();
        service.Scanner();

//        Tree.Family familyTree1 = (Tree.Family) fileHandler.read(filePath);   // чтение familyTree.out
//        System.out.println(familyTree1.getFamilyInfo());            // вывод familyTree1
    }
     static Object[] dataLoad() {
        Human human1 = new Human("Maria", Gender.Female, LocalDate.of(1975, 6, 27), null, null);
        Human human2 = new Human("Ivan", Gender.Male, LocalDate.of(1970, 12, 10), null, null);
        Human human3 = new Human("Stepan", Gender.Male, LocalDate.of(1996, 10, 3), null, null);
        Human human4 = new Human("Katya", Gender.Female, LocalDate.of(1998, 12, 30), null, null);
        Human human5 = new Human("Lena", Gender.Female, LocalDate.of(1998, 3, 12), null, null);
        Human human6 = new Human("Galina", Gender.Female, LocalDate.of(1996, 9, 17), null, null);
        Human human7 = new Human("Dasha", Gender.Female, LocalDate.of(2020, 07, 24), null, null);

        Family family1 = new Family();
        family1.addFamilyMember("Отец", human1);
        family1.addFamilyMember("Мать", human2);
        family1.addFamilyMember("Сын", human3);
        family1.addFamilyMember("Дочь", human4);

        Family family2 = new Family();
        family2.addFamilyMember("Отец", human3);
        family2.addFamilyMember("Мать", human6);
        family2.addFamilyMember("Дочь", human7);


        System.out.println(human5.getName() + " - " + human5.getGender() + ", Age - " + human5.getAge());
        System.out.println(family1.getFamilyInfo());
//        System.out.println(family2.getFamilyInfo());
//        family1.sortByAge();
//        System.out.println(family1.getFamilyInfo());
//        family1.sortByName();
//        System.out.println(family1.getFamilyInfo());

         Object[] Familydata = new Object[2];
         Familydata[0] = family1;
         Familydata[1] = family2;

         return  Familydata;  // сохранение семьи1
     }
}
