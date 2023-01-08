package FT.UI;

import FT.Tree;
import FT.FileHandler;
import FT.Human;
import FT.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI<T extends Human> {

    private Tree familyTree;
    private FileHandler fileHandler;
    private Presenter presenter;

    public ConsoleUI(Tree familyTree, FileHandler fileHandler, Presenter presenter) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.presenter = presenter;
        this.familyTree.setWritable(fileHandler);
        this.familyTree = familyTree.readFamilyTree();
        presenter.setFamilyTree(this.familyTree);
    }

    private T getHuman(Tree familyTree) {
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
        //        System.out.println(human);
        return (T) human;
    }


    public void start() {
        Scanner iScanner = new Scanner(System.in);
        boolean repeat = true;
        T human;
        while (repeat) {
            System.out.println("Введите действие:");
            System.out.println("Enter - завершение программы и сохранение FamilyTree,");
            System.out.println("1 - показать всех членов дерева (без сортировки),");
            System.out.println("2 - добавить нового члена семьи,");
            System.out.println("3 - найти члена семьи по имени,");
            System.out.println("4 - показать всех детей члена семьи,");
            System.out.println("5 - показать всех сестёр члена семьи,");
            System.out.println("6 - показать всех братьев члена семьи,");
            System.out.println("7 - показать всех членов дерева (сортировка по имени),");
            System.out.println("8 - показать всех членов дерева (сортировка по возрасту).");
            System.out.print("-->\t");
            String str = iScanner.nextLine();
            switch (str) {
                case "":
                    presenter.saveFamilyTree();
                    repeat = false;
                    break;
                case "1":
                    presenter.printFamilyTree();
                    break;
                case "2":
                    human = this.getHuman(familyTree);
                    presenter.addNewMember(human);
                    break;
                case "3":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    System.out.printf("Нашёл\n%s\n", presenter.findMember(str));
                    break;
                case "4":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    System.out.println(presenter.getAllChildren(str));
                    break;
                case "5":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    System.out.println(presenter.getAllSisters(str));
                    break;
                case "6":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    System.out.println(presenter.getAllBrothers(str));
                    break;
                case "7":
                    System.out.println(presenter.sortFamilyTree("name"));
                    break;
                case "8":
                    System.out.println(presenter.sortFamilyTree("age"));
                    break;
                default:
                    System.out.println("Я вас не понял, повторите ввод.");
                    break;
            }
        }
        iScanner.close();
    }


}