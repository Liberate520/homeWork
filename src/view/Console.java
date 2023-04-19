package view;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements iView {
    private Scanner scanner;
    private Presenter presenter;

    private AddPerson addPerson;
    private ViewAll viewAll;
    private SearchPerson searchPerson;
    private CloseConsole closeConsole;

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
            System.out.println("1 - Добавить новую запись\n" +
                    "2 - Вывести все на экран\n" +
                    "3 - Найти человека\n" +
                    "4 - Загрузить дерево\n" +
                    "5 - Сохранить дерево\n" +
                    "6 - Завершить работу\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addPerson = new AddPerson(presenter);
                    addPerson.addPerson();
                    break;
                case "2":
                    viewAll = new ViewAll(presenter);
                    viewAll.viewAll();
                    break;
                case "3":
                    searchPerson = new SearchPerson(presenter);
                    searchPerson.searchPerson();
                    break;
                case "4":
                    presenter.loadTree();
                    break;
                case "5":
                    presenter.saveTree();
                    break;
                case "6":
                    closeConsole = new CloseConsole();
                    work = closeConsole.exit();
                    scanner.close();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

}
