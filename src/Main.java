import person.Person;
import person.Relation;
import person.Sex;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Service service = new Service();
        service.addPerson("Василий", "Лежебоков", 32, Sex.Male);
        System.out.println(service.getTreeInfo());

        service.addPersonAs("Василиса", "Лежебокова", 27, Sex.Female, "Василий", "Лежебоков", Relation.Spouse);
        service.addPersonAs("Анатолий", "Лежебоков", 57, Sex.Male, "Василий", "Лежебоков", Relation.Father);
        service.addPersonAs("Анна", "Лежебокова", 53, Sex.Female, "Василий", "Лежебоков", Relation.Mother);
        service.addPersonAs("Мария", "Кузьмина", 25, Sex.Female, "Василий", "Лежебоков", Relation.Sister);
        service.addPersonAs("Роман", "Билан", 29, Sex.Male, "Василий", "Лежебоков", Relation.Brother);
        service.addPersonAs("Петр", "Лежебоков", 7, Sex.Male, "Василий", "Лежебоков", Relation.Son);
        service.addPersonAs("Ирина", "Лежебокова", 5, Sex.Female, "Василий", "Лежебоков", Relation.Daughter);
        System.out.println(service.getTreeInfo());
        System.out.println();
        System.out.println(service.getInfo("Петр", "Лежебоков", Relation.Father));
        service.printSortByAge();
        System.out.println();
        service.printSortByLastName();
        System.out.println();
        service.printSortByFirstName();



//        Person person1 = new Person("Василий", "Лежебоков", 32, Sex.Male);
//        person1.setSpouse("Василиса", "Лежебокова", 27, Sex.Female);
//        person1.setFather("Анатолий", "Лежебоков", 57);
//        person1.setMother("Анна", "Лежебокова", 53);
//        person1.addSister("Мария", "Лежебокова", 25);
//        person1.addBrother("Роман", "Лежебоков", 29);
//        person1.addBrother("Николай", "Лежебоков", 26);
//        person1.addChildren("Петр", "Лежебоков", 7, Sex.Male);
//
//        Person person2 = new Person("Константин", "Костров", 35, Sex.Male);
//        person2.setSpouse("Марфа", "Кострова", 25, Sex.Female);
//        person2.setFather("Петр", "Костров", 59);
//        person2.setMother("Ольга", "Кострова", 50);
//
//        FamilyTree familyTree = new FamilyTree();
//        familyTree.pushToTree(person1);
//        familyTree.pushToTree(person2);

        // Вывод всех записей
//        System.out.println(familyTree);
//        System.out.println();

        // Получение информации по записи
//        System.out.println(familyTree.getInfo("Василий", "Лежебоков", Relation.Spouse));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Василий", "Лежебоков", Relation.Son));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Петр", "Лежебоков", Relation.Father));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Анатолий", "Лежебоков"));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Василиса", "Лежебокова"));
//        System.out.println();

        // Изменение информации по записи
//        Person person3 = familyTree.getPerson("Василиса", "Лежебокова");
//        person3.setMother("Алефтина", "Маркова", 60);
//        person3.setFather("Макар", "Марков", 65);
//        familyTree.pushToTree(person3);

        // Просмотр измененной информации по записи
//        System.out.println(familyTree.getInfo("Василиса", "Лежебокова"));

        // Сериализуем FamilyTree и Person1 с помощью класса ObjectOutputStream
//        familyTree.saveFamilyTreeAs("familyTree.out", new FileOutStr());
//        familyTree.savePersonAs(person1, "person.out", new FileOutStr());

        // Десериализация FamilyTree и Person1 из файлов с помощью класса ObjectInputStream
//        FamilyTree familyTreeRestored = familyTree.loadFamilyTreeFrom("familyTree.out", new FileOutStr());
//        Person person1Restored = familyTree.loadPersonFrom("person.out", new FileOutStr());

        // Вывод восстановленного FamilyTree
//        System.out.println();
//        System.out.println("Restored FamilyTree:");
//        System.out.println(familyTreeRestored);
//        System.out.println();
//        System.out.println("Restored Person:");
//        System.out.println(person1Restored);
    }
}
