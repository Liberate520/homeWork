package Homework.view;

import Homework.model.Human.Gender;
import Homework.presenter.Presenter;

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

    public void printAnswer(String text) {
        System.out.println(text);
    }

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

    public void sortByAge() {presenter.sortByAge();}

    public void sortByName() {presenter.sortByName();}

    public void sortByChildren() {presenter.sortByChildren();}

    public void getHumanInfo(){
        presenter.getHumanInfo();
    }

    public void addHuman(){
        System.out.println("Введите ФИО человека: ");
        String name = scanner.nextLine();
        System.out.println("Введите гендер человека (male/female): ");
        String genderTmp = scanner.nextLine();

        Gender gender = null;
        if(genderTmp.equals("male")){gender = gender.Male;}
        else{gender = gender.Female;}

        System.out.println("Укажите дату рождения человека в формате 0000-00-00: ");
        String birthString = scanner.nextLine();
        LocalDate birth = LocalDate.parse(birthString);
        presenter.addHuman(name, gender, birth);
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
