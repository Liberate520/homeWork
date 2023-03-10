
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("Enter name of a child: ");
        String name = scanner.nextLine();
        String gender = enterGender();
        Integer birthYear = scanner.nextInt();
        System.out.println("Enter father name: ");
        String fatherName = scanner.nextLine();
        System.out.println("Enter mother name: ");
        String motherName = scanner.nextLine();
        if(presenter.addEntry(name, gender, birthYear, fatherName, motherName)){
            System.out.println("Person successfully added to the tree.");
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

    public void save() throws FileNotFoundException {
        presenter.save();
        print("Saved.");
    }
    public void load() throws FileNotFoundException, IOException {
        presenter.load();
        showAllEntries();
    }
}