import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    Human person0 = new Human("Nikolay", "Kalugin", LocalDate.of(1938,03,01), null, Gender.MALE);
    Human person1 = new Human("Nikolay", "Kalugin", LocalDate.of(1938,03,01), null, Gender.MALE);
    Human person2 = new Human("Nikolay", "Kalugin", LocalDate.of(1938,03,01), null, Gender.MALE);
    Human person3 = new Human("Nikolay", "Kalugin", LocalDate.of(1938,03,01), null, Gender.MALE);

    FamilyTree familyTree = new FamilyTree();
    familyTree.addHuman(person0);
    familyTree.addHuman(person1);
    familyTree.addHuman(person2);
    familyTree.addHuman(person3);
    Human findHuman = familyTree.findHumanByName("Nikolay");
        System.out.println(familyTree.getHumanList());
        System.out.println("-----------------------");
        System.out.println(person0.getAge());
    }
}
