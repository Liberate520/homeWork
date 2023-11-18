package view;

import Model.home_work_class.Human.Gender;
import Model.home_work_class.Human.Human;
import Presenter.Presenter;
import view.Commands.MainMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu menu;
    private boolean work;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.menu = new MainMenu(this);
        this.work = true;
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void startMenu() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void printMenu(){
        System.out.println(this.menu.menu());
    }

    private void execute(){
        System.out.println("Выберите пункт: ");
        String choice = scanner.nextLine();
        if (checkTextForInt(choice)){
            int numCommand = Integer.parseInt(choice);
            if (checkCommand(numCommand)){
                this.menu.execute(numCommand - 1);
            }
        }
    }

    private void hello(){System.out.println("Здравствуйте.");}

    public void finish(){
        System.out.println("Досвидания!");
        this.work = false;
    }

    private void inputError(){System.out.println("Вы указали неверный пункт меню\n");}

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize() && numCommand > 0){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void addHuman() {
        System.out.println("Введите имя: (обязательно)");
        String name = scanner.nextLine();
        System.out.println("Введите пол: 1.Мужской, Другое - Женский: (обязательно)");
        String choiceGender = scanner.nextLine();
        Gender gender = Gender.Male;
        if (! choiceGender.equals("1")) {
            gender = Gender.Female;
        }
        System.out.println("Введите дату рождения: (обязятельно)");
        LocalDate dataBorn = getDateToString();
        System.out.println("Пропустить дату смерти? 1. Да, Другое - нет");
        String choiceDiedDate = scanner.nextLine();
        LocalDate diedDate = null;
        if (! choiceDiedDate.equals("1")){ diedDate = getDateToString(); }
        System.out.println("Заполнить детей? 1. Да, Другое - нет");
        String choiceChildren = scanner.nextLine();
        List<Human> childrenList = new ArrayList<>();
        if (! choiceChildren.equals("1")){
            addChildren(childrenList);
        }
        presenter.addHuman(name, gender, dataBorn, diedDate);
    }
    private LocalDate getDateToString(){
        System.out.println("день");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("месяц");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("год");
        int year = Integer.parseInt(scanner.nextLine());

        return LocalDate.of(year, month, day);
    }

    private void addChildren(List<Human> childrens){

    }

    public void fileWriter(){
        presenter.fileWriter();
    }

    public void fileRead(){
        presenter.fileReader();
    }

    public void sortByName() {
        presenter.SortByName();
    }

    public void sortByAge() {
        presenter.SortByAge();
    }

    public void sortById() {
        presenter.SortById();
    }
}
