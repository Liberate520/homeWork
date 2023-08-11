package ru.gb.fam_tree.view;

import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Gender;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Human;
import ru.gb.fam_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "You entered an incorrect value";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
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

    public void finish(){
        System.out.println("We will always be glad to see you back.");
        work = false;
    }

    public void addHuman(){
        boolean flag1 = true;
        boolean flag2 = true;
        Gender gender = null;
        LocalDate birthDate = null;

        System.out.println("Enter firstname:");
        String name = scanner.nextLine();
        while (flag1){
            String genf = "f";
            String genm = "m";
            System.out.println("Enter gender(f - female; m - male):");
            String gend = scanner.nextLine();
            if(gend == genf){
                gender = Gender.Female;
                flag1 = false;
            } else if (gend == gend) {
                gender = Gender.Male;
                flag1 = false;
            } else {
                System.out.println(INPUT_ERROR);
            }
        }
        while (flag2) {
            System.out.println("Enter birthdate(dd-mm-yyyy):");
            String bdate = scanner.nextLine();
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                birthDate = LocalDate.parse(bdate, dateTimeFormatter);
                flag2 = false;
            }
            catch(DateTimeParseException e){
                System.out.println(INPUT_ERROR);
            }
        }
        Human human = new Human(name, gender, birthDate);
        presenter.addHuman(human);
    }

    public void getHumansInfo(){
        presenter.getHumansInfo();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void printMenu(){
        System.out.println(menu.menu());
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
        if (numCommand < (menu.getSize()+1)){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void loadFromFile(){
        System.out.println("Enter file path: ");
        String path = scanner.nextLine();
        presenter.LoadFromFile(path);
    }

    public void saveToFile(){
        System.out.println("Enter file path: ");
        String path = scanner.nextLine();
        presenter.SaveToFile(path);
    }
}
