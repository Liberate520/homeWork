package View;

import Model.obj.Gender;
import Presenter.Presenter;
import View.Checks.CheckDate;
import View.Checks.CheckID;
import View.Checks.checkGender;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Menu menu;
    private Scanner scanner;
    private Presenter presenter;
    private boolean flag;

    public ConsoleUI() {
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true;
    }

    @Override
    public void start() {
        System.out.println("Hello: ");
        while (flag) {
            System.out.println(menu.menu());
            String line = scanner.nextLine();
            int choise = Integer.parseInt(line);
            menu.choise(choise);
        }
    }

    public void finish() {
        flag = false;
    }

    public void addHuman(){
        System.out.println("Укажите Фамилию человека");
        String fstName = scanner.nextLine();
        System.out.println("Укажите Имя человека");
        String lstName = scanner.nextLine();
        System.out.println("Укажите Дату Рождения человека \nПример: дд.мм.гггг");
        String bornDate1 = scanner.nextLine();
        LocalDate bornDate = checkDate(bornDate1);
        System.out.println("Укажите Дату Смерти человека (Можно пропустить)\nПример: дд.мм.гггг");
        String deathDate1 = scanner.nextLine();
        LocalDate deathDate = checkDate(deathDate1);
        System.out.println("Укажите Пол человека (Male or Female)");
        String gender1 = scanner.nextLine();
        Gender gender = checkGender(gender1);
        presenter.addHuman(fstName,lstName,bornDate,deathDate,gender);
    }

    public void enterAndAddParent(){
        int childId = 9999;
        while (childId == 9999) {
            System.out.println("Укажите ID Ребенка");
            String childID = scanner.nextLine();
            childId = checkID(childID);
        }
        int parentId = 9999;
        while (parentId == 9999){
            System.out.println("Укажите ID Родителя");
            String parentID = scanner.nextLine();
            parentId = checkID(parentID);
        }
        addHumanParent(childId,parentId);
    }

    public void addHumanParent(int childID, int parentID){
        presenter.addHumanParent(childID, parentID);
    }

    private Gender checkGender(String str) {
        return checkGender.checkGender(str);
    }

    private int checkID(String str){
        return CheckID.checkIDs(str);
    }

    private LocalDate checkDate(String str) {
        return CheckDate.checkDate(str);
    }

    public void getHumanList(){
        presenter.getHumanList();
    }

    public void sortByFirstName(){
        presenter.sortByFstName();
    }

    public void sortByLastName(){
        presenter.sortByLstName();
    }

    public void  sortByBornDate(){
        presenter.sortByBornDateName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void saveTree() {
        presenter.saveTree();
    }

    public void readTree() {
        presenter.readTree();
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

}

