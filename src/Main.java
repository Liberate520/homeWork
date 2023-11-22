import java.time.LocalDate;

public class Main {
    public static long id = 0;
    public static FamilyTree familyTree;
    public static void main(String[] args) {
        boolean testing = true;
        if (testing) initializeTestData();
        else familyTree = new FamilyTree();
        System.out.println(familyTree.getSiblings(1));
    }
    
    private static long getId() {
        return ++id;
    }

    public static void initializeTestData() {
        familyTree = new FamilyTree();
        LocalDate p1Date = LocalDate.of(1997, 3, 2);
        LocalDate p2Date = LocalDate.of(1986, 5, 12);
        LocalDate p3Date = LocalDate.of(1976, 6, 22);
        LocalDate p4BDate = LocalDate.of(1956, 4, 20);
        LocalDate p4DDate = LocalDate.of(2000, 12, 20);
        LocalDate p5Date = LocalDate.of(2012, 4, 3);
        Human p1 = new Human(getId(), "Ya", "Kek", p1Date, Sex.Male);
        Human p2 = new Human(getId(), "Papa", "Kek", p2Date, Sex.Male);
        Human p3 = new Human(getId(), "Mama", "Kek", p3Date, Sex.Female);
        Human p4 = new Human(getId(), "Grandma", "kek", p4BDate, Sex.Female, p4DDate);
        Human p5 = new Human(getId(), "Brat", "Kek", p5Date, Sex.Male);
        

        familyTree.addPerson(p1);
        familyTree.addPerson(p2);
        familyTree.addPerson(p3);
        familyTree.addPerson(p4);
        familyTree.addPerson(p5);
        familyTree.addParent(2, 1);
        familyTree.addParent(3, 1);
        familyTree.addParent(2, 5);
        familyTree.addParent(3, 5);
        familyTree.addToParents(1);
        familyTree.addToParents(5);
        familyTree.addParent(4, 3);
        familyTree.addToParents(3);
    }
}