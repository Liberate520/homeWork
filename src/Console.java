
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Console implements View{
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    @Override
    public void start() throws NumberFormatException, IOException {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Wrong command number.");
            }
        }
    }
    private boolean checkInput(String text){
        if (text.matches("[0-9]+")) {
            return  Integer.parseInt(text) <= menu.getCommands().size();
        } else {
            return false;
        }
    }
    private void hello() {
        print("Choose menu option: ");
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    public void finish(){
        work = false;
    }
    public void addEntry(){
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();

        System.out.println("пол: ");
        String gender = enterGender();

        System.out.println("Введите год рождения: ");
        Integer birthYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите имя отца: ");
        String fatherName = scanner.nextLine();
       
        System.out.println("Введите имя матери: ");
        String motherName = scanner.nextLine();

        if(presenter.addEntry(name, gender, birthYear, fatherName, motherName)){
            System.out.println("Человек добавлен");
        }
    }
    public void showEntry(){
        print("Enter name: ");
        presenter.showEntry(scanner.nextLine());
    }
    public void showAllEntries() {
        presenter.showAllEntries();
    // }
    // public void deleteEntry() {
    //     print("Enter name for deletion: ");
    //     if (presenter.deleteEntry(scanner.nextLine())) {
    //         print("Successfully deleted");
    //     }
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    public String enterGender(){
        String gender = "";
        boolean validGender = false;
        while (!validGender) {
            System.out.println("Enter gender (m/f): ");
            gender = scanner.nextLine();
            validGender = gender.equalsIgnoreCase("m") ||
                    gender.equalsIgnoreCase("f");
        }
        return gender;
    }

    // private String enterBirthYear() {
    //     String birthYear = "";
    //     Date birthDate = new Date(0);
    //     boolean birtYearIsValid = false;
    //     while (!birtYearIsValid) {
    //         System.out.println("Enter birth year: ");
    //         try {
    //             birthYear = scanner.nextLine();
    //             birthDate = new SimpleDateFormat("yyyy").parse(birthYear);
    //             birtYearIsValid = true;
    //         } catch (ParseException e) {
    //             System.out.println("Wrong birth year.");
    //         }
    //     }
    //     return birthYear;
    // }


    public void save() throws FileNotFoundException {
        presenter.save();
        print("Saved.");
    }
    public void load() throws FileNotFoundException, IOException {
        presenter.load();
        showAllEntries();
    }
}