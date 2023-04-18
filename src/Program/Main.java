package Program;

import Saving.Out;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person1 = new Person("Василий", "Лежебоков", 32, Sex.Male);
        person1.setSpouse("Василиса", "Лежебокова", 27, Sex.Female);
        person1.setFather("Анатолий", "Лежебоков", 57);
        person1.setMother("Анна", "Лежебокова", 53);
        person1.addSister("Мария", "Лежебокова", 25);
        person1.addBrother("Роман", "Лежебоков", 29);
        person1.addBrother("Николай", "Лежебоков", 26);
        person1.addChildren("Петр", "Лежебоков", 7, Sex.Male);

        Person person2 = new Person("Константин", "Костров", 35, Sex.Male);
        person2.setSpouse("Марфа", "Кострова", 25, Sex.Female);
        person2.setFather("Петр", "Костров", 59);
        person2.setMother("Ольга", "Кострова", 50);

        FamilyTree familyTree = new FamilyTree();
        familyTree.pushToTree(person1);
        familyTree.pushToTree(person2);

        // Вывод всех записей
        System.out.println(familyTree);
        System.out.println();

        // Получение информации по записи
//        System.out.println(familyTree.getInfo("Василий", "Лежебоков", Program.Relation.Spouse));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Василий", "Лежебоков", Program.Relation.Son));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Петр", "Лежебоков", Program.Relation.Father));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Анатолий", "Лежебоков"));
//
//        System.out.println(familyTree.getInfo("Василиса", "Лежебокова"));
//        System.out.println();

        // Изменение информации по записи
        Person person3 = familyTree.getPerson("Василиса", "Лежебокова");
        person3.setMother("Алефтина", "Маркова", 60);
        person3.setFather("Макар", "Марков", 65);
        familyTree.pushToTree(person3);

        // Просмотр измененной информации по записи
//        System.out.println(familyTree.getInfo("Василиса", "Лежебокова"));

        // Сериализуем FamilyTree с помощью класса ObjectOutputStream
        familyTree.saveAs("familyTree.out", new Out());

        // Десериализация из файла с помощью класса ObjectInputStream
        FamilyTree familyTreeRestored = familyTree.getFamilyTreeFrom("familyTree.out", new Out());

        // Вывод восстановленного FamilyTree
        System.out.println();
        System.out.println(familyTreeRestored);
        System.out.println(familyTreeRestored.getInfo("Василий", "Лежебоков", Program.Relation.Spouse));
    }
}
