package view;

import java.util.Scanner;

import model.Service;
import presenter.Presenter;


public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    Service service = new Service();


    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("что-то пошло не так");
            }
        }
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    private void hello() {
        System.out.println("Программа <<<Семейное дерево V2.0 2023>>>" + "\n");

        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void finish() {

        work = false;
    }


    public void addObject() {

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String family = scanner.nextLine();
        System.out.print("Введите дату рождения в формате дд.мм.гггг: ");
        String dateBirth = scanner.nextLine();
        System.out.print("Введите имя отца: ");
        String father = scanner.nextLine();
        System.out.print("Введите имя матери: ");
        String mother = scanner.nextLine();

        if (service.checkingInput(name, family, dateBirth, father, mother) == null) {

            System.out.println("Данные не введены!");
        } else {
            presenter.addObject(name, family, dateBirth, father, mother);
        }

    }


    // метод для вывода на экран всех объектов семейного дерева
    public void treeView() {

        presenter.familyTreeViewAll();

    }


    public void Search() {
        System.out.print("Введите имя для поиска объекта: ");
        String name = scanner.nextLine();

        presenter.searchHuman(name);

    }

    public void sortObg() {
        System.out.println("Выберите цифру для сортировки...");
        System.out.println("1 - по имени" + "\n" + "2- по фамилии");
        int numSort = Integer.parseInt(scanner.nextLine());
        presenter.sortHum(numSort);
    }

    public void saveInFile() {
        System.out.println("Сохранить все объекты в файл?");
        System.out.println("1 - да" + "\n" + "2- нет");
        int num = Integer.parseInt(scanner.nextLine());
        presenter.saveObj(num);

    }

    public void readFile() {
        System.out.println("Прочитать из файла?");
        System.out.println("1 - да" + "\n" + "2- нет");
        int num = Integer.parseInt(scanner.nextLine());
        presenter.readObjFromFile(num);

    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

