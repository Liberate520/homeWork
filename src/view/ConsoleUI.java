package view;

import model.human.Gender;
import presenter.Presenter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag = true;
    private MainMenu mainMenu;

    public ConsoleUI() {
         presenter = new Presenter(this);
         scanner = new Scanner(System.in);
         mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        while (flag) {
            printMenu();
            scanMenu();
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    private void scanMenu() throws IOException, ClassNotFoundException {
        String choice = scanner.nextLine();
        if (isNumeric(choice)) {
            if (Integer.parseInt(choice) < mainMenu.size()+1 && Integer.parseInt(choice) > 0) {
                mainMenu.execute(Integer.parseInt(choice));
            }
            else {
                error();
            }
        }
        else {
            error();
        }
    }

    private void error() {
        System.out.println("\n Error, try again.\n");
    }
    public void exit() {
        flag = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public static <Date> boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = (Date) sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            System.out.println("Invalid format");
        }
        return date != null;
    }

    public void addElement() {
        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println("BD (YYYY-MM-DD):");
        String bdScanned = scanner.nextLine();
        LocalDate bd = null;
        if (isValidFormat("yyyy-MM-dd", bdScanned)) {
            bd = LocalDate.parse(bdScanned);
        }

        System.out.println("Gender (M/F):");
        Gender gender = Gender.male;
        if (Objects.equals(scanner.nextLine(), "F")) {
            gender = Gender.female;
        }
        presenter.addElement(name, bd, gender);
    }

    @Override
    public void save() throws IOException, ClassNotFoundException {
        Presenter.save();
        System.out.println("Saved");
    }

    @Override
    public void read() throws IOException, ClassNotFoundException {
        presenter.read();
    }

    @Override
    public void saveAndExit() throws IOException, ClassNotFoundException {
        presenter.save();
        System.out.println("Saved");
        exit();
    }

    private void printMenu() {
        System.out.println(mainMenu.print());
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
}
