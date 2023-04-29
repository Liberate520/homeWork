package ui.console;

import presenter.Presenter;
import ui.View;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private final Scanner scanner;
    private boolean work;
    private final MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void finish(){
        System.out.println("До скорых встреч");
        work = false;
    }
    public void getFamily(){
        presenter.getFamily();
    }

    @Override
    public void save() throws IOException {
        presenter.save();
    }

    @Override
    public void load() throws IOException, ClassNotFoundException {
        presenter.load();
    }

    @Override
    public void getRelatives() {
        getFamily();
        String human = scanner.nextLine();
        presenter.getRelatives(human);
    }

    public void addMember(){
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите день рождения:");
        String day = scanner.nextLine();
        System.out.println("Введите месяц рождения:");
        String month = scanner.nextLine();
        System.out.println("Введите год рождения:");
        String year = scanner.nextLine();
        System.out.println("Введите пол(м/ж):");
        String gender = scanner.nextLine();
        presenter.addMember(name, day, month, year, gender);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
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
        if (text.matches("[0-9]+")){
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
        System.out.println(INPUT_ERROR);
    }
}
