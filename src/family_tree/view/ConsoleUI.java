package familyTree.src.family_tree.view;
import familyTree.src.family_tree.model.human.Gender;
import familyTree.src.family_tree.model.human.Human;
import familyTree.src.family_tree.presenter.Presenter;

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

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Введите номер паспорта человека: ");
        String docId = scanner.nextLine();
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (" + name + "): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Укажите дату рождения: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите дату смерти: ");
        LocalDate deathDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите отца: ");
        String father = scanner.nextLine();
        System.out.println("Укажите мать: ");
        String mother = scanner.nextLine();
        System.out.println("Укажите номер паспорта супруга: ");
        String spouse = scanner.nextLine();
        //TODO сделать проверку правильности введения полей
        presenter.addHuman(docId, name, gender, birthDate, deathDate,
                father, mother, spouse);
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
