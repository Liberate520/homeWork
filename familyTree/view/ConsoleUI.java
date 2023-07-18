package familyTree.view;

import familyTree.presenter.Presenter;

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
        while (work){
            printMenu();
            execute();
        }
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
    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void AddHuman() {
        System.out.println("Введите фамилию человека");
        String surname = scanner.nextLine();
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения человека");
        String yearInput = scanner.nextLine();
        System.out.println("Введите месяц рождения человека");
        String monthInput = scanner.nextLine();
        System.out.println("Введите день рождения человека");
        String dayInput = scanner.nextLine();
        int y = Integer.parseInt( yearInput );
        int m = Integer.parseInt( monthInput );  // 1-12 for January-December.
        int d = Integer.parseInt( dayInput );
        LocalDate ld = LocalDate.of( y , m , d );
//        System.out.println("Укажите возраст человека");
//        String ageString = scanner.nextLine();
        //сделать проверку ввода возраста
//        int age = Integer.parseInt(ageString);
        System.out.println("Введите отца человека");
        String father = scanner.nextLine();
        System.out.println("Введите мать человека");
        String mother = scanner.nextLine();
        presenter.addHuman(surname, name, ld, null, father, mother);
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
}
