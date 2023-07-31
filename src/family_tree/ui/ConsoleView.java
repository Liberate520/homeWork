package family_tree.ui;

import family_tree.model.person.Gender;
import family_tree.presenter.Presenter;
import family_tree.ui.commands.GetTreePeaks;
import family_tree.ui.commands.GetTreeShort;
import family_tree.ui.menus.*;

import java.util.Scanner;

public class ConsoleView implements View{
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private static final String inputError = "Ошибка ввода!";

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.menu = new MainMenu(this);
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void start() {
        print("Добро пожаловать!");
        while (true) {
            menu.show();
            execute();
        }
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void execute() {
        int option = checkOption("выберите действие -> ", menu.getSize());
        menu.execute(option - 1, "");
    }

    private String scan(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    public void repeatLine() {
        System.out.println(new String(new char[60]).replace("\0", "="));
    }

    // возвращает число, если ли строка является числом
    private int checkNum(String numStr) {
        while (!isNum(numStr)) {
            System.out.print(inputError+" - введено не число\nПопробуйте еще раз -> ");
            numStr = scanner.nextLine();
        }
        return Integer.parseInt(numStr);
    }

    // boolean выражение "является ли числом"
    private boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    // проверка выбора действия
    private int checkOption(String textToOutput, int size) {
        int resultOption = checkNum(scan(textToOutput));
        while (!isValidOptionSize(resultOption, size)) {
            print(inputError+"\nВыберите действие от 1 до "+size);
            resultOption = checkNum(scan(textToOutput));
        }
        return resultOption;
    }

    private String getValidDateString() {
        int year = checkNum(scan("год в формате YYYY -> "));
        int month = checkNum(scan("месяц в формате M -> "));
        while (month < 1 || month > 12) {
            month = checkNum(scan("месяц д.б. в диапазоне от 1 до 12 -> "));
        }
        int day = checkNum(scan("день в формате D -> "));
        while (!isValidDay(year, month, day)) {
            day = checkNum(scan(" день -> "));
        }
        return year + "," + month + "," + day;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private Boolean isValidDay(int year, int month, int day) {
        int maxDay = 31;
        switch (month) {
            case 4, 6, 9, 11 -> maxDay = 30;
            case 2 -> {
                if (isLeapYear(year)) {
                    maxDay = 29;
                } else { maxDay = 28; }
            }
        }
        if (day < 1 || day > maxDay) {
            System.out.print(inputError+" - день д.б. в диапазоне от 1 до "+maxDay);
            return false;
        } else return true;
    }

    private Boolean isValidOptionSize(int chosenOption, int optionSize) {
        return chosenOption > 0 && chosenOption <= optionSize;
    }

    private Boolean checkItem(String fullName) {
        if (!isContainsItem(fullName)) {
            failureMsg();
            print("По введеному ФИО экземпляр в дереве не представлен!");
            return false;
        } else {
            return true;
        }
    }

    private Boolean isContainsItem(String fullName) {
        return presenter.isContainsItem(fullName);
    }

    // проверка - выполнено ли действие
    private void isDone(Boolean presenterMethod) {
        if (presenterMethod) {
            successMsg();
        } else { failureMsg(); }
    }

    private void successMsg() {
        print("Успешно!");
    }

    private void failureMsg() {
        print("Неудача!");
    }

    public void getInfo() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else {
            OutputMenu curMenu = new OutputMenu(this);
            curMenu.show();
            int option = checkOption("Выберите действие -> ", curMenu.getSize());
            curMenu.execute(option - 1, "");
        }
    }

    public void printTree() {
        presenter.getTree();
    }

    public void printTreeShort() {
        presenter.getTreeShort();
    }

    public void printItem() {
        String fullName = scan("Введите ФИО для поиска -> ");
        if (checkItem(fullName)) {
            presenter.getItem(fullName);
        }
    }

    public void printItemShort() {
        String fullName = scan("Введите ФИО для поиска -> ");
        if (checkItem(fullName)) {
            presenter.getItemShort(fullName);
        }
    }

    public void sortTree() {
        SortMenu curMenu = new SortMenu(this);
        curMenu.show();
        int option = checkOption("Выберите действие -> ", curMenu.getSize());
        curMenu.execute(option - 1, "");
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByNameReverse() {
        presenter.sortByNameReverse();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByAgeReverse() {
        presenter.sortByAgeReverse();
    }

    public void sortByDateBirth() {
        presenter.sortByDateBirth();
    }

    public void sortByDateBirthReverse() {
        presenter.sortByDateBirthReverse();
    }

    public void sortByChildren() {
        presenter.sortByChildren();
    }

    public void sortByChildrenReverse() {
        presenter.sortByChildrenReverse();
    }

    public void addToTree() {
        String fullName = scan("Введите:\nФИО -> ");
        // ввод года, месяца, дня и их проверка действительности
        String dateStr = getValidDateString();
        GenderMenuAdd curMenu = new GenderMenuAdd(this);
        curMenu.show();
        int genderOption = checkOption("Выберите пол -> ", curMenu.getSize());
        String data = fullName+","+dateStr;
        curMenu.execute(genderOption - 1, data);
    }

    public void addPersonToTree(String data) {
        isDone(presenter.addPersonToTree(data));
    }

    public void setGenderFemaleForAdd(String data) {
        Gender gender = Gender.Female;
        ChooseItemClassMenu curMenu = new ChooseItemClassMenu(this);
        curMenu.show();
        int option = checkOption("Выберите \"класс\" добавления -> ", curMenu.getSize());
        curMenu.execute(option - 1, data+","+gender);
    }

    public void setGenderMaleForAdd(String data) {
        Gender gender = Gender.Male;
        ChooseItemClassMenu curMenu = new ChooseItemClassMenu(this);
        curMenu.show();
        int option = checkOption("Выберите \"класс\" добавления -> ", curMenu.getSize());
        curMenu.execute(option - 1, data+","+gender);
    }

    public void delFromTree() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else {
            String fullName = scan("Введите ФИО -> ");
            if (checkItem(fullName)) {
                isDone(presenter.delFromTree(fullName));
            }
        }
    }

    public void changeItemParameter() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else {
            presenter.getTreeShort();
            int itemIndex = checkOption("Выберите экземпляр дерева -> ", presenter.getTreeSize());
            ChangeItemMenu curMenu = new ChangeItemMenu(this);
            curMenu.show();
            int option = checkOption("Какой параметр изменить -> ", curMenu.getSize());
            curMenu.execute(option - 1, Integer.toString(itemIndex - 1));
        }
    }

    public void setFullname(String itemIndex) {
        String fullName = scan("Введите ФИО -> ");
        isDone(presenter.setFullname(itemIndex, fullName));
    }

    public void setDateBirth(String itemIndex) {
        print("Введите:");
        String dateStr = getValidDateString();
        int birthY = Integer.parseInt(dateStr.split(",")[0]);
        int birthM = Integer.parseInt(dateStr.split(",")[1]);
        int birthD = Integer.parseInt(dateStr.split(",")[2]);
        isDone(presenter.setDateBirth(itemIndex, birthY, birthM, birthD));
    }

    public void setDateEndlife(String itemIndex) {
        print("Введите:");
        String dateStr = getValidDateString();
        int EndlifeY = Integer.parseInt(dateStr.split(",")[0]);
        int EndlifeM = Integer.parseInt(dateStr.split(",")[1]);
        int EndlifeD = Integer.parseInt(dateStr.split(",")[2]);
        isDone(presenter.setDateEndlife(itemIndex, EndlifeY, EndlifeM, EndlifeD));
    }

    public void setGenderChange(String itemIndex) {
//        print("1. Женский\n" +
//              "2. Мужской\n");
        GenderMenuChange curMenu = new GenderMenuChange(this);
        curMenu.show();
        int option = checkOption("Выберите пол - > ", curMenu.getSize());
        curMenu.execute(option - 1, itemIndex);
//        isDone(presenter.setGenderChange(itemIndex, gender));
    }

    public void setGenderFemaleChange(String itemIndex) {
        isDone(presenter.setGenderChange(itemIndex, Gender.Female));
    }

    public void setGenderMaleChange(String itemIndex) {
        isDone(presenter.setGenderChange(itemIndex, Gender.Male));
    }

    public void setMother(String itemIndex) {
        String motherName = scan("Введите ФИО мамы -> ");
        if (checkItem(motherName)) {
            isDone(presenter.setMother(itemIndex, motherName));
        }

    }

    public void setFather(String itemIndex) {
        String fatherName = scan("Введите ФИО папы -> ");
        if (checkItem(fatherName)) {
            isDone(presenter.setFather(itemIndex, fatherName));
        }
    }

    public void setChildren(String itemIndex) {
        String childName = scan("Введите ФИО ребенка -> ");
        if (checkItem(childName)) {
            isDone(presenter.setChild(itemIndex, childName));
        }
    }

    public void setCommit(String itemIndex) {
        String commit = scan("Введите доп. инфо -> ");
        isDone(presenter.setCommit(itemIndex, commit));
    }

    public void setTreePeak() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else {
            new GetTreePeaks(this).execute("");
            new GetTreeShort(this).execute("");
            int index = checkOption("Выберите нового главу -> ", presenter.getTreeSize());
            isDone(presenter.setPeakByIndex(index - 1));
        }
    }

    public void printTreePeak() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else { presenter.getPeakTree(); }
    }

    public void saveTree() {
        SaveTreeMenu curMenu = new SaveTreeMenu(this);
        curMenu.show();
        int option = checkOption("Выберите способ сохранения -> ", curMenu.getSize());
        curMenu.execute(option - 1, "");
    }

    public void saveTreeObject() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else { isDone(presenter.saveTree("1")); }
    }

    public void saveTreeByteArray() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else { isDone(presenter.saveTree("2")); }
    }

    public void loadTree() {
        LoadTreeMenu curMenu =  new LoadTreeMenu(this);
        curMenu.show();
        int option = checkOption("Выберите способ загрузки -> ", curMenu.getSize());
        String fileName = scan("введите имя файла формата ").concat(option == 1?".bin":".txt");
        curMenu.execute(option - 1, fileName);
    }

    public void loadTreeObject(String fileName) {
        isDone(presenter.loadTree("1", fileName));
    }

    public void loadTreeByteArray(String fileName) {
        isDone(presenter.loadTree("2", fileName));
    }

    public void delTree() {
        isDone(presenter.delTree());
    }

    public void exit() {
        presenter.exit();
    }

}
