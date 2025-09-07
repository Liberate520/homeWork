package ru.home_work.cherevichenko_sergey.view;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.presenter.Presenter;
import ru.home_work.cherevichenko_sergey.view.commands.MainMenu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    private MainMenu menu;

    DataEntry dataEntry;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        int localDateTime = LocalDateTime.now().getHour();
        menu = new MainMenu(this);
        dataEntry = new DataEntry();
    }

    @Override
    public void start() {
        System.out.println(dataEntry.timeDay());
        System.out.println("Это программа для создания семейного древа.\nВыбери одну из операций ниже по номеру: ");
        while (work) {
            printMenu();
            choice();
        }

    }

    private void choice() {
        int line = scanner.nextInt();
        if (line > 0 && line <= menu.size()) menu.execute(line);
        else error();
    }

    //int choice = Integer.parseInt(choiceStr);
    private void error() {
        System.out.println("Операции с таким номером не существует! Выберите из списка!");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void addHuman() {
        String name = dataEntry.name("Введите имя: ");
        String lastName = dataEntry.name("Введите фамилию: ");
        Gender gender = dataEntry.gender();
        LocalDate birthDay = dataEntry.birthDay();
        LocalDate dateDeath = dataEntry.dateDeath();
        presenter.addHuman(name, lastName, gender, birthDay, dateDeath);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }

    public void getInfo() {
        presenter.getInfo();

    }

    public void addChildForFamily() {
        String nameMother = dataEntry.name("Введите имя матери: ");
        String lastNameMother = dataEntry.name("Введите фамилию матери: ");
        String nameFather = dataEntry.name("Введите имя отца: ");
        String lastNameFather = dataEntry.name("Введите фамилию отца: ");
        String nameChild = dataEntry.name("введите имя ребенка: ");
        String lastNameChild = dataEntry.name("Введите фамилию ребенка: ");
        presenter.addChildForFamily(nameMother, lastNameMother, nameFather, lastNameFather, nameChild, lastNameChild);
    }

    public void removeHuman() {
        String name = dataEntry.name("Введите имя: ");
        String lastName = dataEntry.name("Введите фамилию: ");
        presenter.removeHuman(name, lastName);
    }

    public void findChildren() {
        String nameChild = dataEntry.name("Введите имя ребенка: ");
        String lastNameChild = dataEntry.name("Введите фамилию ребенка: ");
        presenter.findChildren(nameChild, lastNameChild);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByLastName() {
        presenter.sortByLastName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByCountChildren() {
        presenter.sortByCountChildren();
    }

    public void saveTree() {
        presenter.save();
    }


    public void restoreTree() {
        presenter.read();
    }
}
