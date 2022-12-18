package homeWork.src;
// ДЗ 1
// Реализовать, с учетом ооп подхода, приложение
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
//
// модель человека и модель семейного дерева для хранения связей и отношений между людьми: родитель, ребёнок - классика,
// но можно подумать и про отношение, брат, свекровь, сестра и т. д.
// У дерева обязательно реализовать метод добавления нового человека в семейное дерево, поиск человека по имени и вывод всех людей из дерева.
// У человека можно реализовать методы вывода всех сестер или всех детей.
//
// Проект сдать либо в виде репозитория либо в виде PullRequest к проекту: https://github.com/Liberate520/homeWork
// Если делаете PR, то в качестве ответа укажите ссылку на конкретный PR
// Инструкция на то как сделать PR https://youtu.be/veMDnBt30pk
// По вопросам домашки писать @Liberate520
// Обязательно пробуем свои силы, в дальнейшем будем этот проект развивать
// ДЗ 2
// В проекте с генеалогическим древом подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла.
// Для этого создать отдельный класс и реализовать в нем нужные методы.
// Для данного класса сделайте интерфейс, который и используйте в своей программе.
// Например, в классе дерева в качестве аргумента метода save передавайте не конкретный класс, а объект интерфейса,
// с помощью которого и будет происходить запись. Пример работы с интерфейсом Serialazable можно найти в материалах к уроку


import com.sun.tools.javac.Main;

import java.util.Scanner;

public class main {

    public static Human getHuman(FamilyTree familyTree) {
        Human human = new Human();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String str = iScanner.nextLine();
        human.setName(str);
        System.out.print("Введите пол: ");
        str = iScanner.nextLine();
        human.setGender(str);
        System.out.print("Введите имя отца (может быть пустым): ");
        str = iScanner.nextLine();
        human.setFather(familyTree.getByName(str));
        System.out.print("Введите имя матери (может быть пустым): ");
        str = iScanner.nextLine();
        human.setMother(familyTree.getByName(str));
        System.out.println(human);
        return human;
    }


    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();
//        Сначала необходимо создать самых старших членов семьи, у которых родители неизвестны
//        Human human1 = new Human("Василий", "М");
        Human human2 = new Human("Мария", "Ж");
//        System.out.println(human1);
//        System.out.println(human2);
//        familyTree.addNewMember(human1);
//        familyTree.addNewMember(human2);
//        System.out.println(familyTree);
//        Human human3 = new Human("Пётр", "М", human1, human2);
//        Human human4 = new Human("Татьяна", "Ж", human1, human2);
//        Human human5 = new Human("Елена", "Ж", human1, human2);
//        Human human6 = new Human("Михаил", "М", human3, human4);
//        Human human7 = new Human("Иван", "М", human3, human4);

//        familyTree.addNewMember(human3);
//        familyTree.addNewMember(human4);
//        familyTree.addNewMember(human5);
//        familyTree.addNewMember(human6);
//        familyTree.addNewMember(human7);

//        System.out.println(familyTree);

//        Human human = familyTree.getByName("Пётр");
//        System.out.printf("Нашёл\n%s", human);

//        System.out.println(human1.getAllChildren());
//        System.out.printf("Сёстры %s - %s\n", human4.getName(), human4.getAllSisters());
//        System.out.println(human7.getAllSisters());

//        System.out.println("-------------------");

        FileHandler fileHandler = new FileHandler();
//      устанавливаем файловый обработчик для familyTree типа FileHandler
        familyTree.setWritable(fileHandler);

//        familyTree.saveFamilyTree();

//        familyTree = familyTree.readFamilyTree();
//        System.out.println("-------------------");
//        System.out.println(familyTree);

        familyTree = familyTree.readFamilyTree();

        Scanner iScanner = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.print("Введите действие:\nEnter - завершение программы и сохранение FamilyTree,\n1 - показать всех членов дерева," +
                    "\n2 - добавить нового члена семьи\n3 - найти члена семьи по имени\n4 - показать всех детей члена семьи" +
                    "\n5 - показать всех сестёр члена семьи\n6 - показать всех братьев члена семьи\n--> ");
            String str = iScanner.nextLine();
            switch (str) {
                case "":
                    repeat = false;
                    familyTree.saveFamilyTree();
                    break;
                case "1":
                    System.out.println(familyTree);
                    break;
                case "2":
//                    familyTree.addNewMember(human2);

                    familyTree.addNewMember(getHuman(familyTree));
                    break;
                case "3":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    Human findedHuman = familyTree.getByName(str);
                    System.out.printf("Нашёл\n%s\n", findedHuman);
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Я вас не понял, повторите ввод.");
                    break;
            }
        }
        iScanner.close();


    }
}
