import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        familyTree.addHuman(new Human("Yuriy", LocalDate.of(1991, 03, 05), Gender.male));
        familyTree.addHuman(new Human("Evgeniy", LocalDate.of(1987, 07, 23), Gender.male));
        familyTree.addHuman(new Human("Mikhail", LocalDate.of(1960, 12, 15), Gender.male));
        familyTree.addHuman(new Human("Natalya", LocalDate.of(1959, 04, 20), Gender.female));


        familyTree.findByName("natalya").setChildren(familyTree.findByName("yuriy"));
        familyTree.findByName("natalya").setChildren(familyTree.findByName("evgeniy"));
        familyTree.findByName("Mikhail").setChildren(familyTree.findByName("yuriy"));
        familyTree.findByName("Mikhail").setChildren(familyTree.findByName("evgeniy"));

        System.out.println(familyTree.findByName("yuriy").humanInfo());
        System.out.println(familyTree.findByName("Mikhail").humanInfo());
    }
}
