package family_tree;

import java.time.LocalDate;
import java.util.PrimitiveIterator.OfDouble;

public class Main {
    public static void main(String[] args) 
    {
        FamilyTree familyTree = new FamilyTree();
        
        Human people1 = new Human("Pavel", LocalDate.of(1910, 8, 14), LocalDate.of(1993, 8, 2), null, null, Gender.Male);
        Human people2 = new Human("Eva", LocalDate.of(1920, 3, 6), LocalDate.of(2006, 7, 1), null, null, Gender.Female);

        Human people3 = new Human("Katya", LocalDate.of(1943, 2, 7), LocalDate.of(2021, 7, 1), people2, people1, Gender.Female);
        Human people4 = new Human("Sveta", LocalDate.of(1953, 2, 7), null, people2, people1, Gender.Female);

        Human people5 = new Human("Tolya", LocalDate.of(1940, 2, 7), LocalDate.of(1995, 7, 1), null, null, Gender.Male);
        Human people6 = new Human("Dima", LocalDate.of(1948, 2, 7), null, null, null, Gender.Male);

        Human people7 = new Human("Natasha", LocalDate.of(1977, 2, 7), null, people4, people6, Gender.Female);
        Human people8 = new Human("Sergey", LocalDate.of(1972, 2, 7), LocalDate.of(1998, 12, 10), people4, people6, Gender.Male);
        Human people9 = new Human("Dima", LocalDate.of(1975, 2, 7), null, null, null, Gender.Male);

        Human people10 = new Human("Valya", LocalDate.of(2000, 9, 7), null, people7, people9, Gender.Female);
        Human people11 = new Human("Lesha", LocalDate.of(1996, 2, 7), null, people7, people9, Gender.Male);

        familyTree.addHuman(people1);
        familyTree.addHuman(people2);
        familyTree.addHuman(people3);
        familyTree.addHuman(people4);
        familyTree.addHuman(people5);
        familyTree.addHuman(people6);
        familyTree.addHuman(people7);
        familyTree.addHuman(people8);
        familyTree.addHuman(people9);
        familyTree.addHuman(people10);
        familyTree.addHuman(people11);

        System.out.println(familyTree.getHumansListInfo());

        people1.addChild(people3);
        people1.addChild(people4);

        people2.addChild(people3);
        people2.addChild(people4);
        
        people4.addChild(people7);
        people4.addChild(people8);
        people6.addChild(people8);
        people6.addChild(people7);

        people7.addChild(people10);
        people7.addChild(people11);

        people9.addChild(people10);
        people9.addChild(people11);

        System.out.println(familyTree.getPeopleByName("Dima").getChildrensListInfo());
        
    //    System.out.println(people3.getMother().getName());
    //    System.out.println(familyTree.getHumansListInfo());
    //    System.out.println(people2.getChildrensListInfo());
        // System.out.println(people3);
        // System.out.println(people4);


    }
}
