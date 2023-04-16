public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Василий", "Лежебоков", 32, Sex.Male);
        person1.setWife("Василиса", "Лежебокова", 27);
        person1.setFather("Анатолий", "Лежебоков", 57);
        person1.setMother("Анна", "Лежебокова", 53);
        person1.addSister("Мария", "Лежебокова", 25);
        person1.addBrother("Роман", "Лежебоков", 29);
        person1.addBrother("Николай", "Лежебоков", 26);
        person1.addChildren("Петр", "Лежебоков", 7, Sex.Male);

        Person person2 = new Person("Константин", "Костров", 35, Sex.Male);
        person2.setWife("Марфа", "Кострова", 25);
        person2.setFather("Петр", "Костров", 59);
        person2.setMother("Ольга", "Кострова", 50);

        FamilyTree familyTree = new FamilyTree();
        familyTree.pushToTree(person1);
        familyTree.pushToTree(person2);

        // Вывод всех записей
        System.out.println(familyTree);
        System.out.println();

        // Получение информации по записи
//        System.out.println(familyTree.getInfo("Василий", "Лежебоков", Relation.Brother));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Василий", "Лежебоков", Relation.Son));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Петр", "Лежебоков", Relation.Father));
//        System.out.println();
//        System.out.println(familyTree.getInfo("Анатолий", "Лежебоков"));
        System.out.println(familyTree.getInfo("Василиса", "Лежебокова"));
        System.out.println();

        // Изменение информации по записи
        Person person3 = familyTree.getPerson("Василиса", "Лежебокова");
        person3.setMother("Алефтина", "Маркова", 60);
        person3.setFather("Макар", "Марков", 65);
        familyTree.pushToTree(person3);

        // Просмотр измененной информации по записи
        System.out.println(familyTree.getInfo("Василиса", "Лежебокова"));

    }

}
