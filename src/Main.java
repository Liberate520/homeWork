import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human son = new Human("Nikita", Gender.Male,LocalDate.of(2001, 5, 11));
        Human mother = new Human("Anna", Gender.Female, LocalDate.of(1978, 12, 7));
        Human father = new Human("Alexander", Gender.Male, LocalDate.of(1978, 1, 1));
        Human daughter = new Human("Kristina", Gender.Female, LocalDate.of(2003, 6, 15));
        son.addParent(father);
        son.addParent(mother);
        daughter.addParent(father);
        daughter.addParent(mother);
        FamilyTree familyTree = new FamilyTree();
        familyTree.setWedding(father, mother);
        familyTree.addFamilyMember(son);
        familyTree.addFamilyMember(mother);
        familyTree.addFamilyMember(father);
        familyTree.addFamilyMember(daughter);
        System.out.println(familyTree);
    }
}