package familyTree.View;

import familyTree.Model.PersonPack.Gender;
import familyTree.Presenter.Presenter;
import familyTree.View.Menus.MainMenu;
import familyTree.View.Menus.Menu;
import familyTree.View.Menus.SortMenu;

import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu main_menu;
    private SortMenu sort_menu;

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
        presenter.treeSortedByAge();
    }

    public void getSortedByChildren(){
        presenter.treeSortedByChildren();
    }
    public void addPerson() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату в формате гггг-мм-дд");
        String dateString = scanner.nextLine();
        System.out.println("Введите пол female/male");
        Gender gender = Gender.valueOf(scanner.nextLine());

        presenter.addPerson(name, gender, dateString);
    }

    public void setParent() {

        this.getNoSortedList();
        System.out.println("Укажите id человека, для которого надо указать родителя. Id можно посмотреть в списке выше");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите id родителя. Id можно посмотреть в списке выше");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(personId, parentId);
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

