package view;

import Model.FamTreeModel.FileWork.FileWork;
import Model.FamTreeModel.Human.Gender;
import Presenter.Presenter;
import java.util.Scanner;


public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;

    private boolean work;
    private ConsoleMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new ConsoleMenu(this);
    }

    public void finish() {

        work = false;
    }
    public void writeInFile(){
        System.out.println("Введите путь к файлу/имя файла:");
        String path = scanner.nextLine();
        presenter.saveTree(path);
    }
    public void loadFromFile(){
        System.out.println("Введите путь к файлу/имя файла:");
        String path = scanner.nextLine();
        presenter.loadTree(path);
    }
    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя:");
        String fname = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lname = scanner.nextLine();
        System.out.println("Введите пол:");
        Gender sex = Gender.valueOf(scanner.nextLine());
        boolean flag = false;
        while (!flag) {
            System.out.println("Укажите возраст:");
            String ageString = scanner.nextLine();
            //сделать проверку ввода возраста
            int age = Integer.parseInt(ageString);
            if ((age < 0) || (age > 150)) {

                System.out.println("Не валидное значение! ");
            } else {
                flag = true;
            }

            presenter.addHuman(fname, lname, sex, age);
        }
    }
    public void addChildren() {
        System.out.println("Введите ID родителя:");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Введите данные ребенка: ");
        System.out.println("Введите имя:");
        String fname = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lname = scanner.nextLine();
        System.out.println("Введите пол:");
        Gender sex = Gender.valueOf(scanner.nextLine());
        boolean flag = false;
        int age = 0;
        while (!flag) {
            System.out.println("Укажите возраст:");
            String ageString = scanner.nextLine();
            //сделать проверку ввода возраста
            age = Integer.parseInt(ageString);
            if ((age < 0) || (age > 150)) {

                System.out.println("Не валидное значение! ");
            } else {
                flag = true;
            }
        }
//
        presenter.servise.addHuman(fname, lname, sex, age);
        presenter.addHumanChildrenById(id, fname, lname, sex, age);
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

    @Override
    public void getAnsw(String rep) {
        System.out.println(rep);
    }

    @Override
    public void start() {
    while (work){
        printMenu();
        execute();
    }
    }
}