package view.console;

import presenter.Presenter;
import view.View;
import view.console.menus.ConsoleMenu;
import view.console.menus.mainMenu.MainMenu;

public class ConsoleUI implements View {
    private Presenter presenter = new Presenter(this);
    private ConsoleMenu mainMenu = new MainMenu(this);
    private boolean run = true;

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void showResult(String result) {
        print(result + "\n");
    }

    @Override
    public String input(String message) {
        print(message);
        String result = System.console().readLine().strip();
        return result;
    }

    @Override
    public void start() {
        int command;
        print("Приложение генеалогическое древо запущено\nКоманды:\n");
        print(mainMenu.getMenuInfo());
        while (run) {
            command = Integer.parseInt(input("Введите номер команды: "));
            mainMenu.executeCommand(command);
        }
    }

    public void loadTree() {
        String path = input("Введите путь: ");
        presenter.loadTree(path);
    }

    public void newTree() {
        presenter.newTree();
    }

    public void saveTree() {
        String path = input("Введите путь: ");
        presenter.saveTree(path);
    }

    public void sortByHierarchyLevel() {
        presenter.sortByHierarchyLevel();
    }

    public void printTree() {
        presenter.getTreeFullInfo();
    }

    public void addNewItemInTree() {
        String firstName = input("Введите имя: ");
        String midName = input("Введите фамилию: ");
        String lastName = input("Введите отчество: ");
        String gender = input("Введите пол (м/ж): ");
        presenter.addNewItemInTree(firstName, midName, lastName, gender);
    }

    public void setCurrentItemById() {
        int id = Integer.parseInt(input("Введите id: "));
        presenter.setCurrentItemById(id);
    }

    public void getCurrentItemFullInfo() {
        presenter.getCurrentItemFullInfo();
    }

    public void setBirthDateToCurrItem() {
        int day = Integer.parseInt(input("День: "));
        int month = Integer.parseInt(input("Месяц: "));
        int year = Integer.parseInt(input("Год: "));
        presenter.setBirthDateToCurrItem(day, month, year);
    }

    public void setDeathDateToCurrItem() {
        int day = Integer.parseInt(input("День: "));
        int month = Integer.parseInt(input("Месяц: "));
        int year = Integer.parseInt(input("Год: "));
        presenter.setDeathDateToCurrItem(day, month, year);
    }

    public void setParentToCurrItemById() {
        int id = Integer.parseInt(input("Введите id: "));
        presenter.setParentToCurrItemById(id);
    }

    public void addChildToCurrItemById() {
        int id = Integer.parseInt(input("Введите id: "));
        presenter.addChildToCurrItemById(id);
    }

    public void exit() {
        if (presenter.isSaved()) {
            run = false;
        }
        else {
            print("Древо не сохранено!\n");
        }
    }
}