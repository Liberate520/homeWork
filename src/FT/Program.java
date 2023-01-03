package FT;

import java.util.Scanner;

public class Program {

    public static Human getHuman(Tree familyTree) {
        Human human = new Human();
        try (Scanner iScanner = new Scanner(System.in)) {
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
            System.out.print("Введите имя отца (может быть пустым): ");
            str = iScanner.nextLine();
            human.setFather(familyTree.getByName(str));
            System.out.print("Введите имя матери (может быть пустым): ");
            str = iScanner.nextLine();
            human.setMother(familyTree.getByName(str));
        }
        return human;
    }


    public static void main(String[] args) {

        Tree familyTree = new Tree();
        FileHandler fileHandler = new FileHandler();
        familyTree.setWritable(fileHandler);
        familyTree = familyTree.readFamilyTree();

        Scanner iScanner = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.print("""
                    Введите действие:
                    Enter - завершение программы и сохранение семейного древа,
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
                    familyTree.saveFamilyTree();
                    repeat = false;
                    break;
                case "1":
                    System.out.println(familyTree);
                    break;
                case "2":
                    familyTree.addNewMember(Program.getHuman(familyTree));
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