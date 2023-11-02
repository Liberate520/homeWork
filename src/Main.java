import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
    Human valery = new Human("Валерий",Gender.Male, LocalDate.of(1952,6,6));
    Human nadejda = new Human("Надежда", Gender.Female,LocalDate.of(1952,2,8));
    Human ludmila = new Human("Людмила", Gender.Female,LocalDate.of(1973,5,17),nadejda,valery);
    Human natali = new Human("Наталия", Gender.Female,LocalDate.of(1977,3,30),nadejda,valery);
    Human evgenyi= new Human("Евгений", Gender.Male,LocalDate.of(1993,8,16));

    evgenyi.addParent(ludmila);

    familyTree.addFamilyTree(valery);
    familyTree.addFamilyTree(nadejda);
    familyTree.addFamilyTree(ludmila);
    familyTree.addFamilyTree(natali);
    familyTree.addFamilyTree(evgenyi);

    System.out.println(familyTree.familyTreeInfo());


    }
}