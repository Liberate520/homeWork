package src.UI;

import src.FamilyTree.Sex;
import src.Presenter.Presenter;

import java.util.Scanner;



public class Console implements View{

    private Scanner scanner= new Scanner(System.in);
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    private Sex sex;


    public Console() {
    }

    @Override
    public void start() {
        System.out.println("\n\tYou have started working with the Romanov Family Tree project");
        System.out.println("You can view the part of the project that has already been done,\ndelete a family member or add new family members.");
        menu = new Menu(this);
        work = true;
        while(work){
            comandList();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Something went wrong");
            }
        }
        scanner.close();
    }

    public void comandList(){
        System.out.println(menu.printMenu());
    }

    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }

    public void finish() {
        work = false;
    }

    public void printingListOfPersons(){
        presenter.printingListOfPersons();
    }

    public void yearsOfTheReignOfPersons(){
        presenter.yearsOfTheReignOfPersons();
    }

    public void getPersonByName(){
        print("Enter the Person's name: \n");
        presenter.getPersonByName(scanner.nextLine());
    }

    public void findSpouse(){
        print("Enter the Person's name: \n");
        presenter.findSpouse(scanner.nextLine());
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }

    public void load() {
        presenter.load();
    }
    public void save() {
        presenter.save();
    }

    public void addPerson() {
        print("Enter the Person's name: \n");
        String childName = scanner.nextLine();
        print("Enter the Person's year of birth (for example \"1687\"):\n");
        Integer birthDay = Integer.parseInt(scanner.nextLine());
        print("enter the year of the Person's death (for example \"1765\"): \n");
        Integer deathDay = Integer.parseInt(scanner.nextLine());
        sex = inSex();
        String additionalField = additionalField();
        if(presenter.addPersonToTree( childName, birthDay, deathDay, sex, additionalField)){
            System.out.println("\nThe person has been successfully added to the family tree\n");
        }
        else {
            System.out.println("The record PERSON already exists or an error has occurred");}

    }

    public void addWifeToHusband() {
        print("Enter the Husband's name: \n");
        String husbandName = scanner.nextLine();
        print("Enter the Wife's name: \n");
        String wifedName = scanner.nextLine();
        print("Enter the Wife's year of birth (for example \"1687\"):\n");
        Integer birthDay = Integer.parseInt(scanner.nextLine());
        print("enter the year of the Wife's death (for example \"1765\"): \n");
        Integer deathDay = Integer.parseInt(scanner.nextLine());
        sex = inSex();
        String additionalField = additionalField();
        if (presenter.addWifeToHusband(husbandName, wifedName, birthDay, deathDay, sex, additionalField)){
            System.out.println("\nThe wife was successfully added to the spouse\n");
        }
        else {
            System.out.println("The record WIFE already exists or an error has occurred");
        }
    }

    public void addChildToMother() {
        print("Enter the Mother's name: \n");
        String motherName = scanner.nextLine();
        print("Enter the Child's name: \n");
        String childName = scanner.nextLine();
        print("Enter the child's year of birth (for example \"1687\"):\n");
        Integer birthDay = Integer.parseInt(scanner.nextLine());
        print("enter the year of the child's death (for example \"1765\"): \n");
        Integer deathDay = Integer.parseInt(scanner.nextLine());
        sex = inSex();
        String additionalField = additionalField();
        if (presenter.addChildToMother(motherName, childName, birthDay, deathDay, sex, additionalField)) {
            System.out.println("\nThe Child was successfully added to the Mother\n");
        }
        else {
            System.out.println("The record CHILD already exists or an error has occurred");
        }
    }

    public src.FamilyTree.Sex inSex() {
        boolean yes = false;
        while (!yes) {

            System.out.println("Enter the gender of the child (\"male\' or \"female\"): \n");
            String inpSex = scanner.nextLine();
            if(inpSex.equals("male")) {
                sex = Sex.Male;
                yes = true;
            } else if (inpSex.equals("female")) {
                sex = Sex.Female;
                yes = true;
            }

        }
        return sex;
    }
    public String additionalField() {
        String addField = new String();
        System.out.println("Enter the reign years in the format \"1678-1789\" or \"n\" if the child did not reign: \n");
        addField = scanner.nextLine();
        if (addField.equals("n")) {
            return null;
        }
        return addField;
    }


}
