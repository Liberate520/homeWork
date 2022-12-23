package view;

import controller.TreeControl;
import model.Human;
import model.Tree;

import java.util.Scanner;

public class Menu implements UIInterface {

    private TreeControl controller;
    private Tree tree;

    private Scanner in;

    public Menu(TreeControl controller) {
        this.controller = controller;
    }

    public void runMenu() {
        in = new Scanner(System.in);
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
                    addToTree();
                    break;

                case "2":
                    System.out.println(tree.getHumanList());
                    break;

                case "3":
                    System.out.printf("Введите имя: ");
                    name = in.next();
                    try {
                        controller.viewHeirs(name, tree);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }


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

    // на данном примере мы обязуем любой UI меню иметь метод addToTree
    @Override
    public void addToTree() {

        System.out.printf("Введите имя: ");
        String name = in.next();
        System.out.printf("Введите цифру гендера (0 = жен, 1 = муж): ");
        int gender = in.nextInt();
        controller.addToTree(controller.createHuman(name, gender), tree);
        System.out.println("Член семьи создан и сохранён в дереве");

    }
}