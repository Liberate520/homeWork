package src.ui;

import java.util.Scanner;

import src.presenter.Presenter;
import src.treeApi.Human;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        presenter.loadFile();
        while (work) {
            String key = scan();
            switch (key) {
                case "1":
                    presenter.onClick1();
                    break;
                case "2":
                    String name = scanName();
                    presenter.onClick2(name);
                    Integer key1 = ScanQuest1();
                    if (key1 == 1) {
                        String father = scanFather();
                        presenter.findFather(father, name);
                    }
                    Integer key2 = ScanQuest2();
                    if (key2 == 1) {
                        String mother = scanMother();
                        presenter.findMother(mother, name);
                    }
                    break;
                case "3":
                    name = scanName();
                    presenter.onClick3(name);
                    break;
                case "4":
                    presenter.onClick4();
                    break;
                case "5":
                    presenter.saveFile();
                    break;
                case "6":
                    name = scanRemove();
                    presenter.removeHuman(name);
                    break;
                case "7":
                    print("Программа завершена!");
                    work = false;
                    scanner.close();
                    break;
                default:
                    break;
            }

        }
    }

    private String scan() {
        System.out.println("""
                \nВыберите цифру соответствующую нужному пункту:
                1) Вывести все имена из древа
                2) Добавить человека
                3) Поиск человека
                4) Вывести всю информацию по дереву
                5) Сохранить изменения
                6) Удалить человека
                7) Выйти из программы
                    """);
        return scanner.next();
    }

    private String scanFather() {
        System.out.println("Введите имя отца: ");
        return scanner.next();
    }

    private String scanMother() {
        System.out.println("Введите имя матери: ");
        return scanner.next();
    }

    private Integer ScanQuest1() {
        System.out.println("Есть ли у этого человека отец?: ");
        System.out.println("1) Да\n2) Нет");
        return scanner.nextInt();
    }

    private Integer ScanQuest2() {
        System.out.println("Есть ли у этого человека мать?: ");
        System.out.println("1) Да\n2) Нет");
        return scanner.nextInt();
    }

    private String scanName() {
        System.out.println("Введите имя человека: ");
        return scanner.next();
    }

    private String scanRemove() {
        System.out.println("Введите имя человека, которого хотите удалить из семейного дерева: ");
        return scanner.next();
    }

}
