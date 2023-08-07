import Model.*;
import java.time.LocalDate;

public class TestData {
    static Family dataLoad() {
        Human human1 = new Human("Maria", Gender.Female, LocalDate.of(1975, 6, 27), null, null);
        Human human2 = new Human("Ivan", Gender.Male, LocalDate.of(1970, 12, 10), null, null);
        Human human3 = new Human("Stepan", Gender.Male, LocalDate.of(1996, 10, 3), null, null);
        Human human4 = new Human("Katya", Gender.Female, LocalDate.of(1998, 12, 30), null, null);
        Human human5 = new Human("Lena", Gender.Female, LocalDate.of(1998, 3, 12), null, null);
        Human human6 = new Human("Galina", Gender.Female, LocalDate.of(1996, 9, 17), null, null);
        Human human7 = new Human("Dasha", Gender.Female, LocalDate.of(2020, 07, 24), null, null);

//        Family<Human> family = new Family<Human>();
//        family.addFamilyMember(human1);
//        family.addFamilyMember(human2);
//        family.addFamilyMember(human3);
//        family.addFamilyMember( human4);

//        System.out.println(family.getFamilyInfo());
//        System.out.println(family2.getFamilyInfo());
//        family1.sortByAge();
//        System.out.println(family1.getFamilyInfo());
//        family1.sortByName();
//        System.out.println(family1.getFamilyInfo());

        return null;  // сохранение семьи1
    }
}

