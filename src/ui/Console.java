package src.ui;

import src.Validation;
import src.presenter.Presenter;
import java.io.IOException;
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    Validation validation = new Validation();

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            showMenu();
            useCommand(scanner.next());
        }
    }

    private void showMenu() {
        System.out.println(menu.printMenu());
        System.out.print("Укажите номер команды из меню: ");
    }

    private void useCommand(String command) {

        if (validation.isNextInt(command)) {
            try {
                menu.execute(Integer.parseInt(command));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Некорретно выбран элемент меню");
        }
    }

    public void finish() {
        work = false;
    }

    @Override
    public void print(String text) {

    }

    public void addHuman() {
        presenter.addHuman();
    }

    public void showHumans() {
        System.out.println(presenter.showHumans());
    }

    public void loadTree() {
        System.out.print("Укажите имя файла для загрузки: ");
        if (presenter.loadTree(scanner.next())) {
            System.out.println("Файл загружен!\n");
        } else {
            System.out.println("Что-то пошло не так!!! Файл не загружен...\n");
        }
    }

    public void saveTree() {
        System.out.print("Укажите имя файла для сохранения: ");
        if (presenter.saveTree(scanner.next())) {
            System.out.println("Файл сохранен!\n");
        } else {
            System.out.println("Что-то пошло не так!!! Файл не сохранен...\n");
        }
    }

    public void delHuman() {
        System.out.print("Укажите ID который хотите удалить: ");
        String id = scanner.next();
        if (validation.isNextInt(id)) {
            int delId = Integer.parseInt(id);
            if (presenter.delHuman(delId)) {
                System.out.printf("\nЗапись с ID: %s удалена!\n", id);
            }
        } else {
            System.out.printf("Запись с ID: %s не была удалена\n", id);
        }
    }

    public void findHumans() {
        ConsoleForms form = new ConsoleForms();
        String result = presenter.findHumans(form);
        System.out.println("Результаты поиска:");
        if (result.isEmpty()) {
            System.out.println("Нет результатов удовлетворящих критериям поиска!");
        } else {
            System.out.println(result);
        }
    }

    public void infoHuman() {
        System.out.print("Укажите ID информацию по которому хотите получить: ");
        String sc = scanner.next();
        if (validation.isNextInt(sc)) {
            System.out.println(presenter.infoHuman(Integer.parseInt(sc)));
        } else {
            System.out.println("Некорректно указан ID");
        }
    }

    public void showTree() {
        System.out.print("Укажите \"родительский\" ID от которого будет стоиться деверо: ");
        String sc = scanner.next();
        if (validation.isNextInt(sc)) {
            System.out.println(presenter.showTree(Integer.parseInt(sc)));
        } else {
            System.out.println("Некорректно указан ID");
        }
    }


    public void addChild() {
        System.out.print("Укажите ID ребенка: ");
        String idChild = scanner.next();
        System.out.printf("Укажите ID родителя, к которому необходимо прикрепить ребенка с ID %s: ", idChild);
        String idParent = scanner.next();
        if (validation.isNextInt(idChild) && validation.isNextInt(idParent)) {
            if (presenter.addChild(Integer.parseInt(idChild), Integer.parseInt(idParent))) {
                System.out.printf("\nРебенок с ID %s, добавлен к родителю %s: \n", idChild, idParent);
            } else {
                System.out.println("Добавить не удалось!");
            }
        }
    }
}
