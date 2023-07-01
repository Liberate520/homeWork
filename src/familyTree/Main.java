package familyTree;
import familyTree.FamilyTree;
import familyTree.Human;
import familyTree.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree;
        familyTree = new FamilyTree();

        familyTree.add(new Human("Иванов", "Иван", Gender.Male, LocalDate.of(1980, 01, 01)));
        familyTree.add(new Human("Иванова", "Дарья", Gender.Female, LocalDate.of(1980, 01, 02)));
        familyTree.add(new Human("Петрова", "Светлана", Gender.Female, LocalDate.of(2000, 01, 01), familyTree.getByName("Иван"), familyTree.getByName("Дарья")));
        familyTree.add(new Human("Иванов", "Вячеслав", Gender.Male, LocalDate.of(2001, 01, 02), familyTree.getByName("Иван"), familyTree.getByName("Дарья")));

        System.out.println(familyTree.getInfo());
    }
}
