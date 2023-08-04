package genealogy_tree.ui;

import genealogy_tree.model.Human.Gender;
import genealogy_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;

    private Scanner scanner;

    private boolean flag;
    private MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true;
        menu = new MainMenu(this);
    }


    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    @Override
    public void start() {

        while (flag) {
            printMenu();
            execute();
        }
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    public void finish() {
        System.out.println("GoodBuy");
        flag = false;
        scanner.close();
    }

    public void addParents() {
        System.out.println("Who is person");
        int id = scanner.nextInt();
        System.out.println("Who is parents");
        int ids = scanner.nextInt();
        presenter.addParetns(id,ids);
        System.out.println("Add parents");
    }

    public void addChildren() {
        System.out.println("Who is person");
        int id = scanner.nextInt();
        System.out.println("Who is your children?");
        int ids = scanner.nextInt();
        presenter.addChildren(id,ids);
        System.out.println("Add children");
    }

    public void addSposue() {
        System.out.println("Who is person");
        int id = scanner.nextInt();
        System.out.println("Choose a spose");
        int ids = scanner.nextInt();
        presenter.addSpouse(id,ids);
        System.out.println("Wedding!");
    }

    public void setDivorce() {
        System.out.println("Who is person");
        int id = scanner.nextInt();
        System.out.println("Choose a spose");
        int ids = scanner.nextInt();
        presenter.setDivorce(id,ids);
        System.out.println("Divorce!");
    }

    public void getSiblings() {
        System.out.println("Who is person");
        int id = scanner.nextInt();
        presenter.getSiblings(id);
        System.out.println("Siblings a person");
    }

    public void addHuman() {

        int id = 0;
        System.out.println("Enter a name : ");
        String name = scanner.next();
        System.out.println("Enter a gender");

        String gender = scanner.next();
        while (true) {
            if (gender.equals("Male")) {
                gender = String.valueOf(Gender.valueOf(gender));
                break;

            } else if (gender.equals("Female")) {
                gender = String.valueOf(Gender.valueOf(gender));
                break;
            } else System.out.println("Not support Gender, repaid");
            return;
        }


        System.out.println("Enter a birthDate.");
            System.out.println("Enter a day.");
        while (scanner.hasNextInt()) {
            int birthDateDay = scanner.nextInt();
            System.out.println("Enter a month.");
            int birthDateMonth = scanner.nextInt();
            System.out.println("Enter a Year.");
            int birthDateYear = scanner.nextInt();

            LocalDate birthDate = LocalDate.of(1, 1, 1);
            int birthDateDays = Integer.valueOf(birthDateDay);
            int birthDateMonths = Integer.valueOf(birthDateMonth);
            int birthDateYears = Integer.valueOf(birthDateYear);

            if (birthDateDays > 0 && birthDateDays < 31 && birthDateMonths > 0 && birthDateMonths <= 12 && birthDateYears > 0
                    && birthDateYears < 2030) {
                birthDate = birthDate.plusDays(birthDateDays);
                birthDate = birthDate.minusDays(1);
                birthDate = birthDate.plusMonths(birthDateMonths);
                birthDate = birthDate.minusMonths(1);
                birthDate = birthDate.plusYears(birthDateYears);
                birthDate = birthDate.minusYears(1);
            } else {
                System.out.println("Data not supported");
            }
            presenter.addHuman(id, name, Gender.valueOf(gender), birthDate);
            break;
        }
            System.out.println("Its not number ");
        }


    public void getInfo() {
        presenter.getInfo();
    }

    private void execute() {
        String line = scanner.next();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;}
        else  {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            //inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println("Errors, function not supported");
    }
}
