package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleUI implements View{
    private Presenter presenter;
    private MainMenu mainMenu;
    private Scanner scanner;
    private boolean run;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.run = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        this.hello();
        while (run) {
            this.printMenu();
            this.execute();
        }
    }

    private void hello() {
        this.print("Добро пожаловать в Фамильное Древо!");
        this.print("************************************");
        this.print("");
        this.print("Вы можете наполнить древо вручную или загрузить" + "\n" +
                "из файла MyFamilyTree.sfmt, прилагаемого к проекту." + "\n");
    }

    private void execute() throws IOException, ClassNotFoundException {
        System.out.print("Введите номер команды> ");
        String userInput = scanner.nextLine();
        if (checkTextForInt(userInput)){
            int numCommand = Integer.parseInt(userInput);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            this.print("Введено некорректное значение.");
            return false;
        }
    }

    private boolean checkTextForRelation(String text){
        Set<String> relations = new HashSet<>(Arrays.asList("м", "о", "сп", "б", "ст", "сн", "д"));
        if (relations.contains(text)){
            return true;
        } else {
            this.print("Введено некорректное значение.");
            return false;
        }
    }

    private boolean checkTextForGender(String text){
        Set<String> relations = new HashSet<>(Arrays.asList("м", "ж"));
        if (relations.contains(text)){
            return true;
        } else {
            this.print("Введено некорректное значение.");
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            this.print("Введено некорректное значение.");
            return false;
        }
    }

    @Override
    public void printMenu() {
        this.print(mainMenu.print());
    }

    @Override
    public void exit() {
        run = false;
        System.out.println("Завершение работы.");
    }

    @Override
    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    @Override
    public void printSortByAge() {
        presenter.printSortByAge();
    }

    @Override
    public void printSortByFirstName() {
        presenter.printSortByFirstName();
    }

    @Override
    public void printSortByLastName() {
        presenter.printSortByLastName();
    }

    @Override
    public void addNewPerson() {
        this.print("Собираем информацию о новой персоне...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        int age = this.inputInt("Введите возраст: ");
        String gender = this.inputString("Введите пол (м/ж): ");
        presenter.addPerson(firstName, lastName, age, gender);
        this.print("Персона добавлена в дерево.");
    }

    @Override
    public void addNewPersonAs() {
        this.print("Собираем информацию о новой персоне...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        int age = this.inputInt("Введите возраст: ");
        boolean runCheck = true;
        String gender = "м";
        while (runCheck) {
            gender = this.inputString("Введите пол (м/ж): ");
            if (this.checkTextForGender(gender)) {
                runCheck = false;
            }
        }
        this.print("Кому приходится родней...");
        String targetFirstName = this.inputString("Введите имя: ");
        String targetLastName = this.inputString("Введите фамилию: ");
        this.print("Доступные степени родства: м - мать, o - отец, cп - супруг/супруга, б - брат, ст - сестра, сн - сын, д - дочь.");
        runCheck = true;
        while (runCheck) {
            String relation = this.inputString("Введите родство: ");
            if (this.checkTextForRelation(relation)) {
                presenter.addPersonAs(firstName, lastName, age, gender, targetFirstName, targetLastName, relation);
                this.print("Персона добавлена в дерево.");
                runCheck = false;
            }
        }
    }

    @Override
    public void getInfo() {
        this.print("Ищем...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        presenter.getInfo(firstName, lastName);
    }

    @Override
    public void getInfoRelation() {
        this.print("Ищем...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        this.print("Доступные степени родства: м - мать, o - отец, cп - супруг/супруга, б - брат, ст - сестра, сн - сын, д - дочь.");
        String relation = this.inputString("Введите степень родства: ");
        presenter.getInfo(firstName, lastName, relation);
    }

    @Override
    public void saveFamilyTree() throws IOException {
        this.print("Сохраняем древо...");
        String path = this.inputString("Введите имя файла (без расширения): ") + ".sfmt";
        presenter.saveFamilyTree(path);
    }

    @Override
    public void loadFamilyTree() throws IOException, ClassNotFoundException {
        this.print("Загружаем древо...");
        String path = this.inputString("Введите имя файла (без расширения): ") + ".sfmt";
        presenter.loadFamilyTree(path);
    }

    private String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int inputInt(String message) {
        int number = 0;
        boolean run = true;
        while (run) {
            try
            {
                number = Integer.parseInt(this.inputString(message).trim());
                run = false;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Введено некорректное значение.");
            }
        }
        return number;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
