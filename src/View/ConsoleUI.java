package View;

import Model.BaseCharacter.Gender;
import Presenter.Presenter;

import java.util.*;

public class ConsoleUI implements Viewable{
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start(){
        hello();
        while(work){
            printMenu();
            execute();
        }
    }

    public void addBaseCharacter() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите возраст: ");
        String ageString = scanner.nextLine();
        System.out.println("Введите пол(1 - мужчина, 2 - женщина): ");
        String choice = scanner.nextLine();
        presenter.addBaseCharacter(name, setAge(ageString), setGender(choice));
    }

    public void listInfo() {
        presenter.getListInfo();
    }

    public void sort_name(){
        presenter.sortByName();
    }

    public void sort_age(){
        presenter.sortByAge();
    }

    public void end(){
        System.out.println("Всего доброго!");
        scanner.close();
        work = false;
    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);
    }

    public void saveToFile() {
        presenter.saveToFile();
    }

    public void readFromFile() {
        presenter.readFile("src/Data/text.txt");
    }

    private int setAge(String text){
        if(ageChecker(text)){
            int age = Integer.parseInt(text);
            return age;
        }else{
            return 0;
        }
    }

    private Gender setGender(String string){
        Gender gender = null;
        if(checkGender(string)){
            int num = Integer.parseInt(string);
            if(num == 1){
                gender = Gender.MAN;
            } else {
                gender = Gender.WOMAN;
            }
        }
        return gender;
    }

    private void execute(){
        String line = scanner.nextLine();
        if(checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if(checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private void hello(){
        System.out.println("Здравствуйте!");
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void errorInput() {
        System.out.println("Введено некорректное значение");
    }

    private boolean checkCommand(int numCommand){
        if(numCommand < menu.size() + 1){
            return true;
        }else {
            errorInput();
            return false;
        }
    }

    private boolean ageChecker(String text) {
        try{
            int age = Integer.parseInt(text);
            if (age > 0 && age < 100){
                return true;
            }else {
                return false;
            }
        }catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkGender(String string) {
        try {
            int buffer = Integer.parseInt(string);
            if(buffer > 0 && buffer <= 2){
                return true;
            }else {
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean checkTextForInt(String text){
        if(text.matches("[0-9]+")){
            return true;
        }else {
            errorInput();
            return false;
        }
    }
}
