package family_tree.view;

import family_tree.model.file_handler.interfaces.ReadAndWrite;
import family_tree.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение!";
    private Scanner scanner;
    private Presenter presenter;
    private boolean working;
    private MainMenu menu;

    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        working = true;
        menu = new MainMenu(this);
    }

    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        hello();
        while (working){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Работа программы завершена.");
        working = false;
    }

    public void loadFamilyTreeFromFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        presenter.loadFamilyTreeFromFile(readAndWrite, path);
    }

    public void viewAllFamilyInfo(){
        presenter.getFamilyTreeInfo();
        System.out.println("Введите ID члена семейного древа: ");
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int id = Integer.parseInt(line);
            presenter.viewAllFamily(id);
        }
    }
    public void sortById() {
        presenter.sortById();
    }
    public void sortByDateOfBirth() {
        presenter.sortByDateOfBirth();
    }
    public void sortByAge() {
        presenter.sortByAge();
    }
    private void hello(){
        System.out.println("Добро пожаловать в программу для изучения семейного древа.");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
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
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

}
