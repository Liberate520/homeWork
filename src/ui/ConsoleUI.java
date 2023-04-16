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
                print("Введен неверный пункт меню.");
            }
        } else {
            print("Введено что-то отличное от пунктов меню.");
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
        String typeFTree = requestType();
        String fTreeName = requestNameFTree();
        if (this.getPresenter().addFamilyTree(typeFTree, fTreeName)) {
            while (editTree()) ;
        }
    }

    public void requestEdit() {
        String fTreeName = requestNameFTree();
        if (this.getPresenter().isFindFamilyTree(fTreeName)) {
            while (editTree()) ;
        } else {
            print("Генеалогическое древо с таким именем не найдено.");
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
                print("Введен неверный пункт меню.");
            }
        } else {
            print("Введено что-то отличное от пунктов меню.");
        }
        return true;
    }

    public boolean newMember() {
        String name = requestName();
        String kind = requestKind();
        boolean isMale = requestIsMale();
        int year = requestYear();
        int month = requestMonth();
        int day = requestDay();
        Calendar bornDate = new GregorianCalendar(year, month, day);
        return this.getPresenter().addMember(name, kind, isMale, bornDate);
    }

    public boolean newTwin() {
        String newName = requestName();
        String nameSimple = requestNameSimple();
        return this.getPresenter().addMember(newName, nameSimple);
    }

    public boolean addChild() {
        String ParentName = requestParentName();
        String ChildName = requestChildName();
        return this.getPresenter().addChild(ParentName, ChildName);
    }

    public boolean addMarried() {
        String Married1Name = requestMarriedName();
        String Married2Name = requestMarriedName();
        boolean isMarried = requestIsMarried();
        return this.getPresenter().addMarried(Married1Name, Married2Name, isMarried);
    }

    public boolean SortBy() {
        print(menu.printSortByCommands());
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (0 < nMenu && nMenu <= menu.getSizeSortByCommands()) {
                return menu.executeSortByCommands(nMenu);
            } else {
                print("Введен неверный пункт меню.");
            }
        } else {
            print("Введено что-то отличное от пунктов меню.");
        }
        return true;
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

    private String requestKind() {
        print("Введите расу (породу) нового члена семьи:");
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
                print("Введено что-то отличное от года.");
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
                print("Введено что-то отличное от месяца.");
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
                print("Введено что-то отличное от дня месяца.");
            }
        } while (true);
    }

    public boolean requestLoad() {
        print("Введите имя файла:");
        return this.getPresenter().load(scan());
    }

    public boolean requestSave() {
        print("Введите имя файла:");
        return this.getPresenter().save(scan());
    }

    private String requestNameFTree() {
        print("Введите имя генеалогического древа:");
        return scan();
    }

    private String requestType() {
        print("Введите тип генеалогического древа (1 - для людей или 2 - для собак):");
        switch (scan()) {
            case "1":
                return "person";
            case "2":
                return "dog";
            default:
                print("Введено отличное от 1 или 2.");
                return requestType();
        }
    }

    public boolean requestPrint() {
        print("В каком виде вывести информацию на экран (1 - список или 2 - древо)");
        switch (scan()) {
            case "1":
                return this.getPresenter().printInfo();
            case "2":
                return this.getPresenter().printFTrees();
            default:
                print("Введено отличное от 1 или 2.");
                return requestPrint();
        }
    }

    public boolean printTree() {
        return this.getPresenter().printTree();
    }

    public boolean printMember() {
        print("Введите имя члена семьи");
        return this.getPresenter().printMember(scan());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public boolean sortByFirstName() {
        return this.getPresenter().sortByFirstName();
    }

    public boolean sortByLastName() {
        return this.getPresenter().sortByLastName();
    }

    public boolean sortByGender() {
        return this.getPresenter().sortByGender();
    }

    public boolean sortByBornDate() {
        return this.getPresenter().sortByBornDate();
    }

    public boolean quitMenu() {
        return this.getPresenter().quit();
    }
}
