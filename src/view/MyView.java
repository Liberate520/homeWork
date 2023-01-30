package view;
import presenter.Presenter;

import java.util.Scanner;

public class MyView implements View {
    private Presenter presenter;
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
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
                presenter.printElement(scanner.nextLine());
                System.out.println();
            }
            else if (command == 5) presenter.printTree();
            else if (command == 9) break;
        }
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
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
        presenter.newTree();
    }
//    private void addElement(TreeElement treeElement){
//        presenter.addElement(treeElement);
//    }
//    private void addConnection(String name1, String name2, FamilyConnectionType type) {
//        presenter.addConnection(name1, name2, type);
//    }
//    private void printElement(String name) {
//        presenter.printElement(name);
//    }
//    private void printTree(){
//        presenter.printTree();
//    }
}
