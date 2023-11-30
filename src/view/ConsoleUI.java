package view;

import presenter.Presenter;
import view.consoles.ConsoleRelative;
import view.menu.MainMenu;
import view.menu.Sortmenu;

import java.util.Scanner;

import Animal.Human.Gender;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение!";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private Sortmenu sortmenu;
    private ConsoleRelative consR;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        //presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
        sortmenu = new Sortmenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        init();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("И больше не запускайте это)");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void sortByChildren() {
        presenter.sortByChildren();
    }

    public void getFamalyTreeListInfo() {
        presenter.getFamalyTreeListInfo();
    }

    public void addHuman() {
        System.out.print("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.print("Укажите пол человека 'm,f': ");
        Gender gender = setGender(scanner.nextLine());
        System.out.println("Укажите дату рождения человека ");
        System.out.print("ГГГГ: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("ММ: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("ЧЧ: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Человек еще жив? Y/N ");
        if (scanner.nextLine().equals("N")){
            System.out.print("Укажите дату смерти человека");
            System.out.print("ГГГГ: ");
            int dyear = Integer.parseInt(scanner.nextLine());
            System.out.print("ММ: ");
            int dmonth = Integer.parseInt(scanner.nextLine());
            System.out.print("ЧЧ: ");
            int dday = Integer.parseInt(scanner.nextLine());
            presenter.addHuman(name,year,month,day,dyear,dmonth,dday,gender);
        } else presenter.addHuman(name,year,month,day,gender);
    }

    public void addHumanRelatives(){
        consR = new ConsoleRelative(this);
        consR.work();
    }

    public void saveInFile(){
        System.out.print("Введите имя файла для сохранения: ");
        presenter.saveInFile(scanner.nextLine());
        System.out.println();
    }

    private void hello(){
        System.out.println("Самое время перебрать родословную!");
    }

    private void init(){
        System.out.print("Хотите загрузить генеологическое дерево из файла? Y/N ");
        if (scanner.nextLine().equals("Y")){
            System.out.print("Введите имя файла: ");
            presenter = new Presenter(this,scanner.nextLine());
            if (presenter.getFamalyObject() != null){
                System.out.println();
                getFamalyTreeListInfo();
            } 
            else{
                System.out.println("Создали новое дерево.");
                presenter = new Presenter(this);
            }
        } 
        else {
            System.out.println("Создали новое дерево.");
            presenter = new Presenter(this);
        }
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
    
    private void executesort(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                sortmenu.execute(numCommand);
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
        if (numCommand < menu.getSize()+1){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    public void sortmenu(){
        System.out.println(sortmenu.sortmenu());
        executesort();
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private Gender setGender(String value){
        if (value.equals("m")) return Gender.Male;
        else return Gender.Female;       
    }

    public Presenter getPresenter(){
        return this.presenter;
    }
}