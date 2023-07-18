package family_tree;

import family_tree.person.Person;

// import java.time.LocalDate;

import family_tree.ftree.FamilyTree;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Person rec1 = new Person("Smith", "John","kjlkj","kml");
        Person rec2 = new Person("Smith", "John","kjlkj","kml");
        Person rec3 = new Person("Smith", "John","kjlkj","kml");

        familyTree.addPerson(rec1);
        familyTree.addPerson(rec2);
        familyTree.addPerson(rec3);

        System.out.println(familyTree.getRelativesInfo());

    }
}