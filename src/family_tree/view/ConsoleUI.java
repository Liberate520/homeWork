package family_tree.view;

import family_tree.model.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void print(String txt) {
        System.out.println(txt);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }
    public void finish() {
        System.out.println("До свидания!");
        work = false;
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

    public boolean addHuman(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате \"dd-MMM-yyyy\": ");
        String date = scanner.nextLine();
        LocalDate dateBirth = null;
        try {
            String[] splitted = date.split("-");
            int y = Integer.parseInt( splitted[2] );
            int m = Integer.parseInt( splitted[1] );  // 1-12 for January-December.
            int d = Integer.parseInt( splitted[0] );
            dateBirth = LocalDate.of(y, m, d);
        } catch (Exception  e) {
            System.out.println("Ошибка ввода данных даты");
            return false;
        }
        System.out.println("Введите пол: м или ж");
        String genderStr = scanner.nextLine();
        if(genderStr.length()==0) return false;
        Gender gender=null;
        if(genderStr.charAt(0) == 'м') gender = Gender.Male;
        else if(genderStr.charAt(0) == 'ж') gender = Gender.Female;
        else return false;

        presenter.addHuman(name, dateBirth, gender);
        presenter.printLastHuman();
        return true;
    }

    public boolean addChild(){
        int idParent=0, idChild=0;
        System.out.println("Введите id родителя: ");
        try {
            idParent = Integer.parseInt(scanner.nextLine());
        } catch (Exception  e) {
            System.out.println("Ошибка ввода id родителя");
            return false;
        }
        System.out.println("Введите id потомка: ");
        try {
            idChild = Integer.parseInt(scanner.nextLine());
        } catch (Exception  e) {
            System.out.println("Ошибка ввода id потомка");
            return false;
        }
        return presenter.addChild(idParent, idChild);
    }

    public boolean addMarriage(){
        int idWife=0, idHusband=0;
        System.out.println("Введите id невесты: ");
        try {
            idWife = Integer.parseInt(scanner.nextLine());
        } catch (Exception  e) {
            System.out.println("Ошибка ввода id невесты");
            return false;
        }
        System.out.println("Введите id жениха: ");
        try {
            idHusband = Integer.parseInt(scanner.nextLine());
        } catch (Exception  e) {
            System.out.println("Ошибка ввода id жениха");
            return false;
        }
        System.out.println("Введите дату бракосочетания в формате \"dd-MMM-yyyy\": ");
        String date = scanner.nextLine();
        LocalDate dateMarriage = null;
        try {
            String[] splitted = date.split("-");
            int y = Integer.parseInt( splitted[2] );
            int m = Integer.parseInt( splitted[1] );  // 1-12 for January-December.
            int d = Integer.parseInt( splitted[0] );
            dateMarriage = LocalDate.of(y, m, d);
        } catch (Exception  e) {
            System.out.println("Ошибка ввода данных даты");
            return false;
        }
        boolean flag = presenter.addMarriage(dateMarriage, idWife, idHusband);
        if(flag) presenter.printLastMarriage();
        return flag;
    }

    public boolean stopMarriage() {
        System.out.println("Введите дату расторжения брака в формате \"dd-MMM-yyyy\": ");
        String date = scanner.nextLine();
        LocalDate dateMarriage = null;
        try {
            String[] splitted = date.split("-");
            int y = Integer.parseInt( splitted[2] );
            int m = Integer.parseInt( splitted[1] );  // 1-12 for January-December.
            int d = Integer.parseInt( splitted[0] );
            dateMarriage = LocalDate.of(y, m, d);
        } catch (Exception  e) {
            System.out.println("Ошибка ввода данных даты");
            return false;
        }
        int idMarriage=0;
        System.out.println("Введите id брака: ");
        try {
            idMarriage = Integer.parseInt(scanner.nextLine());
        } catch (Exception  e) {
            System.out.println("Ошибка ввода id");
            return false;
        }
        return presenter.stopMarriage(dateMarriage, idMarriage);
    }

    public void sortByAge(){
        presenter.sortHumansByAge();
    }
    public void sortByName(){
        presenter.sortHumansByName();
    }

    public void printInfoTree(){
        presenter.printInfoTree();
    }

    public void saveToFile(){
        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();
        if(presenter.saveToFile(path)){
            System.out.println("Запись успешно выполнена");
        }else{
            System.out.println("Ошибка записи файла");
        }
    }

    public void loadFromFile(){
        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();
        if(presenter.loadFromFile(path)){
            System.out.println("Чтение успешно выполнено");
        }else{
            System.out.println("Ошибка чтения файла");
        }
    }
}
