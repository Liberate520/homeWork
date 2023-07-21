package ui;

import presenter.Presenter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
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

    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void start() {
        while (work) {
            mainRequests();
        }
    }

    public void mainRequests() {
        print(menu.printMainCommands());
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (0 < nMenu && nMenu <= menu.getSizeMainCommands()) {
                menu.executeMainCommands(nMenu);
            } else {
                print("Некорректный ввод");
            }
        } else {
            print("вводите цифры обозначающие пункты меню");
        }
    }

    private String scan() {
        return scanner.nextLine();
    }

    private boolean isCanBeInt(String text) {
        return text.matches("[0-9]+");
    }

    public void quit() {
        work = false;
    }

    public void newFTree() {
        String fTreeName = requestNameFTree();
        if (presenter.addFamilyTree(fTreeName)) {
            while (editTree()) ;
        }
    }

    public void requestEdit() {
        String fTreeName = requestNameFTree();
        if (presenter.isFindFamilyTree(fTreeName)) {
            while (editTree()) ;
        } else {
            print("Дерево с таким именем не найдено");
        }
    }

    private boolean editTree() {
        print(menu.printEditTreeCommands());
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (0 < nMenu && nMenu <= menu.getSizeEditTreeCommands()) {
                return menu.executeEditTreeCommands(nMenu);
            } else {
                print("Некорректный ввод");
            }
        } else {
            print("вводите цифры обозначающие пункты меню");
        }
        return true;
    }

    public boolean newMember() {
        String name = requestName();
        boolean isMale = requestIsMale();
        int year = requestYear();
        int month = requestMonth();
        int day = requestDay();
        Calendar bornDate = new GregorianCalendar(year, month, day);
        return presenter.addSample(name, isMale, bornDate);
    }

    public boolean addChild() {
        String ParentName = requestParentName();
        String ChildName = requestChildName();
        return presenter.addChild(ParentName, ChildName);
    }

    public boolean addMarried() {
        String Married1Name = requestMarriedName();
        String Married2Name = requestMarriedName();
        boolean isMarried = requestIsMarried();
        return presenter.addMarried(Married1Name, Married2Name, isMarried);
    }

    private String requestName() {
        print("Введите имя нового члена семьи:");
        return scan();
    }

    private String requestNameSimple() {
        print("Введите имя существующего члена семьи:");
        return scan();
    }

    private String requestParentName() {
        print("Введите имя родителя:");
        return scan();
    }

    private String requestChildName() {
        print("Введите имя ребенка:");
        return scan();
    }

    private String requestMarriedName() {
        print("Введите имя одного из женатых:");
        return scan();
    }

    private boolean requestIsMale() {
        print("Новый член семьи мужчина? (true или иное):");
        return Boolean.parseBoolean(scan());
    }

    private boolean requestIsMarried() {
        print("Они женаты в настоящий момент? (true или иное):");
        return Boolean.parseBoolean(scan());
    }

    private int requestYear() {
        do {
            print("Введите год рождения нового члена семьи:");
            String yearStr = scan();
            if (isCanBeInt(yearStr)) {
                int year = Integer.parseInt(yearStr);
                if (1700 <= year && year <= 2023) {
                    return year;
                } else {
                    print("Введен неверный год (допустимый диапазон 1700 - 2023).");
                }
            } else {
                print("Вводите год в цифровом формате");
            }
        } while (true);
    }

    private int requestMonth() {
        do {
            print("Введите месяц рождения нового члена семьи (допустимый диапазон 1 - 12):");
            String monthStr = scan();
            if (isCanBeInt(monthStr)) {
                int month = Integer.parseInt(monthStr);
                if (1 <= month && month <= 12) {
                    return month - 1;
                } else {
                    print("Введен неверный месяц (допустимый диапазон 1 - 12).");
                }
            } else {
                print("Вводите месяц в цифровом формате");
            }
        } while (true);
    }

    private int requestDay() {
        do {
            print("Введите день месяца рождения нового члена семьи (допустимый диапазон 1 - 31):");
            String dayStr = scan();
            if (isCanBeInt(dayStr)) {
                int day = Integer.parseInt(dayStr);
                if (1 <= day && day <= 31) {
                    return day;
                } else {
                    print("Введен неверный месяц (допустимый диапазон 1 - 31).");
                }
            } else {
                print("Вводите день в цифровом формате");
            }
        } while (true);
    }

    public boolean requestLoad() {
        print("Введите имя файла:");
        return presenter.load(scan());
    }

    public boolean requestSave() {
        print("Введите имя файла:");
        return presenter.save(scan());
    }

    private String requestNameFTree() {
        print("Введите имя генеалогического древа:");
        return scan();
    }

    public boolean requestPrint() {
        print("В каком виде вывести информацию на экран (1 - список или 2 - древо)");
        switch (scan()) {
            case "1":
                return presenter.printInfo();
            case "2":
                return presenter.printFTrees();
            default:
                print("Введено отличное от 1 или 2.");
                return requestPrint();
        }
    }

    public boolean printTree() {
        return presenter.printTree();
    }

    public boolean printMember() {
        print("Введите имя члена семьи");
        return presenter.printMember(scan());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
