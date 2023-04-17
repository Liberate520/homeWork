package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Console implements View{
    private final Scanner scanner;
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
    public void start() throws IOException, ClassNotFoundException {
        while (work) {
            System.out.println("""
                    Список команд консоли:\s
                    1 - Добавить человека
                    2 - Просмотр всего дерева\s
                    3 - поиск записи по имени\s
                    4 - отсортировать по имени\s
                    5 - отсортировать по полу\s
                    6 - сохранить в файл\s
                    7 - загрузить из файла\s
                    8 - выход""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addHuman();
                case "2" -> viewAll();
                case "3" -> findByName();
                case "4" -> sortByName();
                case "5" -> sortBySex();
                case "6" -> save();
                case "7" -> load();
                case "8" -> exit();
                default -> System.out.println("Ошибка ввода");
            }
        }
    }
    private void addHuman(){
        System.out.println("Введите dateOfBirth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите dateOfDeath");
        String dateOfDeath = scanner.nextLine();
        System.out.println("Введите sex");
        String sex = scanner.nextLine();
        System.out.println("Введите firstName");
        String firstName = scanner.nextLine();
        System.out.println("Введите lastName");
        String lastName = scanner.nextLine();

        presenter.addHuman(dateOfBirth, dateOfDeath, sex, firstName, lastName);
    }
    private void viewAll() {
        presenter.getFamilyTree();
    }
    private void findByName(){
        System.out.println("Введите имя");
        String record = scanner.nextLine();
        presenter.findByName(record);
    }
    private void exit() {
        System.out.println("Работа завершена");
        work = false;
        scanner.close();
    }

    private void sortByName(){
        presenter.sortByName();
    }
    private void sortBySex(){
        presenter.sortBySex();
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    private void save() throws IOException {
        System.out.println("Введите имя файла или путь сохранения");
        String path = scanner.nextLine();
        presenter.save(path);
    }
    private void load() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла или путь загрузки");
        String path = scanner.nextLine();
        presenter.load(path);
    }
}
