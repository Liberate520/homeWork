import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GenealogyApp {
    public static void main(String[] args) {

        Person person1 = new Person(1,"John","Smith",Gender.MALE,LocalDate.of(1971,8,8),null);
        Person person2 = new Person(2,"Alise","Smith",Gender.FEMALE,LocalDate.of(1974,3,5),null);
        Person person3 = new Person(3,"Ann","Smith",Gender.FEMALE,LocalDate.of(1998,9,11),null);

        person1.addRelationship(person3,RelationshipType.CHILD);
        person2.addRelationship(person3,RelationshipType.CHILD);
        person1.addRelationship(person2,RelationshipType.SPOUSE);
        person2.addRelationship(person1,RelationshipType.SPOUSE);
        person3.addRelationship(person1,RelationshipType.FATHER);
        person3.addRelationship(person2,RelationshipType.MOTHER);
        Relationship spouseRelationship = new Relationship(person1, person2, RelationshipType.SPOUSE);
        Relationship childRelationship1 = new Relationship(person1, person3, RelationshipType.CHILD);
        Relationship childRelationship2 = new Relationship(person2, person3, RelationshipType.CHILD);
        Relationship fatherRelationship = new Relationship(person3, person1, RelationshipType.FATHER);
        Relationship motherRelationship = new Relationship(person3, person2, RelationshipType.MOTHER);

        person1.getRelationships().add(spouseRelationship);
        person2.getRelationships().add(spouseRelationship);
        person1.getRelationships().add(childRelationship1);
        person2.getRelationships().add(childRelationship2);
        person3.getRelationships().add(fatherRelationship);
        person3.getRelationships().add(motherRelationship);


        FamilyTree familyTree = new FamilyTree(List.of(person1,person2,person3));


    }

}