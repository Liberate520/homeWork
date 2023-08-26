package view;

import presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;
import model.human.Gender;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Досвидания!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void saveTree() {
        presenter.saveTree();
    }

    public void openSaveTree() {
        presenter.openSaveTree();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол человека");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Введите возраст человека");
        String ageString = scanner.nextLine();
        System.out.println("Укажите дату рождения человека");
        String birthDateString = scanner.nextLine();
        int age = Integer.parseInt(ageString);
        LocalDate birthDate = LocalDate.parse(birthDateString);
        presenter.addHuman(name, gender, age, birthDate);
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
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

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}