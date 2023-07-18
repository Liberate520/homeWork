package view.console;

import presenter.Presenter;
import view.View;

public class ConsoleUI implements View {
    private Presenter presenter = new Presenter(this);
    private MainMenu mainMenu = new MainMenu(this);
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
        print(mainMenu.getMenu());
        while (run) {
            command = Integer.parseInt(input("Введите номер команды: "));
            mainMenu.execute(command);
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

    public void addNewHumanInTree() {
        String firstName = input("Введите имя: ");
        String midName = input("Введите фамилию: ");
        String lastName = input("Введите отчество: ");
        String gender = input("Введите пол (м/ж): ");
        presenter.addNewHumanInTree(firstName, midName, lastName, gender);
    }

    public void setCurrentHumanById() {
        int id = Integer.parseInt(input("Введите id: "));
        presenter.setCurrentHumanById(id);
    }

    public void getCurrentHumanFullInfo() {
        presenter.getCurrentHumanFullInfo();
    }

    public void setBirthDateToCurrHuman() {
        int day = Integer.parseInt(input("День: "));
        int month = Integer.parseInt(input("Месяц: "));
        int year = Integer.parseInt(input("Год: "));
        presenter.setBirthDateToCurrHuman(day, month, year);
    }

    public void setDeathDateToCurrHuman() {
        int day = Integer.parseInt(input("День: "));
        int month = Integer.parseInt(input("Месяц: "));
        int year = Integer.parseInt(input("Год: "));
        presenter.setDeathDateToCurrHuman(day, month, year);
    }

    public void setParentToCurrHumanById() {
        int id = Integer.parseInt(input("Введите id: "));
        presenter.setParentToCurrHumanById(id);
    }

    public void addChildToCurrHumanById() {
        int id = Integer.parseInt(input("Введите id: "));
        presenter.addChildToCurrHumanById(id);
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