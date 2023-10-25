package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//https://github.com/Liberate520/homeWork/pull/559
public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/test/Desktop/oop/sem1/homeWork/src/tree/tree2.txt";
        Writeable writeable = new FileHandler();

        FamilyTree familyTree = (FamilyTree) writeable.readFromFile(filePath);
        //FamilyTree familyTree = new FamilyTree();

        //familyTree.add(new Human("Yuriy", LocalDate.of(1991, 3, 5), Gender.Male, new Human("Natalya", Gender.Female), new Human("Mikhail", Gender.Male)));
        //familyTree.add(new Human("Evgeniy", LocalDate.of(1987, 7, 23), Gender.Male, new Human("Natalya", Gender.Female), new Human("Mikhail", Gender.Male)));
        //familyTree.add(new Human("Filippa", LocalDate.of(2021, 9, 10), Gender.Female, new Human("Anna", Gender.Female), new Human("Evgeniy",Gender.Male)));

        //writeable.writeToFile(familyTree, filePath);

        System.out.println(familyTree.fullTree());
    }
}
