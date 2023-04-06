package ui;

import java.io.IOException;
import java.util.Scanner;

import presenter.Presenter;
import tree.Tree;

public class ConsoleUi<E> implements View<E> {
    private Scanner scanner;
    private Presenter<E> presenter;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
    }

    private int scan() {
        int n = 0;
        while (n <= 0 || n > 6) {
            System.out.println(
                    "\nВведите цифру варианта действия над фамильным деревом:\n\n1. Найти человека по имени в фамильном дереве;\n2. Отсортировать фамильное дерево по именам людей;\n3. Отсортировать фамильное дерево по году рождения людей;\n4. Отсортировать фамильное дерево по количеству детей;\n5. Отсортировать фамильное дерево по порядку добавления людей;\n6. Выход.\n");
            n = scanner.nextInt();
        }
        return n;
    }

    @Override
    public void setPresenter(Presenter<E> presenter) {
        this.presenter = presenter;
    }

    @Override
    public int start() throws ClassNotFoundException, IOException {
        int number = scan();
        String str = scanner.nextLine();
        if (number == 1) {
            System.out.println("Введите имя человека: ");
            str = scanner.nextLine();
            presenter.task(number, str);
        } else {
            if (number != 6) {
                print(presenter.task(number, str));
            }
        }
        return number;
    }

    @Override
    public void print(Tree<E> answer) {
        for (E human : answer) {
            System.out.println(human);
        }
    }
}
