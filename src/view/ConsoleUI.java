package view;

import model.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
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

    public void sortByBirthDay() {
        presenter.sortByBirthDay();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getAllHuman() {
        presenter.getAllHuman();
    }

    public void addHuman() {
        System.out.println("Укажите индентификатор");
        String idStr = scanner.nextLine();
        int id = Integer.parseInt(idStr);
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека. 1 - М, 2 - Ж");
        String genderStr = scanner.nextLine();
        Gender gender;
        if(genderStr.equals("1")){
            gender = Gender.male;
        }else{
            gender = Gender.female;
        }
        System.out.println("Введите день рождения");
        String birthDayStr = scanner.nextLine();
        int birthDay = Integer.parseInt(birthDayStr);
        System.out.println("Введите месяц рождения");
        String birthMonthStr = scanner.nextLine();
        int birthMonth = Integer.parseInt(birthMonthStr);
        System.out.println("Введите год рождения");
        String birthYearStr= scanner.nextLine();
        int birthYear = Integer.parseInt(birthYearStr);
        LocalDate birth = LocalDate.of(birthYear, birthMonth, birthDay);

        presenter.addHuman(id, name, gender, birth);
    }

    public void save() {
        System.out.println(presenter.save());
    }
    public void download() {
        presenter.download();
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
        if (numCommand < menu.getSize() + 1){
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

    public void setParent() {
        System.out.println("Укажите индентификатор ребенка");
        String idStr = scanner.nextLine();
        int idChild = Integer.parseInt(idStr);
        System.out.println("Укажите индентификатор родителя");
        String idStr2 = scanner.nextLine();
        int idParent = Integer.parseInt(idStr2);

        presenter.setParent(idChild, idParent);
    }
}
