package family_tree.view;

import family_tree.model.human.*;
import family_tree.presenter.Presenter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;


public class ConsoleUI implements View {
    private boolean work;
    private Scanner scanner;
    private MainMenu menu;
    private Presenter presenter;
    private static final String INPUT_ERROR = ("\"вы ввели неверное значение\"");

    // Цвет строки в консоли
    public static final String PURPLE_TEXT = "\u001B[35m";
    public static final String PURPLE_TEXT_RESET = "\u001B[0m";

    String filePath = "homeWork/src/model_app/family_tree_.txt";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }
    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void title() {
        System.out.println("                    FAMILY TREE");
        System.out.println("===============================");
        System.out.println("===============================");
    }

    public void instuction(){
        System.out.print("\"укажите требуемое действие\" : ".toLowerCase());
    }

    @Override
    public void start() {
        while (work){
            title();
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("\"до новых встреч !\"");
        work = false;
    }

    public void getFamilyListInfo() {
        presenter.getFamilyListInfo();
    }

    private void execute(){
        instuction();
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand > 0 && numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(PURPLE_TEXT + INPUT_ERROR + PURPLE_TEXT_RESET);
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    public void sortByLastName() {
        presenter.sortByLastName();
    }

    public void sortByAge() { presenter.sortByAge(); }

    public void sortByIncome() {
        presenter.sortByIncome();
    }

    public void sortByName() { presenter.sortByName(); }

    public void addHuman() {
        System.out.print("введите фамилию : ");
        String lastName = scan();
        System.out.print("введите имя отчество (через пробел) : ");
        String firstName = scan();
        System.out.print("укажите пол (Male, Female) : ");
        Gender gender = Gender.valueOf(scan());
        System.out.print("укажите кто (Father, Mother, Child, Daughter, Son) : ");
        Position position = Position.valueOf(scan());
        System.out.print("укажите социальное положение (Not_married, Married) : ");
        SocialPosition socialPosition = SocialPosition.valueOf(scan());
        System.out.print("укажите образование (Formal, Informal, Non_formal) : ");
        Fondation fondation = Fondation.valueOf(scan());
        System.out.print("укажите доход (только цифры) : ");
        double income = Double.parseDouble(scan());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        System.out.print("введите дату рождения (в формате: yyyy-MM-dd) :");
        LocalDate birthDate = LocalDate.parse(scan(), formatter);
//        LocalDate birthDate = LocalDate.parse(scan(), formatter);
        LocalDate deathDate = null;
        System.out.print("введите дату смерти (в формате: yyyy-MM-dd) или пропустите : ");
        String deathDateStr = scan();
        if (!deathDateStr.isEmpty()) {
            try {
            deathDate = LocalDate.parse(deathDateStr, formatter);
        }  catch (DateTimeParseException e) {
            System.out.println("неверный формат даты - дата смерти не будет указана.");
        }
        }
        // Generate ID
        int nextID = 16;
        int id = ++nextID;

//        System.out.print("укажите ID (в формате int) : ");
//        int id = scan();
        presenter.add(lastName, firstName, gender, position, socialPosition, fondation, income, birthDate, id);


        // Запись в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.append("\n===============================" +
                    "\nчлен семьи: " + lastName + " " + firstName +
                    "\nпол: " + gender +
                    "\nположение: " + position +
                    "\nсоциальный статус: " + socialPosition +
                    "\nобразование: " + fondation +
//                "\nКто дети: " + children +
                    "\nдоходы: " + income +
                    "\nвозраст: " + birthDate +
                    "\nid: " + id +
                    "\n===============================");
//            writer.newLine();
        } catch (IOException e) {
            System.out.println("ошибка записи файла : " + e.getMessage());
        }
        
    }



    private String scan() {
        scanner = new Scanner(System.in, "UTF-8");
        return scanner.nextLine();
    }
}

