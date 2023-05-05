package ui;

import human.Gender;
import presenter.Presenter;

import java.util.Scanner;

public class ConsoleWorkMenu implements ViewWorkMenu{

    private static final String INPUT_ERROR = "Вы ввели неверное значение, повторите ввод";
    private Presenter presenter;
    private Scanner scanner;
    private WorkMenu workMenu;
    private boolean start;

    public ConsoleWorkMenu(){
        scanner = new Scanner(System.in);
        start = true;
        workMenu = new WorkMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (start){
            printWorkMenu();
            execute();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addHuman() {
        System.out.println("Введите Имя человека:");
        String firstName = scanner.nextLine();
        System.out.println("Введите Фамилию человека:");
        String lastName = scanner.nextLine();
        System.out.println("Введите дату рождения человека:");
        String birthday = scanner.nextLine();
        System.out.println("Введите пол человека (М или Ж):");
        Gender gender = getGender();
        System.out.println("Введите ID матери(если неизвестно введите 0):");
        int motherID = getPersonId();
        System.out.println("Введите ID отца(если неизвестно введите 0):");
        int fatherId = getPersonId();
        presenter.addHuman(firstName, lastName, birthday, gender, motherID, fatherId);
    }

    private int getPersonId() {
        int motherId;
        while (true){
            String text = scanner.nextLine();
            if (checkTextForInt(text)) {
                motherId = Integer.parseInt(text);
                return motherId;
            } else {
                inputError();
            }
        }
    }

    @Override
    public void findHumanById() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int id = Integer.parseInt(line);
            System.out.println(presenter.findHumanById(id));
        } else {
            inputError();
        }
    }

    @Override
    public void findHuman() {
        System.out.println("Найти человека:");
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите дату рождения");
        String birthday = scanner.nextLine();
        presenter.findHuman(firstName, lastName, birthday);
    }

    @Override
    public void printTree() {
        presenter.getPeople();
    }

    @Override
    public void finish() {
        start = false;
    }

    private void printWorkMenu() {
        System.out.println(workMenu.print());
    }

    private void execute() {
        String input = scanner.nextLine();
        if (checkTextForInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)){
                workMenu.execute(numCommand);
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
        if (numCommand <= workMenu.size() && numCommand > 0){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
    private Gender getGender(){
        while (true){
            String text = scanner.nextLine();
            if (text.toUpperCase().equals("М")){
                return Gender.Male;
            } else if (text.toUpperCase().equals("Ж")) {
                return Gender.Female;
            }
            inputError();
        }
    }
}
