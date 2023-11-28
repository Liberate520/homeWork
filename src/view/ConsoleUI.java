package homeWork.src.view;

import homeWork.src.model.member.FamilyMember;
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

//        switch (choice){
//            case "1":
//                addFamilyMember();
//                break;
//            case "2":
//                getFamilyTreeInfo();
//                break;
//            case "3":
//                sortBySurname();
//                break;
//            case "4":
//                sortByBirthdate();
//                break;
//            case "5":
//                save();
//                break;
//            case "6":
//                loadFamilyTree();
//                break;
//            case "7":
//                exit();
//                break;
//            default:
//                error();
//        }
    }

    private void error() {
        System.out.println("Entered wrong parameter.");
    }

    public void exit() {
        System.out.println("Bye-bye");
        check = false;
    }

    public void changeFamilyMember(){
        String name;
        String surname;
        String patronymicName;

        System.out.println("Enter the ID of the member you want to change: ");
        long id = Long.parseLong(scanner.nextLine());

        FamilyMember member = presenter.getFamilyMember(id);

        if(member != null) {
            System.out.println("Change name? Y/N");
            String prompt1 = scanner.nextLine().toLowerCase();
            if (prompt1.equals("y")) {
                System.out.println("Type new name: ");
                name = scanner.nextLine();
            } else {
                name = member.getName();
            }

            System.out.println("Change surname? Y/N");
            String prompt2 = scanner.nextLine().toLowerCase();
            if (prompt2.equals("y")) {
                System.out.println("Type new surname: ");
                surname = scanner.nextLine();
            } else {
                surname = member.getSurname();
            }

            System.out.println("Change patronymic name? Y/N");
            String prompt3 = scanner.nextLine().toLowerCase();
            if (prompt3.equals("y")) {
                System.out.println("Type new patronymic name: ");
                patronymicName = scanner.nextLine();
            } else {
                patronymicName = member.getPatronymicName();
            }

            presenter.changeFamilyMember(id, name, surname, patronymicName);
        }else {
            System.out.println("Family member with ID " + id + " not found.");
        }
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
        System.out.println("Enter gender: ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Enter birthDate: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        presenter.getFamilyTreeInfo();

        System.out.println("Would you like to add parents? Y/N");
        String prompt = scanner.nextLine().toLowerCase();
        if (prompt.equals("y")){
            System.out.println("Select id of mother: ");
            int motherID = Integer.parseInt(scanner.nextLine());

            System.out.println("Select id of father: ");
            int fatherID = Integer.parseInt(scanner.nextLine());

            presenter.addFamilyMember(name, surname, patronymicName, gender, birthDate, motherID, fatherID);
        } else {
            presenter.addFamilyMember(name, surname, patronymicName, gender, birthDate);
        }
    }

    private void printMenu(){
        System.out.println(menu.print());
//        System.out.println("1. Add family member");
//        System.out.println("2. Get family tree info");
//        System.out.println("3. Sort by surname");
//        System.out.println("4. Sort by birthDate");
//        System.out.println("5. Save family tree");
//        System.out.println("6. Load family tree");
//        System.out.println("7. Exit");
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
}
