import java.io.IOException;


import model.Service;
import model.save.ClassWriteRead;
import model.familyTree.FamilyTree;
import model.human.Human;
import presenter.Presenter;
import view.Console;
import view.View;


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
//   в качестве аргумента метода model.save передавайте не конкретный класс, а объект интерфейса,
//   с помощью которого и будет происходить запись. Пример работы с интерфейсом Serialazable
//    можно найти в материалах к уроку

// Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования

// Продолжаем работать с проектом с семейным деревом.
// Реализовать интерфейс Iterable для дерева.
// Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)

// Урок 4. ООП: Обобщения. ч1

// Продолжаем грейдить наш проект с гениологическим древом. Изменить древо,
//  сделать класс параметизированным. Продумать класс общения с пользователем, 
//  сделать набор команд, для операций над деревом

// Урок 5. От простого к практике
// Реализовать проект с семейным деревом в формате MVP

//Урок 6. ООП Дизайн и Solid
// Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а


public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Human> tree = new FamilyTree<>();
//
//
        tree.addNewHuman(new Human("Ирина", "Малинина", "21.08.1987"), null);
        tree.addNewHuman(new Human("Владимир", "Малинин", "10.02.1985"), null);

        tree.addNewHuman(new Human("Семен", "Малинин", "17.03.2017", tree.getByName("Владимир"),
                        tree.getByName("Ирина")),
                null);
        tree.addNewHuman(new Human("Оля", "Малинина", "27.09.2016", tree.getByName("Владимир"),
                        tree.getByName("Ирина")),
                null);

        tree.addNewHuman(new Human("Олег", "Титов", "10.07.1989"), null);
        tree.addNewHuman(new Human("Алексей", "Титов", "27.09.2019", tree.getByName("Олег"),
                tree.getByName(null)), null);
//
//        System.out.println();
        //System.out.println(tree.getInfo());


        // //////////////////////*****  СЕРИАЛИЗАЦИЯ ******///////////////////////


//        Service fileName = new Service();
//
//        String nameFILE = fileName.getFileName();
//
//
//       //  создаем новый экземпляр класса ClassWriteRead
//       ClassWriteRead treeForWrite = new ClassWriteRead<>(null, nameFILE);
//
//
//       //  сохраняем в файл
//        treeForWrite.save(tree.getInfo(), nameFILE);
//


        ////////////////////////////////***M V P ****//////////////////////////////////


        View view = new Console();
        Service service = new Service(tree);
        // Service service = new Service();
        Presenter presenter = new Presenter(view, service);
        view.start();


    }
}
