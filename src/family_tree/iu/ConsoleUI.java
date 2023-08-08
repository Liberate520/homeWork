package family_tree.iu;

import family_tree.backend.ftree.FamilyTree;
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
        System.out.println("\n --=== FamilyTree loaded... ===-- \n");
        while(workOn){
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            if (choice.matches("^[0-9]$")){
                int choiceInt = Integer.parseInt(choice);
                menu.execute(choiceInt);
            } else {errorInput();}
        }
    }

    public void finish() {
        System.out.println("----------------\nFinished. Bye");
        workOn = false;
        System.exit(0);
    }

    private void errorInput() {
        System.out.println("------------------------\nWrong data. Try again.\n------------------------\n");
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByID() {
        presenter.sortByID();
    }

    public void showTree(){
        presenter.getFamilyTree();
    }
    public void exportTree(){
        presenter.getFamilyTree();
    }
    public void importTree(){
        presenter.getFamilyTree();
    }

//    public void setRelations(){
//        presenter.getFamilyTree();
//    }

    public void showPersonTree(){
        System.out.println("Enter Person ID: ");
        int personId = Integer.parseInt(scanner.nextLine());

        presenter.getPersonTree(personId);

    }
    public void addPerson(){
        String lName = getLastName();
        String fName = getFirstName();
        Gender gender = getGender();
        LocalDate birthDate = getBirthDate();
        presenter.addPerson(lName,fName,gender,birthDate);
        StringBuilder sB = new StringBuilder();
        sB.append("New Person - ");
        sB.append(fName);
        sB.append(" ");
        sB.append(lName);
        sB.append(" (");
        sB.append(gender);
        sB.append("; ");
        sB.append(birthDate);
        sB.append(") added\n");
        inputSuccess(sB.toString());
    }

    public void setRelations(){
        int unitId = getNumId("Enter Person ID: ");
        int relative = getNumId("Enter Relative ID: ");
        String relation = getRelationType();
        if (relation.equals("1")){
            relation = String.valueOf(getNumId("Enter marriage year"));
        } else {relation = "parent";}
        presenter.setRelation(unitId,relative,relation);
        StringBuilder sB = new StringBuilder();
        sB.append("Relation added");
        inputSuccess(sB.toString());
    }

    private int getNumId(String text){
        int num = -1;
        while(num == -1) {
            System.out.println(text);
            String unit = scanner.nextLine();
            if (unit.matches("^\\d+$")) {
                num = Integer.parseInt(unit);
            }
        }
        return num;
    }
    private String getRelationType(){
        System.out.println("Enter RelationType number (any - parent; 1 - spouse,): ");
        return scanner.nextLine();
    }

    private String getFirstName(){
        System.out.println("First Name: ");
        return scanner.nextLine();
    }

    private String getLastName(){
        System.out.println("Last Name: ");
        return scanner.nextLine();
    }

    private Gender getGender(){
        System.out.println("Gender (M/F): ");
        String genderIn = scanner.nextLine();
        Gender result = Gender.Female;
        if (genderIn.equals("M") || genderIn.equals("m")) {
            result = Gender.Male;
        }
        return result;
    }

    private LocalDate getBirthDate(){
        System.out.println("BirthDate(DD/MM/YYYY): ");
        String[] bDate = scanner.nextLine().split("/");
        LocalDate birthDate = LocalDate.of(0,1,1);
        if (bDate.length == 3) {
            birthDate = LocalDate.of(Integer.parseInt(bDate[2]), Integer.parseInt(bDate[1]), Integer.parseInt(bDate[0]));
        }
        return birthDate;
    }

    private void inputSuccess(String info){
        System.out.println("*---------------");
        System.out.printf("* %s", info);
        System.out.println("* Database Dump saved");
        System.out.println("*----------------");

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

}
