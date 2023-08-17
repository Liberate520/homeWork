package family_tree.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import family_tree.presenter.Presenter;
import family_tree.view.menu.MainMenu;
import family_tree.view.menu.Menu;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private int countMenu;
    private boolean work;
    private Menu mainMenu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.mainMenu = new MainMenu(this);
        this.work = true;
        this.countMenu = 0;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        menu(mainMenu);
    }

    public void menu(Menu menu) {
        countMenu++;
        while (work) {
            printMenu(menu);
            execute(menu);
        }
        countMenu--;
        if (countMenu != 0) {
            work = true;
        }
    }

    public void finish() {
        System.out.println("Всего доброго!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortBySurname() {
        presenter.sortBySurname();
    }

    public void sortByPatronymic() {
        presenter.sortByPatronymic();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void addHuman(String gender) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Укажите фамилию: ");
        String surName = scanner.nextLine();
        System.out.print("Укажите отчество: ");
        String patronymic = scanner.nextLine();
        presenter.addHuman(name, surName, patronymic, gender,
                getDate("Укажите дату рождения \"год-месяц-день\": ", false),
                getDate("Укажите дату смерти \"год-месяц-день\": ", true));
    }

    private int getNumber() {
        int chois = -1;
        boolean flag = true;
        while (flag) {
            String temp = scanner.nextLine();
            if (checkTextForInt(temp)) {
                chois = Integer.parseInt(temp);
                flag = false;
            }
        }
        return chois;
    }

    private String getDate(String text, boolean check) {
        String date = new String();
        boolean flag = true;
        while (flag) {
            System.out.print(text);
            date = scanner.nextLine();
            if (date.length() == 0 && check) {
                return null;
            }
            if (checkDate(date)) {
                flag = false;
            }
        }
        return date;
    }

    private boolean checkDate(String data) {
        Pattern pattern = Pattern.compile("(\\d{4})[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private void hello() {
        System.out.println("Добро пожаловать в семейное дерево!");
    }

    private void execute(Menu menu) {
        String line = scanner.nextLine();
        System.out.println();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize() && numCommand > 0) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public void addKinship(String kinship) {
        System.out.print("Введите id человека: ");
        int idHuman = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите id родственника: ");
        int idKinshipHuman = Integer.parseInt(scanner.nextLine());
        presenter.addKinship(idHuman, idKinshipHuman, kinship);
    }

    public void showSibling() {    
        System.out.print("Укажите id: ");
        int id = getNumber();
        presenter.getSibling(id);
    }

    public void showParents() {
        System.out.print("Укажите id: ");
        int id = getNumber();
        presenter.getParents(id);
    }

    public void showChildren() {
        System.out.print("Укажите id: ");
        int id = getNumber();
        presenter.getChildren(id);
    }

    public void fileSave() {
        presenter.fileSave();
    }

    public void fileRead() {
        presenter.fileRead();
    }

    public void remove() {
        System.out.print("Укажите id: ");
        int id = getNumber();
        presenter.remove(id);
    }

    public void back() {
        work = false;
    }

}
