package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Menu menu;
    private Scanner scanner;
    private boolean working;

    public ConsoleUI() {
        this.menu = new Menu(this);
        this.scanner = new Scanner(System.in);
        this.working = true;
    }

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

    public void end() {
        this.working = false;
    }

    public void showAll() {
        presenter.showAll();
    }

    public void addRec() {
        System.out.println("введите текст");
        String text = inputParam();
        System.out.println("введите срок");
        String deadline = inputParam();
        presenter.addRec(text, deadline);
    }

    public void delRec() {
        presenter.showAll();
        System.out.println("введите номер записи (0 -> выход)");
        String id = inputParam();
        if (!id.equals("0"))
            try {
                presenter.delRec(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                System.out.println("нужно ввести число");
            }
    }

    public void load() {
        presenter.load();
    }
    public void save() {
        presenter.save();
    }

    private String inputParam() {
        while (!scanner.hasNext()) scanner.next();
        return scanner.nextLine();
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
