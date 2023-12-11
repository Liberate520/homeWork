package FamilyTree.FamilyTree.View;



import FamilyTree.FamilyTree.Model.Person.Gender;
import FamilyTree.FamilyTree.Presenter.Presenter;
import FamilyTree.FamilyTree.View.Menu.MainMenu;
import FamilyTree.FamilyTree.View.Menu.Menu;
import FamilyTree.FamilyTree.View.Menu.SortMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu main_menu;
    private SortMenu sort_menu;

    private printListWithEOL<String> printList = new printListWithEOL<>();

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        main_menu = new MainMenu(this);
        sort_menu = new SortMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            printMenu(main_menu);
            execute(main_menu);
        }
    }

    public void finish() {
        System.out.println("Закрытие приложения");
        work = false;
    }

    public void getTreeListInfo() {
        printMenu(sort_menu);
        execute(sort_menu);
    }

    public void getNoSortedList(){
        presenter.treeInfo();
    }

    public void getSortedByAge(){
        printList.print(presenter.treeSortedByAge());
    }

    public void getSortedByChildren(){
        printList.print(presenter.treeSortedByChildren());
    }


    public void addPerson() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату Рождения в формате гггг-мм-дд");
        String birthDateStr = scanner.nextLine();
        System.out.println("Укажите дату Смерти в формате гггг-мм-дд");
        String deathDateStr = scanner.nextLine();
        System.out.println("Введите пол Male/Female");
        Gender gender = Gender.valueOf(scanner.nextLine());

        presenter.addPerson(name, gender,birthDateStr, deathDateStr);
    }

    public void setParent() {

        this.getNoSortedList();
        System.out.println("Укажите id человека, для которого надо указать родителя. Id можно посмотреть в списке выше");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите id родителя. Id можно посмотреть в списке выше");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(personId, parentId);
    }

    public void setSpouse() {
        this.getNoSortedList();
        System.out.println("Укажите id человека, для которого надо указать супруга. Id можно посмотреть в списке выше");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите id супруга. Id можно посмотреть в списке выше");
        int spouseId = Integer.parseInt(scanner.nextLine());
        presenter.setSpouse(personId, spouseId);
    }

    public void restoreTree(){
        System.out.println("Укажите путь к файлу для загрузки дерева");
        String path = scanner.nextLine();
        while(!presenter.restoreTree(path)){
            System.out.println("Не удалось загрузить файл. Хотите попробовать снова? y/n");
            if(scanner.nextLine().equals("n")){
                break;
            }
            System.out.println("Укажите путь к файлу для загрузки дерева");
            path = scanner.nextLine();
        }
    }

    public void saveTree(){
        System.out.println("Укажите путь к файлу для сохранения дерева");
        String path = scanner.nextLine();
        while(! presenter.saveTree(path)){
            System.out.println("Не удалось сохранить объект. Хотите попробовать снова? y/n");
            if(scanner.nextLine().equals("n")){
                break;
            }
            System.out.println("Укажите путь к файлу для сохранения дерева");
            path = scanner.nextLine();
        }
    }
    private void execute(Menu menu) {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand,menu)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }


    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
