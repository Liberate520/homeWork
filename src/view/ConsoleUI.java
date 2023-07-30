package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private boolean work;
    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        work = true;
    }
    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }
    public void finish() {
        System.out.println("До новых встреч");
        work = false;
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
        if (numCommand - 1 < menu.getSize()){ /* -1 - для корректной проверки */
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void hello() {
        System.out.println("Добрый день! запустилось приложение.\n");
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
    public void getHumanList(){
        presenter.getHumanList();
    }
    public void addHuman() {
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите Имя");
        String name = scanner.nextLine();
        System.out.println("Введите Отчество");
        String patronymic = scanner.nextLine();
        //TODO сделать по выбору и разделить на отдельные функции с проверками
        System.out.println("Введите пол человека (Male/Female): ");
        String genderString = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String birthDate = scanner.nextLine();
        System.out.println("Введите дату смерти (если человек жив, введите \"null\"): ");
        String deathDate = scanner.nextLine();
        System.out.println("Введите индекс отца ");
        int idFather = scanner.nextInt();
        System.out.println("Введите индекс матери ");
        int idMother = scanner.nextInt();
        presenter.addHuman(surname, name, patronymic, genderString, birthDate, deathDate, idFather, idMother);
    }

    public void sortByFullName() {
        presenter.sortByFullName();
    }
    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }
    public void sortByAge() {
        presenter.sortByAge();
    }
}
