package ru.gb.family_tree.view.console_ui;

import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.view.menus.EmptyTreeMenu;
import ru.gb.family_tree.view.menus.MainMenu;
import ru.gb.family_tree.view.menus.Menu;
import java.time.LocalDate;
import java.util.HashMap;

public class ConsoleUI implements View {
    Presenter presenter;
    private final Input input;
    private Menu previousMenu;
    private boolean work;

    public ConsoleUI() {
        work = true;
        input = new Input();
        presenter = new Presenter(this);
    }

    public Menu previousMenu() {
        return previousMenu;
    }

    private void clearConsole() {
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

    public void print(String data, Boolean clearConsole) {
        if (clearConsole) {
            clearConsole();
        }
        System.out.println(data);
    }

    @Override
    public void print(String data) {
        print(data, false);
    }

    @Override
    public void start() {
        while (work) {
            Menu currentMenu;
            previousMenu = null;
            if (presenter.getTreeSize() != 0) currentMenu = new MainMenu(this);
            else currentMenu = new EmptyTreeMenu(this);
            welcome();
            print(currentMenu.getMenu());
            Integer choice = input.getInt(
                    "Ввод",
                    String.format("^[1-%d]$", currentMenu.countItems()),
                    "Ошибка ввода. Данный пункт меню не найден");
            currentMenu.execute(choice - 1);
        }
    }

    public void addMember() {
        HashMap<String, String> data = new HashMap<>() {{
            put("surname", null);
            put("name", null);
            put("patronymic", null);
            put("gender", null);
            put("birthDate", null);
        }};
        String pattern;
        LocalDate birthDate;

        clearConsole();
        data.put("surname", input.getString(
                "Введите фамилию человека",
                "^[А-Я][а-я]*$",
                "Фамилия должна начинаться с заглавной буквы"));
        data.put("name", input.getString(
                "Введите имя человека",
                "^[А-Я][а-я]*$",
                "Имя должно начинаться с заглавной буквы"));
        data.put("patronymic", input.getString(
                "Введите отчество человека",
                "^[А-Я][а-я]*$",
                "Отчество должно начинаться с заглавной буквы"));
        data.put("gender", input.getString(
                "Введите пол человека",
                "^[МмЖж]$",
                "Ошибка ввода. Введите \"м\" или \"ж\""));
        while (true) {
            try {
                pattern = input.getString(
                        "Введите дату рождения человека в формате ГГГГ-ММ-ДД",
                        "^\\d{4}-\\d{2}-\\d{2}$",
                        "Ошибка ввода");
                birthDate = LocalDate.parse(pattern);
                break;
            } catch (Exception e) {
                print("Ошибка ввода. Данной даты не существует");
            }
        }
        data.put("birthDate", birthDate.toString());
        presenter.addMember(data);
    }

    public void welcome() {
        print("Главное меню");
    }

    public void getMembers() {
        presenter.getMembers();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void importTree() {
        presenter.importTree(input.getString("Введите имя файла для импорта"));
    }

    public void exportTree() {
        presenter.exportTree(input.getString("Введите имя файла для экспорта"));
    }

    public void back() {
        if (previousMenu == null) start();
        else print(previousMenu.getMenu());
    }

    public void finish() {
        print("Приятного дня!");
        work = false;
    }
}
