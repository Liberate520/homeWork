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
// ДЗ 3
// В проекте с деревом реализовать интерфейс Iterable для дерева.
// Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения


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
        System.out.print("Введите возраст: ");
        try {
            str = iScanner.nextLine();
            human.setAge(Integer.parseInt(str));
        } catch (Exception exception) {
            System.out.println("Не корректный ввод! Записываю возраст 0.");
            human.setAge(0);
        }
//        str = iScanner.nextLine();
//        human.setAge(Integer.parseInt(str));
        System.out.print("Введите имя отца (может быть пустым): ");
        str = iScanner.nextLine();
        human.setFather(familyTree.getByName(str));
        System.out.print("Введите имя матери (может быть пустым): ");
        str = iScanner.nextLine();
        human.setMother(familyTree.getByName(str));
//        System.out.println(human);
        return human;
    }


    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
//      устанавливаем файловый обработчик для familyTree типа FileHandler
        familyTree.setWritable(fileHandler);
//      читаем FamilyTree из файла. В случае неудачи работаем с новым пустым FamilyTree
        familyTree = familyTree.readFamilyTree();

        Scanner iScanner = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.print("""
                    Введите действие:
                    Enter - завершение программы и сохранение FamilyTree,
                    1 - показать всех членов дерева (без сортировки),
                    2 - добавить нового члена семьи,
                    3 - найти члена семьи по имени,
                    4 - показать всех детей члена семьи,
                    5 - показать всех сестёр члена семьи,
                    6 - показать всех братьев члена семьи,
                    7 - показать всех членов дерева (сортировка по имени),
                    8 - показать всех членов дерева (сортировка по возрасту).
                    -->\s""");
            String str = iScanner.nextLine();
            switch (str) {
                case "":
//                  сохраняем FamilyTree в файл и выходи из цикла while
                    familyTree.saveFamilyTree();
                    repeat = false;
                    break;
                case "1":
                    System.out.println(familyTree);
                    break;
                case "2":
                    familyTree.addNewMember(main.getHuman(familyTree));
                    break;
                case "3":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    Human findedHuman = familyTree.getByName(str);
                    System.out.printf("Нашёл\n%s\n", findedHuman);
                    break;
                case "4":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    findedHuman = familyTree.getByName(str);
                    System.out.println(findedHuman.getAllChildren());
                    break;
                case "5":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    findedHuman = familyTree.getByName(str);
                    System.out.printf("Сёстры %s - %s\n", findedHuman.getName(), findedHuman.getAllSistersOrBrothers("Ж"));
                    break;
                case "6":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    findedHuman = familyTree.getByName(str);
                    System.out.printf("Братья %s - %s\n", findedHuman.getName(), findedHuman.getAllSistersOrBrothers("М"));
                    break;
                case "7":
                    familyTree.sortByName();
                    System.out.println(familyTree);
                    break;
                case "8":
                    familyTree.sortByAge();
                    System.out.println(familyTree);
                    break;

                default:
                    System.out.println("Я вас не понял, повторите ввод.");
                    break;
            }
        }
        iScanner.close();
    }
}
