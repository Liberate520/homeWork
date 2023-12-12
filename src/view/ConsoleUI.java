package view;

import model.human.Gender;
import model.human.Human;
import presentor.Presentor;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено не корректное значение!";
    private Scanner scanner;
    private Presentor presentor;
    private MainMenu menu;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presentor = new Presentor(this);
        menu = new MainMenu(this);
        work = true;
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            executeRequest();
        }

    }

    private void hello() { System.out.println("Здравствуйте!");}
    private void printMenu() {
        System.out.println(menu.getMenu());
    }
    private void executeRequest() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize() + 1){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
    @Override
    public void printAnswer(String text) { System.out.println(text);}

    public void addHuman() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String familyName = scanner.nextLine();
        System.out.println("Введите пол:");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
        Gender gender = null;
        int indexGender = Integer.parseInt(scanner.nextLine());
        if (indexGender == 1) {
            gender = Gender.male;
        }
        else if (indexGender == 2) {
            gender = Gender.female;
        }
        System.out.println("Введите дату рождения в формате 2000-10-10:");
        LocalDate birthData = LocalDate.parse(scanner.nextLine());
        System.out.println("Выберите мать:");
        presentor.getWoman();
        System.out.println("Введите индекс матери, если нет матери введите любое другое число:");
        int indexMother = Integer.parseInt(scanner.nextLine());
        System.out.println("Выберите отца:");
        presentor.getMan();
        System.out.println("Введите индекс отца, если нет отца введите любое другое число:");
        int indexFather = Integer.parseInt(scanner.nextLine());
        if (presentor.addHuman(name, familyName, gender, birthData, indexMother, indexFather)) {
            System.out.println("Человек успешно добавлен.");
        }
        else {
            System.out.println("Не удалось добавить человека.");
        }
    }
    public void allHuman(){
        presentor.getAllHumans();
    }
    public void finish() {
        System.out.println("Досвидания!");
        work = false;
    }
    public void humanDeath() {
        int indexHuman = getIndexHuman();
        System.out.println("Укажите дату смерти в формате 2000-10-10:.");
        LocalDate deathData = LocalDate.parse(scanner.nextLine());
        if (presentor.humanDeath(indexHuman, deathData)) {
            System.out.println("Дата смерти занесена.\n");
        }
        else {
            System.out.println("Не удалось занести дату смерти.\n");
        }
    }
    public void getFamilyTree() {
        int indexHuman = getIndexHuman();
        presentor.getFamilyTree(indexHuman);
    }
    public void getFamily() {
        int indexHuman = getIndexHuman();
        presentor.getFamily(indexHuman);
    }

    private int getIndexHuman() {
        presentor.getAllHumans();
        System.out.println("Выберите индекс человека.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void sortByAge() {
        presentor.sortByAge();
    }

    public void sortByName() {
        presentor.sortByName();
    }

    public void sortByFamilyName() {
        presentor.sortByFamilyName();
    }
}
