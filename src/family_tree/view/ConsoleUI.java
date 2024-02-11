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
        System.out.println(" ");
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
        int inputNumber;
        System.out.print("введите фамилию : ");
        String lastName = scan();
        System.out.print("введите имя отчество (через пробел) : ");
        String firstName = scan();
        System.out.print("укажите пол соответсвующим числом (Male-1, Female-2) : ");
        inputNumber = scanner.nextInt();
        String memberGender = "";
        switch (inputNumber) {
            case 1:
                memberGender = "Male";
                break;
            case 2:
                memberGender = "Female";
                break;
            default:
                System.out.println("указан неверный номер - введите 1 или 2");
                return; // Выход из программы, если выполнен неверный ввод
        }
        Gender gender = Gender.valueOf(memberGender);
        System.out.print("укажите соответствующим числом кто (Father-1, Mother-2, Child-3, Daughter-4, Son-5) : ");
        inputNumber = scanner.nextInt();
        String familyMember = "";
        switch (inputNumber) {
            case 1:
                familyMember = "Father";
                break;
            case 2:
                familyMember = "Mother";
                break;
            case 3:
                familyMember = "Child";
                break;
            case 4:
                familyMember = "Daughter";
                break;
            case 5:
                familyMember = "Son";
                break;
            default:
                System.out.println("указан неверный номер - введите 1, 2, 3, 4, или 5");
                return; // Выход из программы, если выполнен неверный ввод
        }
        Position position = Position.valueOf(familyMember);
        System.out.print("укажите социальное положение соответствующим числом (Not_married-1, Married-2) : ");
        inputNumber = scanner.nextInt();
        String socialMember = "";
        switch (inputNumber) {
            case 1:
                socialMember = "Not_married";
                break;
            case 2:
                socialMember = "Married";
                break;
            default:
                System.out.println("указан неверный номер - введите 1 или 2");
                return; // Выход из программы, если выполнен неверный ввод
        }
        SocialPosition socialPosition = SocialPosition.valueOf(socialMember);
        System.out.print("укажите образование соответствующим числом (Formal-1, Informal-2, Non_formal-3) : ");
        inputNumber = scanner.nextInt();
        String memberFondation = "";
        switch (inputNumber) {
            case 1:
                memberFondation = "Formal";
                break;
            case 2:
                memberFondation = "Informal";
                break;
            case 3:
                memberFondation = "Non_formal";
                break;
            default:
                System.out.println("указан неверный номер - ведите 1, 2 или 3");
                return; // Выход из программы, если выполнен неверный ввод
        }
        Fondation fondation = Fondation.valueOf(memberFondation);
        System.out.print("укажите доход (только цифры) : ");
        double income = Double.parseDouble(scan());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate birthDate = null;
        System.out.print("введите дату рождения (в формате: yyyy-MM-dd) : ");
        try {
            birthDate = LocalDate.parse(scan(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("неверный формат даты - укажите в формате yyyy-MM-dd.");
        }
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
        int age = getAge(birthDate, deathDate);
        // Generate ID
        int Num = LastIdsMethod.getLastId();
        int id = Num + 1;

//        System.out.print("укажите ID (в формате int) : ");
//        int id = scan();
        presenter.add(lastName, firstName, gender, position, socialPosition, fondation, income, birthDate, id);



        // Запись в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.append("\n===============================" +
                    "\n===============================" +
                    "\nчлен семьи: " + lastName + " " + firstName +
                    "\nпол: " + gender +
                    "\nположение: " + position +
                    "\nсоциальный статус: " + socialPosition +
                    "\nобразование: " + fondation +
//                "\nКто дети: " + children +
                    "\nдоходы: " + income +
                    "\nвозраст: " + age +
                    "\nid: " + id);
//            writer.newLine();
        } catch (IOException e) {
            System.out.println("ошибка записи файла : " + e.getMessage());
        }
        
    }


    public static int getAge(LocalDate birthDate, LocalDate deathDate) {
        if (deathDate != null && deathDate.isBefore(LocalDate.now())) {
            return deathDate.getYear() - birthDate.getYear() - ((deathDate.getMonthValue() < birthDate.getMonthValue() ||
                    (deathDate.getMonthValue() == birthDate.getMonthValue() && deathDate.getDayOfMonth() < birthDate.getDayOfMonth())) ? 1 : 0);
        } else {
            return LocalDate.now().getYear() - birthDate.getYear() - ((LocalDate.now().getMonthValue() < birthDate.getMonthValue() ||
                    (LocalDate.now().getMonthValue() == birthDate.getMonthValue() && LocalDate.now().getDayOfMonth() < birthDate.getDayOfMonth())) ? 1 : 0);
        }
    }

    private String scan() {
        scanner = new Scanner(System.in, "UTF-8");
        return scanner.nextLine();
    }
}

