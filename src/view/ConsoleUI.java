package view;

import java.io.IOException;
import java.util.Scanner;

import model.human.Gender;
import presenter.Presenter;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Ввели неверное значение";
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
            choice();
        }
    }

    private void printMenu(){
        System.out.println("Выберите пункт меню");
        System.out.println(menu.menu());
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void choice(){
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

    public void addHuman() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println("Введите пол (Male, Female): ");
        Gender gender = checkGender();
        presenter.addHuman(name, surname, gender);
    }

    private Gender checkGender() {
        String answer = null;
        boolean i = true;
        while (i) {
            answer = scanner.nextLine();
            if (answer.equals("Male") || answer.equals("Female")) {
                i = false;
            }
            else System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
        }
        return Gender.valueOf(answer);
    }

    public void addChild() {
        System.out.println("Введите ID родителя: ");
        int parentId = checkId();
        System.out.println("Введите ID ребенка: ");
        int childId = checkId();
        if (parentId == childId) {
            System.out.println("Id одинаковы. Данные не добавлены.");
        }
        else {
            presenter.addChild(parentId, childId);
        }
    }

    private int checkInt() {
        int value = 0;
        boolean i = true;
        while (i) {
            String text = scanner.nextLine();
            if (text.matches("[0-9]+")){
                value = Integer.parseInt(text);
                i = false;
            } else {
                System.out.println("Значение неверное. Введите целое число.");
            }
        }
        return value;
    }

    private int checkId() {
        boolean i = true;
        int id = 0;
        while (i) {
            id = checkInt();
            if (presenter.checkId(id)) {
                i = false;
                return id;
            }
            else System.out.println("Человек с таким Id не найден. Введите другое значение.");
        }
        return id;
    }

    public void getHumansListInfo() {
        presenter.getHumansListInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortBySurname() {
        presenter.sortBySurname();
    }

    public void finish() {
        System.out.println("Ждем Вашего возвращения для продолжения работы");
        scanner.close();
        work = false;
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }


    //добавим исключения
    public void load() {
        try {
        presenter.load();
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write() {
        presenter.write();
    }

}
