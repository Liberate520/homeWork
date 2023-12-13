package view;

import model.exception.HumanExcistsException;
import model.writer.Writable;
import presenter.Presenter;
import java.io.Console;
import java.util.Scanner;
import model.human.Gender;
import java.io.IOException;

public class ConsoleUI implements View {
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

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void getFamilyInfo(){
        presenter.getFamilyInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию человека");
        String lastName = scanner.nextLine();
        System.out.println("Введите пол (Male, Female): ");
        Gender gender = checkGender();
        try {
            presenter.addHuman(name, lastName, gender);
        } catch (HumanExcistsException e) {
            System.out.println(e.getMessage());
        }
    }
    private Gender checkGender() {
        String answer = null;
        boolean i = true;
        while (i) {
            answer = scanner.nextLine();
            if (answer.equals("Male") || answer.equals("Female")) {
                i = false;
            }
            else System.out.println("Неверное значение. Попробуйте еще раз.");
        }
        return Gender.valueOf(answer);
    }

    public void hello(){
        System.out.println("Доброго времени суток!");
    }

    public void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    public void addBirthdate() {
        System.out.println("Введите Id");
        int id = checkId();
        System.out.println("Введите год рождения");
        int year = checkInt();
        System.out.println("Введите месяц рождения");
        int month = checkInt();
        System.out.println("Введите день рождения");
        int day = checkInt();
        if (presenter.setBirthday(id, year, month, day)) {
            success();
        }
        else {
            System.out.println("Дата указана неверно!");
            error();
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
                System.out.println("Неверное значение! Введите целое число.");
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

    public void addDeathdate() {
        System.out.println("Введите Id");
        int id = checkId();
        System.out.println("Введите год смерти");
        int year = checkInt();
        System.out.println("Введите месяц смерти");
        int month = checkInt();
        System.out.println("Введите день смерти");
        int day = checkInt();
        if (presenter.setDeathdate(id, year, month, day)) {
            success();
        }
        else {
            error();
        }
    }
    public void addSpouse() {
        System.out.println("Введите ID одного из супругов: ");
        int one = checkId();
        System.out.println("Введите ID второго супруга: ");
        int two = checkId();
        if (one == two) {
            System.out.println("Id одинаковы. Данные не добавлены.");
        }
        else {
            presenter.addSpouse(one, two);
        }
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
    public void infoById() {
        System.out.println("Введите ID: ");
        int id = checkId();
        presenter.getBodyInfoById(id);
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")) {
            return true;
        }else{
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        }else{
            inputError();
            return false;
        }
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }

    public void load(){
        try {
            presenter.load();
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save(){
        if (presenter.save()){
            success();
        }
        else{
            error();
        }
    }
    private void success(){
        System.out.println("Данные сохранены");
    }

    private void error(){
        System.out.println("Данные не записаны");
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

}
