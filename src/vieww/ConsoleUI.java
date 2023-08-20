package vieww;

import presenterr.Presenter;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import modell.human.Gender;

public class ConsoleUI implements View {
    private Scanner scanner = new Scanner(System.in);
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    public ConsoleUI() {
        presenter = new Presenter(this);
        menu = new Menu(this);
        work = true;
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        presenter.loadTreeFromFile();
        while (work) {
            print(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
    }
    
    public void getHumanList(){
        presenter.getHumanList();
    }

    public void saveToFile() {
        presenter.saveToFile();
    }

    public void addHuman () {
        String name;
        Gender userGender;
        LocalDate birthDate = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long idFather;
        long idMother;

        print("Enter the name: ");
        name = scanner.nextLine();
        
        while (true) {
            print("Please select the gender:");
            Gender[] genders = Gender.values();
            for (int i = 0; i < genders.length; i++) {
                print((i + 1) + ". " + genders[i]);
            }
        
            System.out.print("Enter the number corresponding to your choice: ");
            int choice;
        
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
        
                if (choice >= 1 && choice <= genders.length) {
                    userGender = genders[choice - 1];
                    break;
                } else {
                    print("Invalid choice. Please enter a valid number.");
                }
            } else {
                print("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }        

        while (birthDate == null) {
            print("Please enter the birth date (YYYY-MM-DD): ");
            String inputDate = scanner.nextLine();

            try {
                birthDate = LocalDate.parse(inputDate, dateFormatter);
            } catch (Exception e) {
                print("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }

        print("Enter the id of Father or -1 if it is undefined: ");
        idFather = scanner.nextLong();

        print("Enter the id of Mother or -1 if it is undefined: ");
        idMother = scanner.nextLong();
        print("");
        scanner.nextLine();

        presenter.addHuman(name, userGender, birthDate, idFather, idMother);
    }

    public void removeHuman() {
        print("Enter the id of human you want to delete: ");
        long humansId = scanner.nextLong();
        print("");
        scanner.nextLine();

        presenter.removeHuman(humansId);
    }

    public void setWedding() {
        print("Enter the id of human 1: ");
        long humanId1 = scanner.nextLong();
        print("Enter the id of human 2: ");
        long humanId2 = scanner.nextLong();
        
        print("");
        scanner.nextLine();

        presenter.setWedding(humanId1, humanId2);
    }

    public void setDivorce() {
        print("Enter the id of human 1: ");
        long humanId1 = scanner.nextLong();
        print("Enter the id of human 2: ");
        long humanId2 = scanner.nextLong();
        
        print("");
        scanner.nextLine();

        presenter.setDivorce(humanId1, humanId2);
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void exit() {
        work = false;
        print("Exiting the program...");
    }
}
