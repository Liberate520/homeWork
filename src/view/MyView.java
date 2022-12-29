package view;
import controller.MyController;
import model.FamilyConnectionType;
import model.GenealogicalTree;
import model.Tree;
import model.TreeElement;

import java.util.Scanner;

public class MyView {
    private GenealogicalTree<TreeElement> tree;
    private MyController myController = new MyController(tree);

    public void start() {
        Scanner scanner = new Scanner(System.in);
        newTree();
        startPrint();
        while (true) {
            int command = scanner.nextInt();
            if (command == 0) startPrint();
            else if (command == 1) newTree();
//            else if (command == 2) {
//                addElement();
//            }
//            else if (command == 3) {
//                addConnection();
//            }
            else if (command == 4) {
                System.out.print("Введите имя: ");
                printElement(scanner.nextLine());
                System.out.println();
            }
            else if (command == 5) printTree();
            else if (command == 9) break;
        }
    }

    private void startPrint(){
        System.out.println("Введите нужное число для выполнения команды:");
        System.out.println("1 - Начать работу с новым генеологическим древом");
//        System.out.println("2 - Добавить элемент в древо");
//        System.out.println("3 - Добавить отношение между элементами в древе");
        System.out.println("4 - Найти и вывести элемент по имени");
        System.out.println("5 - Вывести всё древо");
        System.out.println("9 - Выхода");
        System.out.println("0 - Показать команды");
    }

    private void newTree(){
        myController.newTree();
    }
    private void addElement(TreeElement treeElement){
        myController.addElement(treeElement);
    }
    private void addConnection(String name1, String name2, FamilyConnectionType type) {
        myController.addConnection(name1, name2, type);
    }
    private void printElement(String name) {
        myController.printElement(name);
    }
    private void printTree(){
        myController.printTree();
    }
}