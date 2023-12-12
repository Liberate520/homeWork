package homeWork.src.view;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.tree.DateBuilder;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean check;
    private MainMenu menu;
    private DateBuilder dateBuilder = new DateBuilder();

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        check = true;
        menu = new MainMenu(this);
    }
    @Override
    public void start() {
        System.out.println("Hello!");
        while (check){
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu() {
        String choiceStr = scanner.nextLine();
        // метод проверки на валидность введенной строки
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    private void error() {
        System.out.println("Entered wrong parameter.");
    }

    public void exit() {
        System.out.println("Would you like to save your changes? Y/N");
        String prompt = scanner.nextLine().toLowerCase();
        if(prompt.equals("y")){
            presenter.save();
        }
        System.out.println("Bye-bye");
        check = false;
    }

    public void changeFamilyMember(){
        ConsoleUI2 console = new ConsoleUI2(presenter);
        console.start();
//        System.out.println("Enter the ID of the member you want to change: ");
//        long id = Long.parseLong(scanner.nextLine());
//        FamilyMember member = presenter.getFamilyMember(id);
//        if(member != null) {
//            console.start(member);
//        }
    }

    public void loadFamilyTree() {
        presenter.loadFamilyTree();
    }

    public void save() {
        presenter.save();
    }

    public void sortByBirthdate() {
        presenter.sortByBirthdate();
    }

    public void sortBySurname() {
        presenter.sortBySurname();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void addFamilyMember() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter patronymic name: ");
        String patronymicName = scanner.nextLine();

        Gender gender = null;
        boolean flag = true;
        while (flag) {
            System.out.println("Enter gender: ");
            String genderStr = scanner.nextLine();
            if (genderStr.equals("Male")) {
                gender = Gender.Male;
                flag = false;
            } else if (genderStr.equals("Female")) {
                gender = Gender.Female;
                flag = false;
            } else {
                System.out.println("Incorrect gender, please enter correct gender.");
            }
        }

        System.out.println("Enter birthDate: ");
        LocalDate birthDate = dateBuilder.buildDate();

        System.out.println("Would you like to add death date? Y/N");
        String prompt1 = scanner.nextLine().toLowerCase();
        LocalDate deathDate = null;
        if(prompt1.equals("y")){
            deathDate = dateBuilder.buildDate();
        }

        presenter.getFamilyTreeInfo();

        System.out.println("Would you like to add parents? Y/N");
        String prompt2 = scanner.nextLine().toLowerCase();
        if (prompt2.equals("y")){
            System.out.println("Select id of mother: ");
            int motherID = Integer.parseInt(scanner.nextLine());

            System.out.println("Select id of father: ");
            int fatherID = Integer.parseInt(scanner.nextLine());

            presenter.addFamilyMember(name, surname, patronymicName, gender, birthDate, deathDate, motherID, fatherID);
        } else {
            presenter.addFamilyMember(name, surname, patronymicName, gender, birthDate, deathDate);
        }
    }

    @Override
    public void addChild() {
        presenter.addChild();
    }

    private void printMenu(){
        System.out.println(menu.print());
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
}
