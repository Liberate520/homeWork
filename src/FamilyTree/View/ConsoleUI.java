package FamilyTree.View;

import FamilyTree.Model.File.FileHandler;
import FamilyTree.Model.File.Writeable;
import FamilyTree.Model.Serviсe;
import FamilyTree.Model.tree.Sex;
import FamilyTree.Model.tree.Tree;
import FamilyTree.Model.tree.TreeAble;
import FamilyTree.Presenter.Presenter;
import FamilyTree.View.Check.ChooseEnum;
import FamilyTree.View.Menu.*;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ConsoleUI implements View {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    private boolean work2;
    private Menu menu;



    public ConsoleUI(TreeAble tree,Writeable fh) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, tree,fh);
        work = true;
        work2 = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
    public void showSubMenu () throws IOException, ClassNotFoundException {
        work2 = true;
        while (work2){
            printMenu();
            execute();
        }

    };

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();
                while (work) {
            printMenu();
            execute();
        }
    }

    public void person() throws IOException, ClassNotFoundException {
        menu = new PersonMenu(this);
        showSubMenu();


    }
    public void file() throws IOException, ClassNotFoundException {
        menu = new FileMenu(this);
       showSubMenu();


        }


    public void tree() throws IOException, ClassNotFoundException {
        menu = new TreeMenu(this);
        showSubMenu();

    }


    public void finish() {
        if (menu.getClass()== MainMenu.class) {System.out.println("Приятно было пообщаться");work =false;}
        else {menu =new MainMenu(this);work2 =false;}

    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }


    public void addPerson() {
        System.out.println("Введите Фамилию Имя Отчество");
        String name = scanner.nextLine();
        ChooseEnum.choose(Sex.class);
        Sex sex = Sex.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения dd.mm.yyyy: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);

        presenter.addPerson(name, sex, birthday);
    }

    private void hello() throws IOException, ClassNotFoundException {
        System.out.println("Доброго времени суток!");
        presenter.load();
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);

            if (checkCommand(numCommand)){
                System.out.println(numCommand);
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

    public void save() throws IOException, ClassNotFoundException {
        presenter.save();
        System.out.println("Сохранение выполнено");
    }

    public void load() throws IOException, ClassNotFoundException {
        presenter.load();
    }


    public void addSpouse() {
        System.out.println("Введите id человека для добавления супруга:");
        Integer id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id  супруга:");
        Integer id2 = Integer.parseInt(scanner.nextLine());

        presenter.addSpouse(id1, id2);
    }

    public void addParents() {
        System.out.println("Введите id человека для добавления родителя:");
        Integer id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id родителя:");
        Integer id2 = Integer.parseInt(scanner.nextLine());
        presenter.addParents(id1, id2);
    }

    public void addChildren() {
        System.out.println("Введите id человека для добавления ребенка:");
        Integer id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id ребенка:");
        Integer id2 = Integer.parseInt(scanner.nextLine());
        presenter.addChildren(id1, id2);
    }


    public void showSpouse() {
        System.out.println("Введите id человека для просмотра супруга:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showSpouse(id));

    }

    public void showChildren() {
        System.out.println("Введите id человека для просмотра детей:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showChildren(id));
    }

    public void showAllPersonInfo() {
        System.out.println("Введите id человека для просмотра полной информации:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showAllPersonInfo(id));
    }

    public void getTreeInfo() {
        presenter.treeGetInfo();
    }


    public void ShowParents() {
        System.out.println("Введите id человека для просмотра родителей:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showParents(id));
    }
}
