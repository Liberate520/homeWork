package familyTree.ui;

import familyTree.presenter.Presenter;

import java.io.Serializable;
import java.util.Scanner;

public class Console implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private Serializable serializable;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void finish(){
        System.out.println("Good Bye");
        work = false;
    }

    @Override
    public void addPerson(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter Age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Gender");
        String gender = scanner.nextLine();
        System.out.println("Enter Mother name");
        String mother = scanner.nextLine();
        System.out.println("Enter Father name");
        String father = scanner.nextLine();
        presenter.addPerson(age,gender,name,mother,father);
    }

    @Override
    public void getParents() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        presenter.getParents(presenter.search(name));
    }

    @Override
    public void getChildren() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        presenter.getChildren(presenter.search(name));
    }

    @Override
    public void getGrandParents() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        presenter.getGrandParents(presenter.search(name));
    }

    @Override
    public void getInfoTree() {
        presenter.getInfoTree();
    }

    @Override
    public void sortName() {
        presenter.sortName();
    }

    @Override
    public void sortAge() {
        presenter.sortAge();
    }

    @Override
    public void sortGender() {
        presenter.sortGender();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void hello(){
        System.out.println("Welcome to Family Tree");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void saveFile() {
        System.out.println("Enter Save Path");
        String path = scanner.nextLine();
        presenter.saveFile(serializable,path);
    }

    @Override
    public void readFile() {
        System.out.println("Enter the Path to file");
        String path = scanner.nextLine();
        presenter.readFile(path);
    }
}
