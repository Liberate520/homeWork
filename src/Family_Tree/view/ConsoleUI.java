package Family_Tree.view;

import Family_Tree.model.Human.Gender;
import Family_Tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu=new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добрый день!");
        while (work){
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    private void error() {
        System.out.println("Вы ввели неверное значение");
    }

    public void finish() {
        System.out.println("До новых встреч");
        work=false;
    }

    public void sortByBirthday() {
        presenter.sortByBirthday();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        printMenu(menu);
        execute(menu);
    }

    private void execute(MainMenu menu) {
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
            error();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, MainMenu menu) {
        if (numCommand <= menu.size()) {
            return true;
        } else {
            error();
            return false;
        }
    }


    private void printMenu(MainMenu print) {
        System.out.println(print.print());
    }

    public void add() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения в формате гггг-мм-дд");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите пол Female/Male");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.add(name, birthday, gender);
    }


    private void printMenu(){
        System.out.println(menu.print());
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }

    public void addToParents() {
        System.out.println("Укажите id человека, для которого надо указать родителя");
        int humanId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите id родителя");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.addToParents(humanId, parentId);
    }

}
