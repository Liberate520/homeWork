import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Human kolya = new Human("Kolya", "Black", Gender.Male, 31, 3, 1998);
//        kik.setRelationship(Relationship.Brothers,kik,kik,kik);

        Human marina = new Human("Marina", "Black", Gender.Female, 1, 6, 1977);
        Human uriy = new Human("Uriy", "Black", Gender.Male, 5, 12, 1969);
        Human john = new Human("John", "Black", Gender.Male, 8, 6, 1998);
        Human sveta = new Human("Sveta", "White", Gender.Female, 15, 2, 1980);
        Human hugh = new Human("Hugh", "Donovan", Gender.Male, 9, 6, 2000);
        Human kit = new Human("Kit", "Habsburg", Gender.Male, 1, 10, 2002);

        kolya.setRelationship(Relationship.Mother, marina);
        kolya.setRelationship(Relationship.Father, uriy);
        kolya.setRelationship(Relationship.Brothers, john);
        kolya.setRelationship(Relationship.Aunts, sveta);
        kolya.setRelationship(Relationship.Brothers, hugh);
        kolya.setRelationship(Relationship.Brothers, kit);
        System.out.println(kolya.isAnOrhan());
        kolya.getAge();
        FamilyTree kolya_tree = new FamilyTree(kolya);
        kolya_tree.getRelatives();


    }
}
