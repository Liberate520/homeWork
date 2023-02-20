import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        fillTree(tree);
        tree.printTree();
        System.out.println("\n====================TEST SortByName====================\n");
        tree.sortByName();
        tree.printTree();
        System.out.println("\n====================TEST SortByAge====================\n");
        tree.sortByAge();
        tree.printTree();
    }
    
    public static void fillTree(FamilyTree tree) {
        tree.addPerson(new Person("Frederick", "Harrington", Sex.MALE, LocalDate.of(1993, 10, 18)));
        tree.addPerson(new Person("Bruce", "Baker", Sex.MALE, LocalDate.of(1976, 1, 29)));
        tree.addPerson(new Person("Wilson", "Rogers", Sex.MALE, LocalDate.of(2006, 8, 01)));
        tree.addPerson(new Person("Judith", "Brady", Sex.FEMALE, LocalDate.of(1983, 11, 13)));
        tree.addPerson(new Person("Michelle", "Powell", Sex.FEMALE, LocalDate.of(1989, 8, 29)));
        tree.addPerson(new Person("Hannah", "Nichols", Sex.FEMALE, LocalDate.of(1969, 5, 24)));
        tree.addPerson(new Person("Bethany", "Harris", Sex.FEMALE, LocalDate.of(1950, 8, 07)));
        tree.addPerson(new Person("Edith", "Lyons", Sex.FEMALE, LocalDate.of(2003, 4, 15)));
        tree.addPerson(new Person("Dianne", "Brooks", Sex.FEMALE, LocalDate.of(1963, 3, 05)));
        tree.addPerson(new Person("Ron", "Riley", Sex.MALE, LocalDate.of(1980, 9, 05)));
        tree.addPerson(new Person("Trevor", "Drake", Sex.MALE, LocalDate.of(1951, 1, 12)));
        tree.addPerson(new Person("Dean", "Copeland", Sex.MALE, LocalDate.of(1977, 6, 28)));
    }
}
