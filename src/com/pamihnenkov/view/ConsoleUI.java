package com.pamihnenkov.view;

import com.pamihnenkov.model.enums.Relation;
import com.pamihnenkov.presenter.Presenter;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.scanner = new Scanner(System.in);
        this.work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Генеалогическое дерево.  ");
        while (work){
            printMenu();
            execute();
        }

    }

    private void execute() {
        String option = scanner.nextLine();
        if (checkForInteger(option)){
            int number = Integer.parseInt(option);
            if (checkCommand(number)){
                menu.execute(number);
            }
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand > 0 && numCommand < menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkForInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex){
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void addNewMember() {
        System.out.print("Введите фамилию:");
        String surname = scanner.nextLine();
        System.out.print("Введите имя:");
        String name = scanner.nextLine();
        System.out.print("Введите отчество:");
        String lastname = scanner.nextLine();
        System.out.print("Введите дату рождения (формат dd/mm/yyyy):");
        String birthdate = scanner.nextLine();
        System.out.print("Введите дату смерти (формат dd/mm/yyyy) либо оставьте поле пустым, если человек жив:");
        String deathdate = scanner.nextLine();
        System.out.print("Введите пол (м/ж):");
        String gender = scanner.nextLine();
        presenter.addNewMember(surname,name,lastname,birthdate,deathdate,gender);
    }

    public void addRelativeForPerson(){
        System.out.println("Установка родственных связей");
        UUID member = chooseMember();
        UUID relative = chooseMember();
        String relation = chooseRelation();
        presenter.addRelativeForPerson(member,relative,relation);
    }

    public void getBrothersAndSister(){
        System.out.println("Поиск братьев и сестер для конкретного члена семьи.");
        UUID id = chooseMember();
        printCollection(presenter.getBrothersAndSisters(id));
    }

    public void showAllMembers(){
        printCollection(presenter.showAllMembers());
    }

    private UUID chooseMember() {
        Map<Integer,UUID> menu = new HashMap<>();
        int count = 1;
        System.out.println("Выберите члена семьи: ");
        for (Object entry : presenter.getAllMembersForChooseMenu().entrySet()){
            Map.Entry<UUID, String> option = (Map.Entry<UUID, String>) entry;
            System.out.println(count + ". " + option.getValue());
            menu.put(count,option.getKey());
            count = count + 1;
        }
        int option = scanner.nextInt();
        return menu.get(option);
    }

    private String chooseRelation() {
        Map<Integer,String> menu = new HashMap<>(Relation.values().length);
        int count = 1;
        System.out.print("Выберите вид родства семьи: ");
        for (Object relation : presenter.getRelationVariants()){
            String option = (String) relation;
            System.out.println(count + ". " + option);
            menu.put(count,option);
            count = count + 1;
        }
        int option = scanner.nextInt();
        return menu.get(option).toString();
    }

    public void getSortedByBirthdate(){
        System.out.println("Сортированный по дате рождения список:");
        printCollection(presenter.getSortedByBirthdate());
    }

    public void getSortedByAge(){
        System.out.println("Сортированный по возрасту список:");
        printCollection(presenter.getSortedByAge());
    }

    private void printCollection(Collection<String> collection) {
        for (String str:collection) {
            System.out.println(str);
        }
    }
}
