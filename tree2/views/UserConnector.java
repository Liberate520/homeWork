package homeWork.tree2.views;


import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.familyTree.services.Service;
import homeWork.tree2.middleware.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserConnector implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;


    public UserConnector() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
    }

    public void addFamilyMember() {
        try {
            System.out.println("Укажите имя человека");
            String name = scanner.nextLine();
            System.out.println("Укажите дату рождения в формате гггг.м.д");
            String date = scanner.nextLine();
            String[] parts = date.split("\\.");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            LocalDate birthDate = LocalDate.of(year, month, day);
            presenter.addFamilyMember(name, birthDate);
        } catch (Exception e) {
            System.out.println("\nВозникла непредвиденная ошибка, добавление пользователя отклонено!\n");
        }
    }

    public void fillFamilyTreeWithTestData() {
        presenter.fillFamilyTreeWithTestData();
    }


    public void showAllFamily() {
        presenter.showFamilyMembers();
    }

    public void SortByParams() {
        System.out.println("Выбирите параметр сортировки");
        System.out.println("1 - Сортировка по имени\n+" +
                "2 - Обратная сортировка по имени\n" +
                "3 - Сортировка по id\n" +
                "4 - Обратная сортировка по id\n" +
                "0 - Выход");
        String param = scanner.nextLine();
        Boolean flag = true;
        while (flag) {
            switch (param) {
                case "1":
                    presenter.sortByName();
                    break;
                case "2":
                    presenter.sortByNameDesc();
                    break;
                case "3":
                    presenter.sortById();
                    break;
                case "4":
                    presenter.sortByIdDesc();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Введите корретные данные");
                    continue;
            }
        }
    }


    public void findPerson() {
        System.out.println("Введите имя пользователя для поиска: \n");
        String name = scanner.nextLine();
        presenter.findPerson(name);
    }

    public void deletePerson() {
        System.out.println("Введите имя пользователя для удаления: \n");
        String name = scanner.nextLine();
        presenter.deletePeson(name);
    }

    public void saveFile() {
        presenter.saveFile();
    }

    public void LoadFile() {
        presenter.loadFile();
    }

    public void updatePesron() {
        System.out.println("Введите имя пользователя, чтобы найти его в базе и изменить: ");
        String oldName = scanner.nextLine();
        System.out.println("Введите новое имя пользователя для изменения: ");
        String newName = scanner.nextLine();
        System.out.println("Введите дату рождения пользователя для изменения: ");
        String newDate = scanner.nextLine();
        String[] parts = newDate.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        LocalDate newBirthDate = LocalDate.of(year, month, day);
        presenter.updatePerson(oldName, newName, newBirthDate);


    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Приветствие");
        while (work) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }


    public void finish() {
        System.out.println("Всего хорошего, возвращайтесь!");
        work = false;
    }


}
