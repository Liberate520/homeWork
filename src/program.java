// Реализовать, с учетом ооп подхода, приложение
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и модель семейного дерева для хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
// У дерева обязательно реализовать метод добавления нового человека в семейное дерево, поиск человека по имени и вывод всех людей из дерева.
// У человека можно реализовать методы вывода всех сестер или всех детей.
// Проект сдать либо в виде репозитория либо в виде PullRequest к проекту: https://github.com/Liberate520/homeWork
// Если делаете PR, то в качестве ответа укажите ссылку на конкретный PR
// Инструкция на то как сделать PR https://youtu.be/veMDnBt30pk

// В проекте с гениалогическим древом подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте интерфейс, 
// который и используйте в своей программе. Например в классе дерева в качестве аргумента метода save передавайте не конкретный класс, а объект интерфейса, 
// с помощью которого и будет происходить запись. Пример работы с интерфейсом Serialazable можно найти в материалах к уроку

// В проекте с деревом реализовать интерфейс Iterable для дерева.
// Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения
// Сделать итератор и компараторы

// Продолжаем грейдить наш проект с гениологическим древом. Изменить древо, сделать класс параметизированным. 
// Продумать класс общения с пользователем, сделать набор команд, для операций над деревом

package DZ1;

import java.io.IOException;
import java.io.Serializable;
// import java.util.*;

public class program implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // int flagOutofMainLoop = 0;
        View view = new FamilyTreeUI();
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Presenter presenter = new Presenter(view, familyTree);

        Human human1 = new Human("Иван", "м");
        familyTree.add(human1);
        Human human2 = new Human("Мария", "ж");
        familyTree.add(human2);
        Human human3 = new Human("Василий", "м", familyTree.getHumanByName("Иван"),
                familyTree.getHumanByName("Мария"));
        familyTree.add(human3);
        Human human4 = new Human("Дарья", "ж", familyTree.getHumanByName("Иван"),
                familyTree.getHumanByName("Мария"));
        familyTree.add(human4);
        Human human5 = new Human("Галина", "ж");
        familyTree.add(human5);
        Human human6 = new Human("Сергей", "м", familyTree.getHumanByName("Василий"),
                familyTree.getHumanByName("Галина"));
        familyTree.add(human6);

        view.start();

        // FileHandler fileHandler = new FileHandler();

        // Scanner scanner = new Scanner(System.in, "Cp866");

        // while (flagOutofMainLoop == 0) {

        // System.out.println(
        // "\n1 - Вывести всех людей из дерева\n2 - Поиск по имени\n3 - Очистить дерево
        // \n4 - Выгрузить в файл \n5 - Загрузить из файла\n6 - Сортировка дерева \n7 -
        // Выход\nВведите цифру, соответствующую необходимому критерию:");

        // int userChoiceStartMenu = scanner.nextInt();

        // switch (userChoiceStartMenu) {
        // case 1:
        // scanner.nextLine();
        // System.out.println(familyTree.getAllHumans());
        // break;
        // case 2:
        // scanner.nextLine();
        // System.out.println("Введите имя: ");
        // String userInputName = scanner.nextLine();
        // System.out.println(familyTree.getHumanByNameAndRelatives(userInputName));
        // break;
        // case 3:
        // familyTree.clearTree();
        // break;
        // case 4:
        // Human humantemp = new Human();
        // humantemp.setWritable(fileHandler);
        // humantemp.save(familyTree.getHumans());
        // break;
        // case 5:
        // Human newHuman1 = new Human();
        // newHuman1.setWritable(fileHandler);
        // familyTree.addList(newHuman1.read());
        // break;
        // case 6:

        // System.out.println(
        // "\n1 - Сортировка по имени\n2 - сортировка по полу\nУкажите параметр
        // сортировки: ");
        // int userChoiceSortMenu = scanner.nextInt();
        // switch (userChoiceSortMenu) {
        // case 1:
        // familyTree.sortByName();
        // System.out.println("Отсортировано по имени");
        // break;
        // case 2:
        // familyTree.sortByGender();
        // System.out.println("Отсортировано по полу");
        // break;
        // }
        // break;
        // case 7:
        // flagOutofMainLoop = 1;
        // break;
        // default:
        // System.out.println("Некорректный ввод ");
        // break;
        // }
        // }
        // scanner.close();
    }
}
