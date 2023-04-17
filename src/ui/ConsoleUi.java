package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import human.Human;
import presenter.Presenter;
import tree.Tree;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean loop;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
    }

    private int scan() {
        int n = 0;
        while (n <= 0 || n > 8) {
            System.out.println(
                    "\nВведите цифру варианта действия над фамильным деревом:\n\n1. Найти человека по имени в фамильном дереве;"
                            +
                            "\n2. Отсортировать фамильное дерево по именам людей;\n3. Отсортировать фамильное дерево по году рождения людей;"
                            +
                            "\n4. Отсортировать фамильное дерево по количеству детей;\n5. Отсортировать фамильное дерево по порядку добавления людей;"
                            +
                            "\n6. Добавить человека в дерево;\n7. Показать фамильное дерево;\n8. Выход\n");
            n = scanner.nextInt();
        }
        String str = scanner.nextLine();
        return n;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws ClassNotFoundException, IOException {
        loop = true;
        while (loop) {
            int number = scan();
            switch (number) {
                case 1:
                    findname();
                    break;
                case 2:
                    sortbyname();
                    break;
                case 3:
                    sortbybirthyear();
                    break;
                case 4:
                    sortbychild();
                    break;
                case 5:
                    sortbyid();
                    break;
                case 6:
                    addbyhuman();
                    break;
                case 7:
                    showtree();
                    break;
                case 8:
                    exit();
                    break;
                default:
                    break;
            }
        }
    }

    private void findname() throws ClassNotFoundException, IOException {
        System.out.println("Введите имя человека: ");
        String str = scanner.nextLine();
        if (presenter.taskfind(str) == null)
            System.out.printf("Человека с именем %s в этом фамильном дереве нет.\n", str);
        else
            System.out.println(presenter.taskfind(str));
    }

    public void addbyhuman() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Сначала вводите родителей, потом детей.");
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();
        sb.append(name + " ");
        System.out.println("Введите пол: ");
        String gender = scanner.nextLine();
        sb.append(gender + " ");
        System.out.println("Введите год рождения: ");
        int birthyear = scanner.nextInt();
        sb.append(birthyear + " ");
        String sw = scanner.nextLine();
        System.out.println("Если Вы не знаете имени матери или отца, то введите 0: ");
        System.out.println("Введите имя матери: ");
        String mothername = scanner.nextLine();
        sb.append(mothername + " ");
        System.out.println("Введите имя отца: ");
        String fathername = scanner.nextLine();
        sb.append(fathername + " ");
        if(presenter.addh(sb.toString())){
            System.out.println("Человек успешно добавлен в дерево.");
        }
        else{
            System.out.println("Человек уже есть в дереве.");
        }
    }

    private void sortbyname() {
        presenter.sbyname();
    }

    private void sortbybirthyear() {
        presenter.sbyyear();
    }

    private void sortbychild() {
        presenter.sbychild();
    }

    public void sortbyid() {
        presenter.sbyid();
    }

    public void showtree() {
        presenter.showt();
    }

    private void exit() throws FileNotFoundException, IOException {
        System.out.println("Завершение работы");
        presenter.savefile();
        loop = false;
    }

    @Override
    public void print(Tree<Human> answer) {
        for (Human human : answer) {
            System.out.println(human);
        }
    }
}
