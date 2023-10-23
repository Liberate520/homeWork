package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создание генеалогического дерева с корневым человеком person1
        FamilyTree familyTree = new FamilyTree();

        Person per1 = new Person("Sveta", "Komal", Person.Gender.woman, LocalDate.of(1989, 10, 2));
        Person per2 = new Person("Petr", "Komal", Person.Gender.man, LocalDate.of(1988, 1, 15));
        familyTree.addPerson(per1);
        familyTree.addPerson(per2);

        per1.setMarriage(per2, LocalDate.of(2010, 11, 12));
        per2.setMarriage(per1, LocalDate.of(2010, 11, 12));

        Person ch1 = new Person("Ivan", "Komal", Person.Gender.man, LocalDate.of(2020, 4, 11), per1, per2);
        familyTree.addChild(ch1);

        familyTree.addPerson(new Person("Maria", "Permyakova", Person.Gender.woman, LocalDate.of(2008, 6, 24)));

        FileHandler fs = new FileHandler();
        fs.write(familyTree, "test.bin");

        FamilyTree testTree = new FamilyTree();
        try {
            testTree = (FamilyTree)fs.read("test.bin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}