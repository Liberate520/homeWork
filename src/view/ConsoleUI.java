package view;

import model.human.Gender;
import model.writer.Writable;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

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

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    private void hello() {
        System.out.println("Добро пожаловать!");
    }

    private void choice() {
        String value = scanner.nextLine();
        if (checkMenu(value)) {
            int num = Integer.parseInt(value);
            menu.execute(num);
        }
    }

    private boolean checkMenu(String text) {
        try {
            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= menu.getSize()) {
                return true;
            }
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Вы ввели неверное значение!");
        return false;
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }

    public void save() {
        presenter.save();
    }

    public void load() {
        presenter.load();
    }

    public void importTree() {
        presenter.importTree();
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanInfo() {
        presenter.getHumanInfo();
    }

    public void addHuman() {
        System.out.println("Введите ID человека");
        int human_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID первого родителя");
        int parent_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения (ГГГГ-ММ-ДД");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите пол");
        Gender gen = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите имя второго родителя");
        String second_parent = scanner.nextLine();
        presenter.addHuman(human_id, parent_id, name, birthday, gen, second_parent);
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
        if (numCommand < menu.getSize()){
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

    public void addFirstParent() {
        System.out.println("Введите ID человека");
        int human_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID первого родителя");
        int parent_id = Integer.parseInt(scanner.nextLine());
        presenter.addFP(human_id, parent_id);
    }
}
