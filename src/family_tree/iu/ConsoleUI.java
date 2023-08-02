package family_tree.iu;

import family_tree.backend.person.Gender;
import family_tree.gate.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements BaseUI{
    private Presenter presenter;
    private Scanner scanner;
    private boolean workOn;
    private MainMenu menu;

    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        workOn = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        presenter.initBase();
        System.out.println("\n --=== FamilyTree ===-- \n");
        while(workOn){
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
        }
    }

    public void finish() {
        System.out.println("Finished");
        workOn = false;
        System.exit(0);
    }

    private void errorInput() {
        System.out.println("Wrong data");
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void showTree(){

        presenter.getFamilyTree();

    }
    public void addPerson(){
        System.out.println("Last Name: ");
        String lName = scanner.nextLine();
        System.out.println("First Name: ");
        String fName = scanner.nextLine();
        System.out.println("Gender (M/F): ");
        String genderIn = scanner.nextLine();
        Gender gender;
        if (genderIn != "M" || genderIn != "m") {
            gender = Gender.Female;
        } else {
            gender = Gender.Male;
        }
        System.out.println("BirthDate(DD/MM/YYYY): ");
        String[] bDate = scanner.nextLine().split("/");
        LocalDate birthDate;
        if (bDate.length == 3) {
            birthDate = LocalDate.of(Integer.parseInt(bDate[2]), Integer.parseInt(bDate[1]), Integer.parseInt(bDate[0]));
        } else {
            birthDate = LocalDate.of(0,1,1);
        }

        presenter.addPerson(lName,fName,gender,birthDate);

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

}
