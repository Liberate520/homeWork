package family_tree.view;

import family_tree.model.creatures.enums.Gender;
import family_tree.model.file_handler.interfaces.ReadAndWrite;
import family_tree.presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
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

    public void addMember(){
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        Gender gender = null;
        while (gender == null){
            System.out.println("Выберете пол из представленного списка: ");
            gender = selectGender();
        }
        String date;
        do {
            System.out.println("Введите дату рождения (в формате дд/мм/гггг): ");
            date = scanner.nextLine();
        } while (presenter.getDate(date) == null);
        LocalDate dateOfBirth = presenter.getDate(date);
            do {
                System.out.println("Введите дату смерти (в формате дд/мм/гггг): ");
                date = scanner.nextLine();
            } while (presenter.getDate(date) == null & date.isEmpty() == false);
        if (date.isEmpty()){
            presenter.addHuman(firstName,lastName,gender,dateOfBirth,null);
        }else{
            LocalDate dateOfDeath = presenter.getDate(date);
            presenter.addHuman(firstName,lastName,gender,dateOfBirth,dateOfDeath);
        }
    }

    public Gender selectGender(){
        presenter.listOfGenders();
        System.out.println("Введите номер нужного пола: ");
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int idGender = Integer.parseInt(line);
            return presenter.getGender(idGender);
        }
        System.out.println("Выберете правильный номер!");
        return null;
    }

    public void addMother(){
        presenter.getFamilyTreeInfo();
        System.out.println("Введите ID человека, которому хотите добавить мать: ");
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int idChild = Integer.parseInt(line);
            System.out.println("Введите ID человека, который будет матерью: ");
            line = scanner.nextLine();
            if (checkTextForInt(line)){
                int idMother = Integer.parseInt(line);
                presenter.addMother(idChild,idMother);
            }
        }
    }

    public void addFather(){
        presenter.getFamilyTreeInfo();
        System.out.println("Введите ID человека, которому хотите добавить отца: ");
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int idChild = Integer.parseInt(line);
            System.out.println("Введите ID человека, который будет отцом: ");
            line = scanner.nextLine();
            if (checkTextForInt(line)){
                int idFather = Integer.parseInt(line);
                presenter.addFather(idChild,idFather);
            }
        }
    }

    public void loadFamilyTreeFromFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        presenter.loadFamilyTreeFromFile(readAndWrite, path);
    }
    public void saveFamilyTreeInFile (ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        presenter.saveFamilyTreeInFile(readAndWrite, path);
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
