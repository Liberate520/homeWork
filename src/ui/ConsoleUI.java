package ui;

import familyTree.member.Gender;
import familyTree.member.Human;
import presenter.Presenter;
import service.FileHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private FileHandler handler;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private String scan(){
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        while (work) {
            try {
                print(menu.print() + "-> ");
                while (!scanner.hasNextInt()) {
                    print("Некорректный ввод. Введите число");
                    scanner.next();
                }
                int choice = scanner.nextInt();
                scanner.nextLine();
                menu.execute(choice);
            } catch (IndexOutOfBoundsException e) {
                print("Такого пункта меню нет. Выберите пункт из списка.");
            } catch (InputMismatchException e) {
                print("Пожалуйста введите число");
                scanner.next();
            } catch (Exception e) {
                print("Произошла ошибка " + e.getMessage());
            }
        }

    }

    public void printTree() {
        System.out.println("_".repeat(80));
        presenter.printTree();
    }

    public void addMember(){
        String name = null;
        String surname = null;
        Gender sex = null;
//        LocalDate birthDate = null;
        String birthDate = null;
        Human mother = null;
        Human father = null;
        // Ввод имени
        while (name == null) {
            System.out.println("Введите имя: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Имя не может быть пустым.");
            } else {
                name = input.trim();
            }
        }
        // Ввод фамилии
        while (surname == null) {
            System.out.println("Введите фамилию: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Фамилия не может быть пустой.");
            } else {
                surname = input.trim();
            }
        }
        // Ввод пола
        while (sex == null) {
            System.out.println("Введите пол 'm' - мужской или 'f' - женский: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Пол не может быть пустым.");
            } else if (input.trim().equalsIgnoreCase("m")) {
                sex = Gender.Male;
            } else if (input.trim().equalsIgnoreCase("f")) {
                sex = Gender.Female;
            } else {
                System.out.println("Некорректный ввод пола.");
            }
        }
        // Ввод даты рождения
        while (birthDate == null) {
            System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Поле не может быть пустым.");
            } else {
                birthDate = input.trim();
            }
//            try {
//                birthDate = LocalDate.parse(input.trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//            } catch (DateTimeParseException e) {
//                System.out.println("Некорректный формат даты рождения.");
//            }
        }
        // Ввод матери
        System.out.println("Введите имя матери (если неизвестно, нажмите Enter): ");
        String motherName = scanner.nextLine();
        if (!motherName.trim().isEmpty()) {
            try {
                mother = presenter.searchMemberByName(motherName.trim());
                if (mother.getGender() != Gender.Female) {
                    System.out.println("Некорректный пол матери.");
                    mother = null;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        // Ввод отца
        System.out.println("Введите имя отца (если неизвестно, нажмите Enter): ");
        String fatherName = scanner.nextLine();
        if (!fatherName.trim().isEmpty()) {
            try {
                father = presenter.searchMemberByName(fatherName.trim());
                if (father.getGender() != Gender.Male) {
                    System.out.println("Некорректный пол отца.");
                    father = null;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        // Добавление человека в дерево
        try {
            presenter.addMember(name, surname, sex, birthDate, mother, father);
            System.out.println("Человек был успешно добавлен в дерево.\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeMember(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        try {
            presenter.removeMember(name);
            System.out.println("Человек был успешно удален из дерева.\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchMemberByName(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        if(presenter.searchMemberByName(name) != null) {
            System.out.println(presenter.searchMemberByName(name).getInfo());
        } else {
            System.out.println("Попробуйте еще раз");}

        System.out.println("_".repeat(80));
    }

    public void clearTree() {
        System.out.println("_".repeat(80));
        presenter.clearTree();
        System.out.println("Дерево очищено\n");
    }

    public void loadTree(){
        System.out.println("Введите имя файла для загрузки: ");
        String fileName = scanner.nextLine();
        String fullName = "src/" + fileName + ".dat";
        presenter.loadTree(fullName);
    }

    public void saveTree() {
        System.out.println("Введите имя файла для сохранения: ");
        String fileName = scanner.nextLine();
        String fullName = "src/" + fileName + ".dat";
        presenter.saveTree(fullName);
    }


    public void finish() {work = false;}
}
