package ui;

import java.io.IOException;
import java.util.Scanner;

import human.Human;
import presenter.Presenter;
import tree.Tree;

public class ConsoleUi<E> implements View<E> {
    private Scanner scanner;
    private Presenter<E> presenter;
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
                            "\n6. Добавить человека в дерево;\n7. Выход\n");
            n = scanner.nextInt();
        }
        String str = scanner.nextLine();
        return n;
    }

    @Override
    public void setPresenter(Presenter<E> presenter) {
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
        E human = presenter.taskfind(str);
        if (human == null)
            System.out.printf("Человека с именем %s в этом фамильном дереве нет.\n", str);
        else
            System.out.println(human);
    }

    private void addbyhuman() throws ClassNotFoundException, IOException {
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол: ");
        String gender = scanner.nextLine();
        System.out.println("Введите год рождения: ");
        int birthyear = scanner.nextInt();
        E human = (E) new Human(name, gender, birthyear);
        String str = scanner.nextLine();
        System.out.println("Введите имя матери: ");
        String mothername = scanner.nextLine();
        E motherh = presenter.taskfind(mothername);
        if ((motherh == null) && (!mothername.equals(""))) {
            addbyhuman();
        }
        System.out.println("Введите имя отца: ");
        String fathername = scanner.nextLine();
        E fatherh = presenter.taskfind(fathername);
        if ((fatherh == null) && (!fathername.equals(""))) {
            addbyhuman();
        }
        motherh = presenter.taskfind(mothername);
        fatherh = presenter.taskfind(fathername);
        presenter.addh(human, motherh, fatherh);
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

    private void exit() {
        System.out.println("Завершение работы");
        loop = false;
    }

    @Override
    public void print(Tree<E> answer) {
        for (E human : answer) {
            System.out.println(human);
        }
    }
}
