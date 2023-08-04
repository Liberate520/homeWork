package homeWork.ProjectFamilyTree.View;

import homeWork.ProjectFamilyTree.Model.Gender;
import homeWork.ProjectFamilyTree.Model.Human;
import homeWork.ProjectFamilyTree.Presenter.Presenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Выберите действие: ");
        while (work){
            System.out.println(mainMenu.menu());
            String choice = scanner.nextLine();
            int choiceInt = Integer.parseInt(choice);
            mainMenu.execute(choiceInt);
        }
    }

    private void errorInput(){
        System.out.println("Введены неверные данные");
    }

    public void finish(){
        scanner.close();
        work = false;
    }
    public void sortByAge(){
        presenter.sortByAge();
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }
    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения");
        LocalDate localDateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите дату смерти");
        LocalDate localDateofDeath = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите пол (Male/Female)");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addHuman(name, localDateOfBirth, localDateofDeath, gender);
    }
    @Override
    public void printAnswer(String answer) {

    }
}
