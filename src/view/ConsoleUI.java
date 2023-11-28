package view;

import presenter.Presenter;

import java.util.Scanner;

import Animal.Human.Gender;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private Sortmenu sortmenu;

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
        System.out.println("И больше не запускайте это");
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
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.println("Укажите пол человека 'м,ж': ");
        Gender gender = setGender(scanner.nextLine());
        System.out.println("Укажите дату рождения человека: ГГГГ.ММ.ЧЧ: ");
        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Человек еще жив? 'Y'\'N'");
        if (scanner.nextLine().equals("N")){
            System.out.println("Укажите дату смерти человека: ГГГГ.ММ.ЧЧ: ");
            int dyear = Integer.parseInt(scanner.nextLine());
            int dmonth = Integer.parseInt(scanner.nextLine());
            int dday = Integer.parseInt(scanner.nextLine());
            presenter.addHuman(name,year,month,day,dyear,dmonth,dday,gender);
        } else presenter.addHuman(name,year,month,day,gender);
    }

    public void addHumanRelatives(){
        System.out.println("Введите id первого человека: ");
        int id0 = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id второго человека: ");
        int id1 = Integer.parseInt(scanner.nextLine());
        String name0 = presenter.getHumanId(id0).getName();
        String name1 = presenter.getHumanId(id1).getName();
        System.out.println("Кем является "+name1+" для "+name0+":\n" + //
                "\t 1-отцом;\n\t2-матерью;\n" + //
                "\t3-супругом;\n\t4-ребенком");
        int index = Integer.parseInt(scanner.nextLine());
        presenter.addHumanRelatives(id0, id1, index);
    }

    public void saveInFile(){
        System.out.println("Введите имя файла для сохранения:");
        presenter.saveInFile(scanner.nextLine());
    }

    private void hello(){
        System.out.println("Самое время перебрать родословную!");
    }

    private void init(){
        System.out.println("Хотите загрузить генеологическое дерево из файла? Y/N");
        if (scanner.nextLine().equals("Y")){
            System.out.println("Введите имя файла: ");
            presenter = new Presenter(this,scanner.nextLine());
            System.out.println();
            getFamalyTreeListInfo();
        } 
        else {
            System.out.println("Создали пустое дерево");
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
}