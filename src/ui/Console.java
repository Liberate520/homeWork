package ui;

import model.family.Family;
import model.human.Human;
import presenter.Presenter;
import ui.menu.FamilyMenu;
import ui.menu.MainMenu;
import ui.menu.Menu;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Console implements UI{
    private static final String GREETING = "Hello.";
    private static final String FAREWELL = "Have a nice day.";
    private static final String WRONGCHOICE = "Такого пункта нет, попробуйте ещё раз.";
    private static final String NODATA = "Нет данных";
    private static final String DEFAULTPATH = String.join(File.separator, Arrays.asList("data", "saved.bin"));
    private String lastFilePath;
    private Scanner scanner;
    private Presenter presenter;
    private boolean active;

    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        active = false;
        lastFilePath = DEFAULTPATH;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        active = true;
        print(GREETING);
        enterMainMenu();
        finish();
    }

    @Override
    public void finish() {
        active = false;
        print(FAREWELL);
    }

    private void enterMainMenu() {
        Menu mainMenu = new MainMenu(this);
        enterMenu(mainMenu);
    }
    private void enterMenu(Menu menu) {
        menu.setActive();
        while (active && menu.isActive()) {
            printMenu(menu);
            userInteract(menu);
        }
    }

    private void printMenu(Menu menu){
        print(menu.buildMenu());
    }

    private void userInteract(Menu menu) {
        String userInput = scanner.nextLine();
        int choice = parseInput(userInput, menu);
        if (choice != -1) {
            menu.exec(choice);
        } else {
            inputError();
        }
    }

    private int parseInput(String input, Menu menu) {
        if (input.matches("^\\d+$")) {
            int numInput = Integer.parseInt(input);
            if (numInput > 0 && numInput <= menu.size()) return numInput;
        }
        return -1;
    }

    private void inputError(){
        print(WRONGCHOICE);
    }

    public String noData(){
        return NODATA;
    }

    public void showFamilyTrees() {
        presenter.showFamilyTrees();
    }
    public void listFamilies() {
        presenter.listFamilies();
    }
    public void addFamily() {
        print("Введите имя новой семьи");
        String name = scanner.nextLine();
        presenter.addFamily(name);
    }
    public void gotoFamily() {
        print("Введите имя семьи для поиска");
        String name = scanner.nextLine();
        Family<Human> family = presenter.getFamily(name);
        if (family == null) print("Семья с таким именем не найдена");
        else {
            Menu familyMenu = new FamilyMenu(this, family);
            enterMenu(familyMenu);
        }
    }

    public void saveToFile() {
        print(String.format("Рекомендуемый путь '%s'", lastFilePath));
        print("Введите путь для сохранения файла");
        print("Или пустую строку для использования рекомендованного пути");
        String path = scanner.nextLine();
        if (path.isEmpty()) path = lastFilePath;
        presenter.saveToFile(path);
    }
    public void loadFromFile() {
        print(String.format("Рекомендуемый путь '%s'", lastFilePath));
        print("Введите путь до файла для загрузки");
        print("Или пустую строку для использования рекомендованного пути");
        String path = scanner.nextLine();
        if (path.isEmpty()) path = lastFilePath;
        presenter.loadFromFile(path);
    }
    public void showPeopleFromFamily(Family<Human> family) {
        presenter.listPeopleFromFamily(family);
    }
    private boolean isDateFormatValid(String dateString) {
        return dateString.matches("^\\d{4}-\\d{2}-\\d{2}$") || dateString.isEmpty();
    }
    public void addHumanToFamily(Family<Human> family) {
        print("Введите имя человека");
        String name = scanner.nextLine();
        List<String> genderNames = presenter.getGenderNames();
        print(String.format("Введите пол человека %s", genderNames.toString()));
        String genderName = scanner.nextLine();
        if (!genderNames.contains(genderName)){
            print("Неизвестный пол");
            return;
        }
        print("Введите дату рождения человека в формате 'YYYY-MM-DD'");
        print("Или пустую строку, если дата неизвестна");
        String birthDateString = scanner.nextLine();
        if (!isDateFormatValid(birthDateString)){
            print("Неизвестный формат даты");
            return;
        }
        print("Введите дату смерти человека в формате 'YYYY-MM-DD'");
        print("Или пустую строку, если дата неизвестна");
        String deathDateString = scanner.nextLine();
        if (!isDateFormatValid(deathDateString)){
            print("Неизвестный формат даты");
            return;
        }
        presenter.addHuman(family, name, genderName, birthDateString, deathDateString);
    }
    public void addConnection(Family<Human> family) {
        print("Введите имя первого человека");
        String firstName = scanner.nextLine();
        Human firstHuman = presenter.searchHumanByNameInFamily(firstName, family);
        if (firstHuman == null) {
            print("Человек с таким именем не найден в текущей семье");
            return;
        }
        print("Введите имя второго человека");
        String secondName = scanner.nextLine();
        Human secondHuman = presenter.searchHumanByNameInFamily(secondName, family);
        if (secondHuman == null) {
            print("Человек с таким именем не найден в текущей семье");
            return;
        }
        List<String> connectionNames = presenter.getConnectionNames();
        print(String.format("Введите название связи %s", connectionNames.toString()));
        String connectionName = scanner.nextLine();
        if (!connectionNames.contains(connectionName)){
            print("Неизвестный название связи");
            return;
        }
        presenter.addConnection(firstHuman, connectionName, secondHuman);
    }
}
