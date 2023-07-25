package homeWork;

import homeWork.FamilyTree.Family_tree;
import homeWork.FamilyTree.Gender;
import homeWork.FamilyTree.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Family_tree familyTree = new Family_tree();
        Human f1 = new Human("Konstantin", LocalDate.of(1933,12,1), LocalDate.of(1998,11,25), Gender.Male);
        Human m1 = new Human("Efrosinya", LocalDate.of(1934, 7,14), Gender.Female);
        Human h1 = new Human("Vasya", m1, f1, LocalDate.of(1950, 5, 30), null, Gender.Male);
        Human h2 = new Human("Vasilisa", LocalDate.of(1945, 2, 11), Gender.Female);
        Human child1 = new Human("Leonid", LocalDate.of(1973, 11,10), Gender.Male);
        Human child2 = new Human("Mariya", LocalDate.of(1975, 8,17), Gender.Female);
        familyTree.addHuman(f1);
        familyTree.addHuman(m1);
        familyTree.addHuman(h1);
        familyTree.addHuman(h2);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);
        familyTree.setParentsAndChilds(h1, m1, f1);
        familyTree.setParentsAndChilds(child1, h2, h1);
        familyTree.setParentsAndChilds(child2, h1, h2);
        familyTree.siblings(child1,child2);
        System.out.println(familyTree.getFamilyTree());
        /*familyTree.sortByAge();*/
        familyTree.sortByName();
        System.out.println(familyTree.getFamilyTree());
/*        FileHandler s1 = new FileHandler();
        s1.Save(familyTree);
        Family_tree s2 = (Family_tree) s1.Load();
        System.out.println("Family Tree after serialize: \n" + s2.getFamilyTree());*/
    }
}
