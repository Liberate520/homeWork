package Main;

import java.time.LocalDate;
import FamilyTree.FamilyTree;
import FileHandler.FileHandler;
import Human.Human;
import Human.Sex;

public class Main {
    public static long id = 0;
    public static FamilyTree familyTree;
    public static void main(String[] args) {
        // FileHandler f = new FileHandler("test.txt");
        // familyTree = (FamilyTree) f.readFromFile();
        boolean testing = true;
        if (testing) initializeTestData();
        else familyTree = new FamilyTree();
        System.out.println(familyTree.getSiblings(1));
        FileHandler f1 = new FileHandler("test.txt");
        f1.writeToFile(familyTree);
    }
    
    private static long getId() {
        return ++id;
    }

    private static void initializeTestData() {
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
        p2.addChild(p1);
        p2.addChild(p5);
        p3.addChild(p1);
        p3.addChild(p5);
        p4.addChild(p3);

        familyTree.addPerson(p1);
        familyTree.addPerson(p2);
        familyTree.addPerson(p3);
        familyTree.addPerson(p4);
        familyTree.addPerson(p5);
    }
}