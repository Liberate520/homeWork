package ui;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public Console(){
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

    @Override
    public void save() {
        presenter.save();
    }

    public void load() {
        presenter.load();
    }

    @Override
    public void getInfo() {
        presenter.getInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String dob = scanner.nextLine();
        System.out.println("Введите ID матери: ");
        int motherID = getPersonId();
        System.out.println("Введите ID отца: ");
        int fatherID = getPersonId();
        presenter.addHuman(firstName, lastName, dob, motherID, fatherID);
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
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException {
        hello();
        while (work){
            System.out.println(mainMenu.print());
            String choice = scanner.nextLine();
            if (check(choice)){
                mainMenu.execute(Integer.parseInt(choice));
            }else {
                fail();
            }
        }
    }
    private boolean check(String text){
        return  text.matches("[0-9]+") && Integer.parseInt(text) <= mainMenu.size()
                && Integer.parseInt(text) > 0;
    }
    public void fail() {
        System.out.println("Wrong input!");
    }
    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void execute() throws IOException {
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
        if (numCommand < mainMenu.size()){
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
