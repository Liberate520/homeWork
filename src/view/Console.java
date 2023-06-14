package view;

import model.Gender;
import presenter.Presenter;
import view.menu.MainMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Console implements View{

    private Presenter presenter;
    private Scanner scanner;
    private boolean mainLoop;
    private MainMenu mainMenu;

    public Console() {
        scanner = new Scanner(System.in);
        mainLoop = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Добро пожаловать в семейное древо.");
        while (mainLoop){
            printMenu();
            execute();
        }
    }

    private void printMenu(){
        System.out.println(mainMenu.printMenu());
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println("Ошибка ввода");
    }

    //-----------------------------------------------------//
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void ShowList() {
        System.out.println(presenter.showList());
    }

    public void sortByName() {
        presenter.sortByName();
        System.out.println("Сортировка выполнена.");
        ShowList();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        System.out.println("Сортировка выполнена.");
        ShowList();
    }

    @Override
    public void addHuman() {

        String name = "";
        System.out.print("Введите имя:");
        name = (scanner.nextLine());

        // TODO: 11.06.2023  добавить проверку исключений
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        System.out.print("Введите дату рождения (dd MM yyyy):");
        LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);

        String gen;
        System.out.print("Введите пол (MALE/FEMALE):");
        gen = (scanner.nextLine());
        Gender gender = Gender.UNKNOWN;
        if(gen.equals("MALE")) {gender = Gender.MALE;}
        if(gen.equals("FEMALE")) {gender = Gender.FEMALE;}
        presenter.addHuman(name, date, gender);

        System.out.println("Запись добавлена");
    }

    @Override
    public void findByName() {
        System.out.print("Введите имя:");
        String name = (scanner.nextLine());
        System.out.println(presenter.findByName(name));
    }

    public void findBrothers() {
        System.out.print("Введите имя:");
        String name = (scanner.nextLine());
        presenter.findBrothers(name);
    }

    @Override
    public void saveToFile() throws IOException {
        System.out.print("Введите имя файла для сохранения:");
        String filename = (scanner.nextLine());
        presenter.SaveToFile(filename);
        System.out.println("Файл сохранен");
    }

    @Override
    public void loadFromFile() throws IOException, ClassNotFoundException {
        System.out.print("Введите имя файла для чтения:");
        String filename = (scanner.nextLine());
        presenter.LoadFromFile(filename);
        System.out.println("Файл загружен");
    }

    @Override
    public void finish() {
        System.out.println("Работа завершена");
        mainLoop = false;
    }
}
