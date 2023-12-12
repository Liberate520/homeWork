package homeWork.src.view;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.tree.Gender;
import homeWork.src.presenter.Presenter;
import homeWork.src.presenter.Presenter2;

import java.util.Scanner;

public class ConsoleUI2 implements View2{
    private Scanner scanner;
    private Presenter2 presenter2;
    private boolean check;
    private MainMenu2 menu2;
    private FamilyMember familyMember;
    private long familyMemberID;

    public ConsoleUI2(Presenter presenter){
        scanner = new Scanner(System.in);
        presenter2 = new Presenter2(presenter, this);
        check = true;
        menu2 = new MainMenu2(this);
    }
    @Override
    public void start() {
        System.out.println("Enter the ID of the member you want to change: ");
        familyMemberID = Long.parseLong(scanner.nextLine());
        System.out.println(presenter2.getMember(familyMemberID));
        while (check){
            printMenu();
            scanMenu();
        }
    }

    @Override
    public void answer(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public void changeName() {
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        presenter2.changeName(familyMemberID, name);
    }

    @Override
    public void changeSurname() {
        System.out.println("Enter new surname: ");
        String surname = scanner.nextLine();
        presenter2.changeSurname(familyMemberID, surname);
    }

    @Override
    public void changePatronymicName() {
        System.out.println("Enter new patronymic name: ");
        String patronymicName = scanner.nextLine();
        presenter2.changePatronymicName(familyMemberID, patronymicName);
    }

    @Override
    public void changeGender() {
        System.out.println("Enter new gender: ");
        String gender = scanner.nextLine();
        presenter2.changeGender(familyMemberID, gender);
    }

    @Override
    public void changeBirthDate() {
        presenter2.changeBirthDate(familyMember);
    }

    @Override
    public void changeDeathDate() {
        presenter2.changeDeathDate(familyMember);
    }

    @Override
    public void changeSpouse() {
        System.out.println("Enter the ID of the spouse member: ");
        long spouseID = Long.parseLong(scanner.nextLine());
        presenter2.changeSpouse(familyMemberID, spouseID);
    }

    @Override
    public void changeMother() {
        System.out.println("Enter the ID of the mother member: ");
        long motherID = Long.parseLong(scanner.nextLine());
        presenter2.changeMother(familyMemberID, motherID);
    }

    @Override
    public void changeFather() {
        System.out.println("Enter the ID of the father member: ");
        long fatherID = Long.parseLong(scanner.nextLine());
        presenter2.changeFather(familyMemberID, fatherID);
    }

    @Override
    public void exit() {
        check = false;
    }

    public void printMenu(){
        System.out.println(menu2.print());
    }

    private void scanMenu(){
        String strChoice = scanner.nextLine();
        // метод проверки на валидность введенной строки
        int choice = Integer.parseInt(strChoice);
        menu2.execute(choice);
    }
}
