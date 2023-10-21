package familyTree.view;

import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;
import familyTree.presenter.Presenter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Wrong value";
    private boolean work;
    private Menu menu;
    private Scanner scanner;
    private Presenter presenter;
    private Human mother;
    private Human father;

    public ConsoleUI() {
        work = true;
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }
    @Override
    public FamilyTree<Human> start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
        return null;
    }

    private void hello() {
        System.out.printf("Welcome to menu\n");
    }

    public void finish() {
        System.out.printf("You're completed work");
        work = false;
    }

    public void addToFamily() {
        System.out.println("Enter name of new family's member:\nAfter this step program will ask you about:\n- date of birth\n- gender");
        String name = scanner.nextLine();
        System.out.println("Enter date of birth IN FORMAT: DD-MM-YYYY:");
        String dateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println("Enter gender IN FORMAT: Male/Female");
        String genderStr = scanner.nextLine();
        Gender gender = Gender.valueOf(genderStr);

        presenter.addToFamily(name, date, gender);
    }

    public void setParents(){
        System.out.println("Enter id of child: \n");
        String childStr = scanner.nextLine();
        long idChild = Long.parseLong(childStr);

        System.out.println("Enter id of mother: \n");
        String motherStr = scanner.nextLine();
        long idMother = Long.parseLong(motherStr);

        System.out.println("Enter id of father: \n");
        String fatherStr = scanner.nextLine();
        long idFather = Long.parseLong(fatherStr);

        presenter.setParents(idChild, idMother, idFather);
    }

    public void getFamilyInfo() {
        presenter.getFamilyInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    private boolean checkCommand(int numbCommand) {
        if (numbCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR + "\n");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numbCommand = Integer.parseInt(line);
            if (checkCommand(numbCommand)) {
                menu.execute(numbCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9+]")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void writeFile() {
        System.out.println("Enter name of file IN FORMAT 'nameFile.txt': \n");
        String filePath = scanner.nextLine();
        presenter.writeFile(filePath);
    }

    public void readFile() {
        System.out.println("Enter name of file from where you want to read IN FORMAT 'nameFile.txt': \n");
        String filePath = scanner.nextLine();
        presenter.readFile(filePath);
    }

}
