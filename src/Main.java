import model.Service;
import model.saving.LoadFromFile;
import model.saving.LoadableObject;
import model.saving.SavableObject;
import model.saving.SaveInFile;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new ConsoleUI();
        SavableObject saveInFile = new SaveInFile();
        LoadableObject loadFromFile = new LoadFromFile();
        Service service = new Service(saveInFile, loadFromFile);
        Presenter presenter = new Presenter(view, service);

        view.start();


//        service.addPerson("Василий", "Лежебоков", 32, "м");
//        service.addPersonAs("Василиса", "Лежебокова", 27, "ж", "Василий", "Лежебоков", "сп");
//        service.addPersonAs("Анатолий", "Лежебоков", 57, "м", "Василий", "Лежебоков", "о");
//        service.addPersonAs("Анна", "Лежебокова", 53, "ж", "Василий", "Лежебоков", "м");
//        service.addPersonAs("Мария", "Кузьмина", 25, "ж", "Василий", "Лежебоков", "ст");
//        service.addPersonAs("Роман", "Билан", 29, "м", "Василий", "Лежебоков", "б");
//        service.addPersonAs("Петр", "Лежебоков", 7, "м", "Василий", "Лежебоков", "сн");
//        service.addPersonAs("Ирина", "Лежебокова", 5, "ж", "Василий", "Лежебоков", "д");

//        Service service = new Service();
//        service.addPerson("Василий", "Лежебоков", 32, Sex.Male);
//        service.addPersonAs("Василиса", "Лежебокова", 27, Sex.Female, "Василий", "Лежебоков", Relation.Spouse);
//        service.addPersonAs("Анатолий", "Лежебоков", 57, Sex.Male, "Василий", "Лежебоков", Relation.Father);
//        service.addPersonAs("Анна", "Лежебокова", 53, Sex.Female, "Василий", "Лежебоков", Relation.Mother);
//        service.addPersonAs("Мария", "Кузьмина", 25, Sex.Female, "Василий", "Лежебоков", Relation.Sister);
//        service.addPersonAs("Роман", "Билан", 29, Sex.Male, "Василий", "Лежебоков", Relation.Brother);
//        service.addPersonAs("Петр", "Лежебоков", 7, Sex.Male, "Василий", "Лежебоков", Relation.Son);
//        service.addPersonAs("Ирина", "Лежебокова", 5, Sex.Female, "Василий", "Лежебоков", Relation.Daughter);

//        System.out.println(service.getTreeInfo());
//        System.out.println();

        // Сохранение древа в файл и загрузка из файла
//        service.saveFamilyTreeAs("model.familyTree.out", new FileOutStr());
//        service.loadFamilyTreeFrom("model.familyTree.out", new FileOutStr());
//        System.out.println(service.getTreeInfo());
//        System.out.println();

        // Сохранение персоны в файл и загрузка из файла
//        Person personBeforeSave = service.getPerson("Мария", "Кузьмина");
//        System.out.println(personBeforeSave);
//        service.savePersonAs(personBeforeSave, "model.person.out", new FileOutStr());
//        Person personAfterLoad = service.loadPersonFrom("model.person.out", new FileOutStr());
//        System.out.println(personAfterLoad);
//
//        System.out.println(service.getInfo("Петр", "Лежебоков", Relation.Father));
//        System.out.println("Сортировка по возрасту:");
//        service.printSortByAge();
//        System.out.println();
//        System.out.println("Сортировка по фамилии:");
//        service.printSortByLastName();
//        System.out.println();
//        System.out.println("Сортировка по имени:");
//        service.printSortByFirstName();






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
//        FamilyTree model.familyTree = new FamilyTree();
//        model.familyTree.pushToTree(person1);
//        model.familyTree.pushToTree(person2);

        // Вывод всех записей
//        System.out.println(model.familyTree);
//        System.out.println();

        // Получение информации по записи
//        System.out.println(model.familyTree.getInfo("Василий", "Лежебоков", Relation.Spouse));
//        System.out.println();
//        System.out.println(model.familyTree.getInfo("Василий", "Лежебоков", Relation.Son));
//        System.out.println();
//        System.out.println(model.familyTree.getInfo("Петр", "Лежебоков", Relation.Father));
//        System.out.println();
//        System.out.println(model.familyTree.getInfo("Анатолий", "Лежебоков"));
//        System.out.println();
//        System.out.println(model.familyTree.getInfo("Василиса", "Лежебокова"));
//        System.out.println();

        // Изменение информации по записи
//        Person person3 = model.familyTree.getPerson("Василиса", "Лежебокова");
//        person3.setMother("Алефтина", "Маркова", 60);
//        person3.setFather("Макар", "Марков", 65);
//        model.familyTree.pushToTree(person3);

        // Просмотр измененной информации по записи
//        System.out.println(model.familyTree.getInfo("Василиса", "Лежебокова"));

        // Сериализуем FamilyTree и Person1 с помощью класса ObjectOutputStream
//        model.familyTree.saveFamilyTreeAs("model.familyTree.out", new FileOutStr());
//        model.familyTree.savePersonAs(person1, "model.person.out", new FileOutStr());

        // Десериализация FamilyTree и Person1 из файлов с помощью класса ObjectInputStream
//        FamilyTree familyTreeRestored = model.familyTree.loadFamilyTreeFrom("model.familyTree.out", new FileOutStr());
//        Person person1Restored = model.familyTree.loadPersonFrom("model.person.out", new FileOutStr());

        // Вывод восстановленного FamilyTree
//        System.out.println();
//        System.out.println("Restored FamilyTree:");
//        System.out.println(familyTreeRestored);
//        System.out.println();
//        System.out.println("Restored Person:");
//        System.out.println(person1Restored);
    }
}
