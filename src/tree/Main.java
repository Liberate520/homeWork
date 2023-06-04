package tree;

import java.io.IOException;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree familyTree = new FamilyTree();

        familyTree.add(new Human("Eryomin", "Mark", "Aleksandrovich", Gender.Male, LocalDate.of(1987, 4, 18)));
        familyTree.add(new Human("Eryomina", "Eugeniya", "Anatolievna", Gender.Female, LocalDate.of(1988, 12, 15)));
        familyTree.add(new Human("Eryomina", "Yaroslava", "Markovna", Gender.Female, familyTree.findHumanByName("Mark"), familyTree.findHumanByName("Eugeniya")));
        familyTree.add(new Human("Eryomina", "Aleksandra", "Markovna", Gender.Female, familyTree.findHumanByName("Mark"), familyTree.findHumanByFIO("Eryomina", "Eugeniya", "Anatolievna")));
        System.out.println(familyTree.getInfoTree());
        System.out.println();
        System.out.println(familyTree.findHumanByName("mark").getInfoHuman());
        System.out.println();
        System.out.println(familyTree.findHumanByName("eugeniya").getInfoHuman());
        System.out.println(familyTree.findHumanByName("Aleksandra").getInfoName());
        System.out.println(familyTree.findHumanByName("Yaroslava").getFatherInfo());
        new FileHandler().save("FamilyTree.bin", familyTree);
        new FileHandler().load("FamilyTree.bin", familyTree);

    }
}