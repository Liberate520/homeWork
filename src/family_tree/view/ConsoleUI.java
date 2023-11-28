package family_tree.view;

import family_tree.presenter.Presenter;

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
//        System.out.print("выберите команду : ");
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

    public void sortByAge() {
//        System.out.println(presenter.sortByAge());
        presenter.sortByAge();
    }

    public void sortByIncome() {
        presenter.sortByIncome();
    }

    public void sortByName() { presenter.sortByName(); }


}

