package ru.gb.family_tree.family_tree.view;
import ru.gb.family_tree.family_tree.model.human.Gender;
import ru.gb.family_tree.family_tree.presenter.Presenter;
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
        System.out.println("До скорой встречи");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
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
    public void addHuman() {
        System.out.println("Введите имя ");
        String name = scanner.nextLine();
        int choiceG = 0;
        while (choiceG ==0) {
            System.out.println("Введите пол 1-мужской, 2-женский");
            int UserInput = Integer.parseInt(scanner.nextLine());
            if (UserInput == 1 || UserInput == 2) {
                choiceG = UserInput;
            } else {
                System.out.println("Пожалуйста, введите 1 или 2.");
            }
        }
        Gender gender = Gender.Male;
        if (choiceG==2) {
            gender = Gender.Female;
        }
        System.out.println("Дату рождения в формате ГГГГ-ММ-ДД: ");
        String userInputDate1 = scanner.nextLine();
        LocalDate birthdate = null;
        try {
            birthdate = LocalDate.parse(userInputDate1);
            System.out.println("Вы ввели дату: " + birthdate);
        } catch (Exception e) {
            System.out.println("Ошибка при парсинге даты. Убедитесь, что вы ввели правильный формат (ГГГГ-ММ-ДД).");
        }
        System.out.println("Желаете Ввести дату смерти? 1-Да 2-Нет ");
        String choiceDeathDate = scanner.nextLine();
        if (choiceDeathDate.equals("1")) {
            System.out.println("Введите дату смерти в формате ГГГГ-ММ-ДД:");
            LocalDate deathdate = null;
            ;
            String userInputDate2 = scanner.nextLine();
            try {
                deathdate = LocalDate.parse(userInputDate2);
                System.out.println("Вы ввели дату: " + deathdate);
            } catch (Exception e) {
                System.out.println("Ошибка при парсинге даты. Убедитесь, что вы ввели правильный формат (ГГГГ-ММ-ДД).");
            }
            presenter.addHuman(name, gender, birthdate, deathdate);
            System.out.println("человек создан и добавлен в древо");
            presenter.getFamilyTree();
        }
        if (!choiceDeathDate.equals("1")) {
            presenter.addHuman(name, gender, birthdate);
        }
    }
    public void createFamilyConnectionByID() {
        System.out.println("Введите ID ребенка ");
        int childID = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID родителя ");
        int parentID =Integer.parseInt(scanner.nextLine());
        presenter.createFamilyConnectionByID(childID,parentID);
    }

    public void printTree() {
        System.out.println(presenter.getFamilyTree());
    }

    public void saveTreeToFile() {
        presenter.saveTreeToFile();
    }

    public void loadTreeFromFile() {
        presenter.loadTreeFromFile();
    }

}

