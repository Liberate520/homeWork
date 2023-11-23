package family_tree.view;

import family_tree.controller.Controller;

import java.util.Scanner;

public class ConsoleUI implements View {
    private boolean work;
    private Scanner scanner;
    private MainMenu menu;
    private Controller controller;
    private static final String INPUT_ERROR = ("\"вы ввели неверное значение\"");

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        controller = new Controller(this);
        work = true;
        menu = new MainMenu(this);
    }

    // Цвет строки в консоли
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String PURPLE_BACKGROUND_RESET = "\u001B[0m";
    public static final String WHITE_TEXT = "\u001B[37m";
    public static final String WHITE_TEXT_RESET = "\u001B[0m";

    public static final String PURPLE_TEXT = "\u001B[35m";
    public static final String PURPLE_TEXT_RESET = "\u001B[0m";
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
        System.out.println("\"укажите требуемое действие\"".toLowerCase());
    }


    @Override
    public void start() {
        instuction();
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
        controller.getFamilyListInfo();
    }

    private void execute(){
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
        if (numCommand < menu.getSize()){
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

    public void sortByAge() {
        controller.sortByAge();
    }


}

