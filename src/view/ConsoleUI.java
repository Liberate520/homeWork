package view;

import presenter.Presenter;

import java.util.Date;
import java.util.Scanner;

public class ConsoleUI extends Logger implements View {

    // ПОЛЯ КЛАССА PRESENTER
    private Presenter presenter;
    private final Menu menu;
    private final Scanner scanner;
    private boolean working;

    Date date = new Date();

    // КОНСТРУКТОР КЛАССА PRESENTER
    public ConsoleUI() {
        this.menu = new Menu(this);
        this.scanner = new Scanner(System.in);
        this.working = true;
    }

    // МЕТОДЫ КЛАССА PRESENTER

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (this.working) {
            System.out.println(menu.printMenu());
            String key = inputParam();
            menu.execute(key);
        }
    }
    public void showAll() {
        presenter.showAll();
    }

    public void addRec() {
        System.out.println("Добавьте задачу в ежедневник: ");
        String text = inputParam();

        System.out.println("Дедлайн: ");
        String deadline = inputParam();

        System.out.println("Примечания: ");
        String notes = inputParam();

        presenter.addRec(text, deadline, notes);
        System.out.println("\nЗадача добавлена в ежедневник.");
    }

    public void delRec() {
        presenter.showAll();
        System.out.println("Укажите номер записи, которую нужно удалить: ");
        String id = inputParam();
        log_file(log_string.append("Запись № ").append(id).append(" удалена. ").append(date.toString()).append("\n"));
        if (!id.equals("0"))
            try {
                presenter.delRec(Integer.parseInt(id));
                System.out.println("Запись удалена.");
            } catch (NumberFormatException e) {
                System.out.println("Укажите корректный номер записи, которую нужно удалить: ");
            }
    }


    public void changeRec(){
        presenter.showAll();
        System.out.println("Укажите номер записи, которую нужно изменить: ");
        String id = inputParam();
        if (!id.equals("0"))
            try {

                System.out.println("Укажите новую задачу: ");
                String text = inputParam();

                System.out.println("Уточните дедлайн: ");
                String deadline = inputParam();

                System.out.println("Добавьте примечания: ");
                String notes = inputParam();

                presenter.changeRec(Integer.parseInt(id), text, deadline, notes);
                System.out.println("\nЗадача изменена и добавлена в ежедневник.");


            } catch (NumberFormatException e) {
                System.out.println("Укажите корректный номер записи, которую нужно изменить: ");
            }
    }

    public void load() {
        presenter.load();
        System.out.println("\nИзменения добавлены в файл.");
    }
    public void save() {
        presenter.save();
        System.out.println("\nИзменения в файле сохранены.");
    }

    private String inputParam() {
        while (!scanner.hasNext()) scanner.next();
        return scanner.nextLine();
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    public void end() {
        System.out.println("\nВсего доброго!");
        this.working = false;
    }
}