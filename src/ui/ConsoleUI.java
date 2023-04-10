package ui;
import java.io.IOException;
import java.util.Scanner;

import human.Human;
import io.DataLoad;
import io.DataSave;
import io.FileHandlerLoad;
import io.FileHandlerSaver;
import presenter.Presenter;
import tree.FindScanner;


public class ConsoleUI<T> implements View<T> {
    private Scanner scanner;
    private Presenter presenter;

    public static boolean work = true;

    public ConsoleUI() {
        scanner = new Scanner(System.in, "Cp866");
    }

    private int readChoice() {
        int number = 0;
        while (number <= 0 || number > 7) {
            System.out.println(
                    "\nВведите номер действия:\n" + "1. Вывести фамильное дерево\n" +
                            "2. Найти человека по имени\n" +
                            "3. Отсортировать фамильное дерево по имени\n" +
                            "4. Отсортировать фамильное дерево по дате смерти\n" +
                            "5. Сохранить файл\n" + "6. Загрузить файл\n" +
                            "7. Выход\n");
            System.out.printf("Ожидание выбора: ");
            number = scanner.nextInt();
        }
        return number;
    }

    public void exit() {
        System.out.println("Работа завершена");
        scanner.close();
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(T t) {
        System.out.println(t);
    }

    @Override
    public T start(T t) throws ClassNotFoundException, IOException {

        while (work) {
            int choice = readChoice();

            switch (choice) {
                case 1:
                    presenter.printTree(t);
                    break;
                case 2:
                    presenter.findHuman(t);
                    break;
                case 3:
                    presenter.sortByName(t);
                    break;
                case 4:
                    presenter.sortByDate(t);
                    break;
                case 5:
                    DataSave save = new FileHandlerSaver<>();
                    save.saveData(t);
                    break;
                case 6:
                    DataLoad load = new FileHandlerLoad();
                    load.loadData("familyTree.ser");
                    break;
                case 7:
                    exit();
                    break;
                default:
                    break;
            }

        }
        return null;
    }
}



