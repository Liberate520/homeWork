package view;

import presenter.Presenter;
import java.util.Scanner;



public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;

    public Console() {
        scanner = new Scanner(System.in, "cp866");

    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println("\n1 - Загрузить все записи\n" +
                    "2 - Распечатать все записи\n" +
                    "3 - Добавить новую запись\n" +
                    "4 - Отсортировать записи по имени\n" +
                    "5 - Наити запись по имени\n" +
                    "6 - Сохрянить все записи в файл\n" +
                    "7 - завершить работу.");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    loadAllRecords();
                    break;
                case "2":
                    getAllRecord();
                    break;
                case "3":
                    addRecord();
                    break;
                case "4":
                    sortRecordsByName();
                    break;
                case "5":
                    findRecord();
                    break;
                case "6":
                    saveAllRecords();
                    break;
                case "7":
                    exit();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    private void addRecord() {
        System.out.println("Введите имя и фамилию.");
        String name = scanner.nextLine();
        presenter.addRecord(name);
    }

    private void findRecord() {
        System.out.println("Введите имя и фамилию.");
        String name = scanner.nextLine();
        presenter.findRecord(name);
    }

    private void loadAllRecords() {
        presenter.loadRecords();
    }

    private void getAllRecord() {
        presenter.getRecords();
    }

    private void sortRecordsByName() {
        presenter.sortRecordsByName();
    }

    private void saveAllRecords() {
        presenter.saveRecords();
    }

    private void exit() {
        System.out.println("Работа завершена");
        scanner.close();
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
