package FamilyTree.view;

import FamilyTree.model.human.Gender;
import FamilyTree.presenter.Presenter;
import FamilyTree.view.menu.MainMenu;
import FamilyTree.view.menu.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        work = true;
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }
    public void getHumanList(){
        presenter.getHumanList();
    }

    public void addMember(){
        String name = inputName();
        Gender gender = inputGender();
        LocalDate birthDate = inputDate();
        String father = inputFather();
        String mother = inputMother();
        presenter.addHuman(name, gender, birthDate, father, mother);
    }

    private String inputName(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        return name;
    }

    private Gender inputGender(){
        while (true){
            System.out.println("Выберете пол: ");
            for (Gender gender: Gender.values()){
                System.out.println(gender);
            }
            String line = scanner.nextLine();
            for (Gender gender: Gender.values()){
                if (line.equalsIgnoreCase(gender.toString())){
                    return gender;
                }
            }
            System.out.println("Пол указан не верно!");
        }
    }

    private LocalDate inputDate(){
        System.out.println("Введите дату рождения формата (YYYY-MM-DD): ");
        String input = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
        return birthDate;
    }

    private String inputFather(){
        System.out.println("Введите имя отца: ");
        String name = scanner.nextLine();
        return name;
    }

    private String inputMother(){
        System.out.println("Введите имя матери: ");
        String name = scanner.nextLine();
        return name;
    }

    private void hello(){
        System.out.println("Добро пожаловать в семейное дерево!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if(checkLine(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
                return;
            }
        }
        inputError();
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    private boolean checkCommand(int numCommand) {
        return numCommand < menu.size();
    }
    private boolean checkLine(String text){
        return text.matches("[0-9]+");
    }
    private void printMenu(){
        System.out.println(menu.print());
    }
    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }
}
