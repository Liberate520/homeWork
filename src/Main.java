import java.util.*;

public class Main {
    public static void main(String[] args) {
        Human dummy = new Human();
        Human bob = new Human("Bob", Gender.MALE,
                new GregorianCalendar(1917, Calendar.JANUARY, 25),
                new GregorianCalendar(2000, Calendar.FEBRUARY, 20),
                dummy, dummy, new HashSet<Human>());
        Human mary = new Human("Mary", Gender.FEMALE,
                new GregorianCalendar(1920,Calendar.JULY, 15),
                new GregorianCalendar(2010, Calendar.JUNE,8),
                dummy, dummy, new HashSet<Human>());
        Human kate = new Human("Kate", Gender.FEMALE,
                new GregorianCalendar(1949, Calendar.DECEMBER, 31),
                new GregorianCalendar(2010, Calendar.JANUARY,1)
                ,bob ,mary , new HashSet<Human>());
        FamilyTree familyTree = new FamilyTree();
        familyTree.adHuman(bob);
        familyTree.adHuman(mary);
        familyTree.adHuman(kate);
        bob.adChild(kate);

        System.out.println("Enter a name to search for : ");
        Scanner scan = new Scanner(System.in);
        System.out.println(familyTree.search(scan.nextLine()));
        System.out.println(familyTree);

        familyTree.inputAndAddChild();
        System.out.println(familyTree);
    }
}
