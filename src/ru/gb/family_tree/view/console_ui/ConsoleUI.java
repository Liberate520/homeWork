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
            System.out.print("Ввод: ");
            Integer choise = input.getInt(String.format("^[1-%d]$", currentMenu.countItems()),
                    "Ошибка ввода. Данный пункт меню не найден");
            currentMenu.execute(choise - 1);
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

        print("Введите фамилию человека", true);
        data.put("surname", input.getString("^[А-Я][а-я]*$",
                "Фамилия должна начинаться с заглавной буквы"));
        print("Введите имя человека");
        data.put("name", input.getString("^[А-Я][а-я]*$",
                "Имя должно начинаться с заглавной буквы"));
        print("Введите отчество человека");
        data.put("patronymic", input.getString("^[А-Я][а-я]*$",
                "Отчество должно начинаться с заглавной буквы"));
        print("Введите пол человека");
        data.put("gender", input.getString("^[МмЖж]$", "Ошибка ввода. Введите \"м\" или \"ж\""));
        print("Введите дату рождения человека в формате ГГГГ-ММ-ДД");
        while (true) {
            try {
                pattern = input.getString("^\\d{4}-\\d{2}-\\d{2}$",
                        "Ошибка ввода. Пожалуйста, введите дату согласно формату");
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

    public void importFromObjectFile() {
        print("Введите имя файла для импорта");
        presenter.importFromObjectFile(input.getString());
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
