package view;

import model.Gender;
import model.Person;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    public void addPerson(){
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество: ");
        String surName = scanner.nextLine();
        System.out.println("Введите год рождения: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения: ");
        int monthOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения: ");
        int dayOfBirth = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println("Введите пол: ");
        Gender gender = genderInput(scanner.nextLine());
        presenter.addPerson(firstName, lastName, surName, dateOfBirth, gender);
    }

    private Gender genderInput(String input){
        if (input.toLowerCase().contains("м")){
            return Gender.Male;
        }else return Gender.Female;
    }
    public void getHumanListInfo(){
        presenter.getHumanListInfo();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void findPerson(){
        System.out.println("Введите имя для поиска: ");
        String name = scanner.nextLine();
        presenter.findPerson(name);
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

    @Override
    public void printPerson(Person person) {
        System.out.println(person);
    }

    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void execute(){
        System.out.println("Введите номер команды: ");
        String line = scanner.nextLine();
            if (checkCommand(line)){
                int numCommand = Integer.parseInt(line);
                menu.execute(numCommand);
            }else inputError();
    }

    private void inputError() {
        System.out.println("Введен неверный номер команды!");
    }

    private boolean checkCommand(String line) {
        try {
            if(Integer.parseInt(line) > 0 && Integer.parseInt(line) <= menu.getMenuSize()) {
                return true;
            }else return false;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private void hello(){
        System.out.println("Добро пожаловать в генеалогическое древо!");
    }

    public void setMather(){
        System.out.println("Введите имя человека, для " +
                "которого необходимо обновить информацию: ");
        String name = scanner.nextLine();
        presenter.findPerson(name);
        System.out.println("Введите ID человека, для" +
                "которого необходимо обновить информацию.");
        String idInput = scanner.nextLine();
        System.out.println("Введите имя матери: ");
        String nameMather = scanner.nextLine();
        presenter.findPerson(nameMather);
        System.out.println("Введите ID матери: ");
        String idMather = scanner.nextLine();

        if (isCorrectID(idInput) && isCorrectID(idMather)){
            int idChild = Integer.parseInt(idInput);
            int idMatherInt = Integer.parseInt(idMather);
            presenter.setMather(idChild - 1, idMatherInt - 1);
        }

    }

    public void setFather(){
        System.out.println("Введите имя человека, для " +
                "которого необходимо обновить информацию: ");
        String name = scanner.nextLine();
        presenter.findPerson(name);
        System.out.println("Введите ID человека, для" +
                "которого необходимо обновить информацию.");
        String idInput = scanner.nextLine();
        System.out.println("Введите имя отца: ");
        String nameFather = scanner.nextLine();
        presenter.findPerson(nameFather);
        System.out.println("Введите ID отца: ");
        String idFather = scanner.nextLine();

        if (isCorrectID(idInput) && isCorrectID(idFather)){
            int idChild = Integer.parseInt(idInput);
            int idFatherInt = Integer.parseInt(idFather);
            presenter.setFather(idChild - 1, idFatherInt - 1);
        }

    }

    public void saveTree(){
        presenter.saveTree();
    }

    public void loadTree(){
        presenter.loadTree();
    }


    private boolean isCorrectID(String line){
        try{
            if (Integer.parseInt(line) > 0 && Integer.parseInt(line) <= presenter.getHumanListSize());
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }



}
