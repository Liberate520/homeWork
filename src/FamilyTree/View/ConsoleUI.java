package FamilyTree.View;

import FamilyTree.Presenter.Presenter;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getStudentsListInfo() {
        presenter.treeGetInfo();
    }

    public void addPerson() {
        System.out.println("Введите Фамилию Имя Отчество");
        String name = scanner.nextLine();
        System.out.println("Выберите пол:" +
                "1. -Мужской" +
                "2. -Женский");
        String sex = scanner.nextLine();
        while ((sex=="1" || sex=="2)")) {
            System.out.println("Вы ошиблись. Выберите пол:" +
                    "1. -Мужской" +
                    "2. -Женский");
            sex = scanner.nextLine();

        }
        System.out.println("Введите дату рождения dd.mm.yyyy: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);

        presenter.addPerson(name, sex, birthday);
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void execute(){
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
}
