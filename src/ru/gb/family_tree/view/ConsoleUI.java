package ru.gb.family_tree.view;

import ru.gb.family_tree.model.saveload.FileHandler;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.menus.EmptyTreeMenu;
import ru.gb.family_tree.view.menus.MainMenu;
import ru.gb.family_tree.view.menus.Menu;

public class ConsoleUI implements View {
    Presenter presenter;
    private Menu currentMenu;
    private Menu previousMenu;
    private Input input;
    private FileHandler fileHandler;

    public ConsoleUI() {
        input = new Input();
        presenter = new Presenter(this);
        if (presenter.autoimport()) currentMenu = new MainMenu(this);
        else currentMenu = new EmptyTreeMenu(this);
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при очистке консоли: " + e.getMessage());
        }
    }

    private void getFileHandler(String fileName) {
        //TODO получение корректного имени файла
        //TODO проверка на существование файла
        try {
            fileHandler = new FileHandler(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Menu previousMenu() {
        return previousMenu;
    }

    public void print(String data, Boolean clearConsole) {
        if (clearConsole) { clearConsole(); }
        System.out.println(data);
    }

    @Override
    public void print(String data) { print(data, false); }

    @Override
    public void start() {
        previousMenu = null;
        if (presenter.getTreeSize() != 0) currentMenu = new MainMenu(this);
        else currentMenu = new EmptyTreeMenu(this);
        print("Главное меню");
        print(currentMenu.getMenu());
        System.out.print("Ввод: ");
        Integer choise = input.getInt(String.format("^[1-%d]$", currentMenu.countItems()), "Ошибка ввода. Данный пункт меню не найден");
        currentMenu.execute(choise - 1);
    }

    public void addMember() {
        //TODO добавление члена в дерево
    }

    public void getMembers() { presenter.getMembers(); }
    public void sortByName() { presenter.sortByName(); }
    public void sortByBirthDate() { presenter.sortByBirthDate(); }
    public void importFromObjectFile() { presenter.importFromObjectFile(); }
    public void back() { presenter.back(); }
    public void finish() { print("Приятного дня!"); }
}
