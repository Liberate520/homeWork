package family_tree;

import family_tree.person.Gender;
import family_tree.person.Person;

import java.time.LocalDate;
import family_tree.ftree.FamilyTree;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Person rec1 = new Person("John", "Smith", Gender.Male, LocalDate.of(1965, 7, 14));
        Person rec2 = new Person("Mill", "Perri", Gender.Male, LocalDate.of(1920,1,19), LocalDate.of(2003,4,29), null, null, null);
        Person rec3 = new Person("Linda", "Wayne", Gender.Female, LocalDate.of(1923,6,29), LocalDate.of(2007,7,21), null, null, null);
        Person rec4 = new Person("Katty", "Perri", Gender.Female, LocalDate.of(1980,8,10),rec3,rec2);
        Person rec5 = new Person("Elly", "Wayne", Gender.Female, LocalDate.of(1988,3,12),null,null);

        familyTree.addPerson(rec1);
        familyTree.addPerson(rec2);
        familyTree.addPerson(rec3);
        familyTree.addPerson(rec4);
        familyTree.addPerson(rec5);

        System.out.println(familyTree.getRelativesInfo());

    }
}