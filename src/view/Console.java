package view;

import model.Human;
import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean inProgress = true;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println();
        System.out.println("Введите соответствующую цифру:\n" +
        " 1 - для печати полного списка древа с указанием детей\n" +
        " 2 - для записи и сохранения в файл списка родственников древа \n" +
        " 3 - для чтения и вывода списка родственников из файла \n" +
        " 4 - для сортировки списка родственников по выбранному параметру \n" +
        " 5 - для ввода данных и добавления родственника в список древа \n" +
        " 6 - для поиска в древе родственника по имени \n" +
        " 0 - для завершения работы \n");
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        printMenu();
        while (inProgress) {
            int operationNumber = scanner.nextInt();
            switch (operationNumber) {
                case 0:
                    System.out.println("Работа завершена");
                    scanner.close();
                    inProgress = false;
                    break;
                case 1:
                    presenter.printChildren();
                    printMenu();
                    break;
                case 2:
                    presenter.writeInFile();
                    System.out.println("Вы успешно сохранили список генеалогического древа");
                    printMenu();
                    break;
                case 3:
                    System.out.println("Генеалогическое древо, прочитанное из файла:");
                    presenter.readFromFile();
                    presenter.print();
                    printMenu();
                    break;
                case 4:
                    System.out.println("Для сортировки по имени введите цифру 1:\n" +
                            "для сортировки по году рождения введите цифру 2: \n");
                    try {
                        int sortNumber = scanner.nextInt();
                        presenter.sortByParameter(sortNumber);
                        printMenu();
                    } catch (Exception e) {
                        System.out.println("Ошибка ввода! " + e);
                    }
                    break;
                case 5:
                    Human human = presenter.CreateHuman();
                    presenter.addHuman(human);
                    printMenu();
                    break;
                case 6:
                    presenter.getHumanByName();
                    printMenu();
                    break;
                default:
                    System.out.println("Вы ввели некорректный номер операции!");
                    printMenu();
            }
        }
        
    }

    private void exit() {
        System.out.println("Работа завершена, всего доброго!");
        scanner.close();
        inProgress = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}