package view;

import controller.TreeControl;
import model.Human;
import model.Tree;

import java.util.Scanner;

public class Menu {

    private TreeControl controller;
    private Tree tree;

    public Menu(TreeControl controller) {
        this.controller = controller;
    }

    public void runMenu() {
        Scanner in = new Scanner(System.in);
        Boolean begin = true;

        String name;
        int gender;
        String com;

        while (begin) {

            System.out.println("------");
            System.out.println("Введите число для соответствующей задачи или иное для выхода:");
            System.out.println("1. Добавить в дерево.");
//            System.out.println("Добавить связь");
//            System.out.println("удалить из дерева");
            System.out.println("2. Получить список всех людей в дереве.");
            System.out.println("3. Вывести всех потомков.");

            com = in.next();

            switch (com) {
                case "1":
                    System.out.printf("Введите имя: ");
                    name = in.next();
                    System.out.printf("Введите цифру гендера (0 = жен, 1 = муж): ");
                    gender = in.nextInt();

                    controller.addToTree(controller.createHuman(name, gender), tree);
                    System.out.println("Член семьи создан и сохранён в дереве");
                    break;

                case "2":
                    System.out.println(tree.getHumanList());
                    break;

                case "3":
                    System.out.printf("Введите имя: ");
                    name = in.next();
                    controller.viewHeirs(name, tree);
//                    Human nameLink = controller.//запрашиваем поиск ссылки по имени

                    break;

                default:
                    begin = false;
                    break;
            }
        }
        in.close();
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}