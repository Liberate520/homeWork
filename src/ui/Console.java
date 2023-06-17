package ui;

import presenter.Presenter;
import ui.menu.FamilyMenu;
import ui.menu.MainMenu;
import ui.menu.Menu;

import java.util.List;
import java.util.Scanner;

public class Console implements UI{
    private static final String GREETING = "Hello.";
    private static final String FAREWELL = "Have a nice day.";
    private static final String WRONGCHOICE = "Такого пункта нет, попробуйте ещё раз.";
    private static final String NODATA = "Нет данных";
    private Scanner scanner;
    private Presenter presenter;
    private boolean active;

    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        active = false;
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
            print(WRONGCHOICE);
        }
    }

    private int parseInput(String input, Menu menu) {
        if (input.matches("^\\d+$")) {
            int numInput = Integer.parseInt(input);
            if (numInput > 0 && numInput <= menu.size()) return numInput;
        }
        return -1;
    }

    public String noData(){
        return NODATA;
    } // TODO: mv messages to other class and this become view.messages().NODATA

    public void showFamilyTrees() {
        presenter.showFamilyTreeStr();
    }
    public void listFamilies() {
        presenter.listFamilies();
    }
    public void addFamily() {
        print("Введите имя новой семьи");
        String name = scanner.nextLine();
        if (presenter.addFamily(name)) print(String.format("Семья '%s' создана\n", name));
        else print("Семья с таким именем уже существует");
    }
    public void gotoFamily() {
        print("Введите имя семьи для поиска");
        String name = scanner.nextLine();
        String familyID = presenter.searchFamily(name);
        if (familyID == null) print("Семья с таким именем не найдена");
        else {
            Menu familyMenu = new FamilyMenu(this, familyID);
            enterMenu(familyMenu);
        }
    }

    public void saveToFile() {
        String lastFilePath = presenter.getLastFilepath();
        print(String.format("Рекомендуемый путь '%s'", lastFilePath));
        print("Введите путь для сохранения файла");
        print("Или пустую строку для использования рекомендованного пути");
        String path = scanner.nextLine();
        if (presenter.saveToFile(path)) print("Успешное сохранение файла");
        else print("Ошибка при сохранении файла, проверьте логи приложения для подробностей");
    }
    public void loadFromFile() {
        String lastFilePath = presenter.getLastFilepath();
        print(String.format("Рекомендуемый путь '%s'", lastFilePath));
        print("Введите путь до файла для загрузки");
        print("Или пустую строку для использования рекомендованного пути");
        String path = scanner.nextLine();
        if (path.isEmpty()) path = lastFilePath;
        if (presenter.loadFromFile(path)) print("Успешная загрузка файла");
        else print("Ошибка при загрузке файла, проверьте логи приложения для подробностей");
    }
    public void showPeopleFromFamily(String familyID) {
        presenter.showPeopleFromFamily(familyID);
    }
    private boolean isDateFormatValid(String dateString) {
        return dateString.matches("^\\d{4}-\\d{2}-\\d{2}$") || dateString.isEmpty();
    }
    public void addHumanToFamily(String familyID) {
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
        if (presenter.addHuman(familyID, name, genderName, birthDateString, deathDateString))
            print("Человек добавлен");
        else print("Человек с таким именем уже существует в этой семье");
    }
    public void addConnection(String familyID) {
        print("Введите имя первого человека");
        String firstName = scanner.nextLine();
        String firstHuman = presenter.searchHumanInFamily(familyID, firstName);
        if (firstHuman == null) {
            print("Человек с таким именем не найден в текущей семье");
            return;
        }
        print("Введите имя второго человека");
        String secondName = scanner.nextLine();
        String secondHuman = presenter.searchHuman(secondName);
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
        if (presenter.addConnection(firstHuman, connectionName, secondHuman)) print("Связь создана");
        else print("Не удалось создать связь");
    }
}
