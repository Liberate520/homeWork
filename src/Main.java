
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import human.HumanInterface;
import tree.FamilyTree;
import human.Human;
import workingFile.MethodClass;






// Урок1
// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и дерева
// Под “проведением исследования” можно понимать например
// получение всех детей выбранного человека.

// Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования

// В проекте с гениалогическим древом подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла. Для этого создать
//  отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте
//   интерфейс, который и используйте в своей программе. Например в классе дерева
//   в качестве аргумента метода save передавайте не конкретный класс, а объект интерфейса,
//   с помощью которого и будет происходить запись. Пример работы с интерфейсом Serialazable
//    можно найти в материалах к уроку

// Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования

// Продолжаем работать с проектом с семейным деревом.
// Реализовать интерфейс Iterable для дерева.
// Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)

public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args)  {

        FamilyTree treeFam = new FamilyTree();

        treeFam.addNewHuman(new Human("Ирина", "Малинина", "21.08.1987"), null);
        treeFam.addNewHuman(new Human("Владимир", "Малинин", "10.02.1985"), null);

        treeFam.addNewHuman(
                new Human("Семен", "Малинин", "17.03.2017", treeFam.getByName("Владимир"),
                        treeFam.getByName("Ирина")),
                null);
        treeFam.addNewHuman(
                new Human("Оля", "Малинина", "27.09.2016", treeFam.getByName("Владимир"),
                        treeFam.getByName("Ирина")),
                null);

        treeFam.addNewHuman(new Human("Олег", "Титов", "10.07.1989"), null);
        treeFam.addNewHuman(
                new Human("Алексей", "Титов", "27.09.2019", treeFam.getByName("Олег"),
                        treeFam.getByName(null)),
                null);

        System.out.println();
//         System.out.println(tree.getInfo());


//        ----------------------------------------------------------------------------------------------------

//        MethodClass treeForWrite = new
//         MethodClass(tree.getInfo(), null);
//         // System.out.println("Before write: \n" + treeForWrite);
//
//         ObjectOutputStream out = new ObjectOutputStream(new
//         FileOutputStream("FamilyTree.out"));
//         out.writeObject(treeForWrite);
//         out.close();
//
//         ObjectInputStream in = new ObjectInputStream(new
//         FileInputStream("FamilyTree.out"));
//         treeForWrite = (MethodClass) in.readObject();
//
//         System.out.println("After read: \n" + treeForWrite);



//         ---------------------------------------------------------------------------------------

//         Создаем экземпляр класса Service и помещаем в него экземпляр tree
        Service service = new Service(treeFam);

        System.out.println();
        System.out.println("-----------до сортировки-----------");
        System.out.println();


//         Выводим экземпляры tree перед сортировкой
        for (Human st : treeFam) {
            System.out.println(st);
        }

        System.out.println();
        System.out.println("------после сортировки по имени--------");
        System.out.println();

//         Производим сортировку по имени
        service.sortByName();

//         Выводим экземпляры tree после сортировки
        for (Human st : treeFam) {
            System.out.println(st);
        }

//         Производим сортировку по фамилии
        service.sortByFamily();

        System.out.println();
        System.out.println("------после сортировки по фамилии--------");
        System.out.println();

//         Выводим экземпляры tree после сортировки
        for (Human st : treeFam) {
            System.out.println(st);
        }

    }
}