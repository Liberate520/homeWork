import human.Gender;
import human.Person;
import tree.FamilyTree;
import tree.FileReadWrite;

import java.io.IOException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        FamilyTree copy;
        FileReadWrite fileReadWrite = new FileReadWrite();
        Service service = new Service(familyTree);



        //region input human
        Person human = new Person("Алексей", "Шишкарев",
                "Юрьевич", LocalDate.of(1987, 7, 12),
                Gender.Male);
        Person human2 = new Person("Лариса", "Шишкарева",
                "Александровна", LocalDate.of(1954, 8, 2),
                Gender.Female);
        Person human3 = new Person("Юрий", "Шишкарев",
                "Константинович", LocalDate.of(1953, 11, 15),
                Gender.Male);
        Person human4 = new Person("Виталий", "Шишкарев",
                "Юрьевич", LocalDate.of(1981, 9,17),
                Gender.Male);
        //endregion

        //region Adding Parent, Child Relationships
        human.setMather(human2);
        human4.setMather(human2);
        human.setFather(human3);
        human4.setFather(human3);
        //endregion

        //region add human in tree
        familyTree.addHumanList(human);
        familyTree.addHumanList(human2);
        familyTree.addHumanList(human3);
        familyTree.addHumanList(human4);
        //endregion

        service.sortByName();

        service.sortByAge();

        System.out.println(service.getHumanListInfo());

        //region task HomeWork002
//        //Выводим на экран human3
//        System.out.println(human3);
//        System.out.println("=".repeat(20));
//        //Записываем в файл дерево
//        fileReadWrite.writeTree(familyTree, "Tree.out");
//        //Изменяем имя human3
//        human3.setFirstName("123");
//        System.out.println(human3);
//        System.out.println("=".repeat(20));
//
//        //Считываем файл в копию дерева
//        copy = fileReadWrite.readTree( "Tree.out");
//
//        //Выводим копию на экран
//        System.out.println(copy.getHumanListInfo());
        //endregion
//region  Test output
//        System.out.println(familyTree.getHumanListInfo());
//        System.out.println(familyTree.findPerson("Алексей"));

//        System.out.println(human2.getChildren());
//endregion

    }
}