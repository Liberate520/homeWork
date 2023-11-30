package family_tree.view;

import family_tree.model.human.Fondation;
import family_tree.model.human.Gender;
import family_tree.model.human.Position;
import family_tree.model.human.SocialPosition;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        System.out.print("введите дату рождения (в формате: yyyy-MM-dd) :");
        String birthDate = scan();
        System.out.print("введите дату смерти (в формате: yyyy-MM-dd) или пропустите : ");
        String deathDate =  scan();
        System.out.print("укажите ID (в формате 0.**) : ");
        double id = Double.parseDouble(scan());
        presenter.add(lastName, firstName, gender, position, socialPosition, fondation, income, LocalDate.parse(birthDate), LocalDate.parse(deathDate, DateTimeFormatter.ISO_LOCAL_DATE), id);
        
    }

    private String scan() {
        scanner = new Scanner(System.in, "UTF-8");
        return scanner.nextLine();
    }
}

