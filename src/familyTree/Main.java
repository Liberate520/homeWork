package familyTree;
import familyTree.FamilyTree;
import familyTree.Human;
import familyTree.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String file = "familyTree.out";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = testTree();
        System.out.println(tree);
//        fileHandler.save(tree, file);
    }
    static FamilyTree testTree() {
        FamilyTree familyTree;
        familyTree = new FamilyTree();

        Human ivan = new Human("Иванов", "Иван", Gender.Male, LocalDate.of(1980, 01, 01));
        Human dasha = new Human("Иванова", "Дарья", Gender.Female, LocalDate.of(1980, 01, 02));
        Human sveta = new Human("Петрова", "Светлана", Gender.Female, LocalDate.of(2000, 01, 01), familyTree.getByName("Иван"), familyTree.getByName("Дарья"));
        Human pasha = new Human("Иванов", "Павел", Gender.Male, LocalDate.of(2001, 01, 02), familyTree.getByName("Иван"), familyTree.getByName("Дарья"));
        familyTree.add(ivan);
        familyTree.add(dasha);
        familyTree.add(sveta);
        familyTree.add(pasha);

        return familyTree;
    }
}
