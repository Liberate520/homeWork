package ru.medved_sa.tree_family.view;

import ru.medved_sa.tree_family.presenter.Presenter;

import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }


    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void getHumanList() {
        presenter.getHumanList();
    }

    @Override
    public void addHuman() {
        System.out.println("Укажите имя человека: ");
        String newName = scanner.nextLine();
        System.out.println("Введите дату рождения человека в формате (ГГГГ-ММ-ДД)");
        String newStrAge = scanner.nextLine();
        System.out.println("Введите пол человека (Male или Female) ");
        String gender = scanner.nextLine();
        presenter.addHuman(newName, gender, newStrAge);

    }

    @Override
    public void setParent() {
        System.out.println("Укажите id человека, для которого надо указать родителя. " +
                "Id можно увидеть при запросе всего списка людей.");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите id родителя. Id можно увидеть при запросе всего списка людей.");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(personId, parentId);
    }


    @Override
    public void sortByName() {
        presenter.sortByName();
    }

    @Override
    public void sortByAge() {
        presenter.sortByAge();
    }

    @Override
    public void finish() {
        System.out.println("До новых встреч...");
        work = false;
    }

    @Override
    public void sortById() {
        presenter.sortById();
    }

    @Override
    public void readDataFromFile() {
        System.out.println("Укажите полный путь к файлу для загрузки дерева");
        String path = scanner.nextLine();
        while (!presenter.readFile(path)) {
            System.out.println("Не удалось загрузить файл. Хотите попробовать снова? Y/N");
            if (scanner.nextLine().equals("N")) {
                break;
            }
            System.out.println("Укажите полный путь к файлу для загрузки дерева");
            path = scanner.nextLine();
        }
    }

    @Override
    public void saveDataFromFile() {
        System.out.println("Укажите полный путь к файлу для сохранения дерева");
        String path = scanner.nextLine();
        while (!presenter.saveFile(path)) {
            System.out.println("Не удалось сохранить объект. Хотите попробовать снова? Y/N");
            if (scanner.nextLine().equals("N")) {
                break;
            }
            System.out.println("Укажите полный путь к файлу для сохранения дерева");
            path = scanner.nextLine();
        }
    }
}
