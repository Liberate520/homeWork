package ru.gb.Tree.View;



import ru.gb.Tree.Presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter = new  Presenter(this);
        scanner =  new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Привет!!!");
        while (work){
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            // проверка
            int userChoice = Integer.parseInt(choice);
            menu.execute(userChoice);
        }

    }

    @Override
    public void printAnswers(String text) {
        System.out.println(text);
    }

    public String inputName(){
        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()){
                return name;
            }else {
                System.out.print("Введена пустая строка.");
//                scanner.nextLine();
            }
        }
    }

    public String inputGender() {
        while (true) {
            System.out.print("Введите пол (male или female): ");
            String gender = scanner.nextLine();
            if (gender.equals("male") || gender.equals("female")) {
                return gender;
            } else {
                System.out.print("Ошибка! Введите male - для мужчин, female - для женщин. ");
//                scanner.next();
            }
        }
    }

    public LocalDate inputBirthDate(){
        while (true) {
            System.out.print("Укажите дату рождения в формате 'YYYY/MM/DD': ");
            String birthDate = scanner.nextLine();
            if (birthDate.matches("^((19|20)[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")) {
                return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            }else if (birthDate.isEmpty()) {
                System.out.print("Введена пустая строка. ");
//                scanner.next();
            } else {
                System.out.print("Ошибка! Введите дату рождения в формате 'YYYY/MM/DD'. ");
//                scanner.next();
            }
        }
    }

    public LocalDate inputDeathDate(){
        while (true){
            System.out.print("Укажите дату смерти в формате 'YYYY/MM/DD': ");
            String deathDate = scanner.nextLine();
            if (deathDate.matches("^((19|20)[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")) {
                return LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            } else if  (deathDate.isEmpty()){
                return null;
            }else {
                System.out.print("Ошибка! Введите дату смерти в формате 'YYYY/MM/DD'. ");
//                scanner.nextLine();
            }
        }
    }

    public Integer inputMotherId(){
        while (true) {
            System.out.print("Укажите ID матери: ");
            String motherId = scanner.nextLine();
            if (motherId.isEmpty()) {
                return null;
            }else if (motherId.matches("[-+]?\\d+")) {
                return Integer.valueOf(motherId);
            } else {
                System.out.print("Ошибка, введено не число! ");
//                scanner.nextLine();
            }
        }
    }

    public Integer inputFatherId(){
        while (true) {
            System.out.print("Укажите ID отца: ");
            String fatherId = scanner.nextLine();
            if (fatherId.isEmpty()) {
                return null;
            } else if (fatherId.matches("[-+]?\\d+")) {
                return Integer.valueOf(fatherId);
            } else {
                System.out.println("Ошибка, введено не число! ");
//                scanner.nextLine();
            }
        }
    }

    public void addPerson() {
        presenter.addPerson(inputName(), inputGender(), inputBirthDate(), inputDeathDate(), inputMotherId(), inputFatherId() );
    }

    public void finish(){
        System.out.println("Спасибо! До новых встреч!");
        work = false;
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
    }

    public void getFamilyTreeInfo(){
    presenter.getFamilyTreeInfo();
    }

    public void getSavedFile(){
        presenter.getSavedInfo();
    }

    public void addNewWedding(){
        System.out.println("Укажите ID первого супруга");
        int firstSpouseId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите ID второго супруга");
        int secondSpouseId = Integer.parseInt(scanner.nextLine());
        presenter.addNewWedding(firstSpouseId, secondSpouseId);
    }

    public void addNewChild(){
        System.out.println("Укажите ID родителя");
        int parentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите ID ребенка");
        int childId = Integer.parseInt(scanner.nextLine());
        presenter.addNewChild(parentId, childId);;
    }
}
