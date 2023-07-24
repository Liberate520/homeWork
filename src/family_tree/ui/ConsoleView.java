package family_tree.ui;

import family_tree.familytree.FamilyTree;
import family_tree.person.Gender;
import family_tree.presenter.Presenter;
import family_tree.ui.commands.Command;
import family_tree.ui.commands.GetTreePeaks;
import family_tree.ui.commands.GetTreeShort;
import family_tree.ui.commands.sort.SortTree;
import family_tree.ui.menus.*;

import java.util.Scanner;

public class ConsoleView implements View{
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private static final String inputError = "Ошибка ввода";

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
        System.out.println("Добро пожаловать!");
        while (true) {
            menu.show();
            execute();
        }
    }

    private void execute() {
        String option = scan("выберите действие -> ");
        while(!isNum(option) && Integer.parseInt(option) < menu.getSize()) {
            option = scan(inputError+"\nвыберите действие -> ");
        }
        menu.execute(Integer.parseInt(option), "");
    }



    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }



    private String scan(String text) {
//        System.out.print("выберите действие -> ");
        System.out.print(text);
        return scanner.nextLine();
    }

    private void repeat(int count, String with) {
        System.out.println(new String(new char[count]).replace("\0", with));
    }

    public void addToTree() {
        GenderMenu curMenu = new GenderMenu(this);
        String fullName = scan("Введите\nФИО -> ");
        int birthY = checkNum(scan("год р. в формате YYYY -> "), "год р. в формате YYYY -> ");
        int birthM = checkNum(scan("месяц р. в формате M -> "), "месяц р. в формате M -> ");
        int birthD = checkNum(scan("день р. в формате D -> "), "день р. в формате D -> ");
        curMenu.show();
        int genderOption = checkNum(scan("Выберите пол -> "), "Выберите 1 или 2 -> ");
        curMenu.execute(genderOption, String.format("%s,%s %s %s", fullName, birthY, birthM, birthD));
//        isDone(presenter.addToTree(fullName, birthY, birthM, birthD, gender));
    }

    public void setGenderFemaleForAdd(String data) {
        Gender gender = Gender.Female;
        isDone(presenter.addToTree(data, gender));
    }

    public void setGenderMaleForAdd(String data) {
        Gender gender = Gender.Male;
        isDone(presenter.addToTree(data, gender));
    }

    public void delFromTree() {
        String fullName = scan("Введите ФИО -> ");
        isDone(presenter.delFromTree(fullName));
    }

    public void setTreePeak() {
        new GetTreePeaks(this).execute("");
        new GetTreeShort(this).execute("");
        int treeSize = presenter.getTreeSize();
        String indexStr = scan("Выберите для установки нового главы -> ");
        int index = checkNum(indexStr, "введите число - >") - 1;
        while(!(index < treeSize)) {
            System.out.println("Ввели число вне размера дерева!");
            index = checkNum(scan("Выберите для установки нового главы -> "), "введите число - >") - 1;
        }
        isDone(presenter.setPeakByIndex(index));
    }

    private void successMsg() {
        System.out.println("Успешно!");
    }

    private void failureMsg() {
        System.out.println("Неудача!");
    }

    private int checkNum(String numStr, String text) {
        while (!isNum(numStr)) {
            System.out.println(inputError);
            numStr = scan(text);
        }
        return Integer.parseInt(numStr);
    }

    private boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public void isDone(Boolean presenterMethod) {
        if (presenterMethod) {
            successMsg();
        } else { failureMsg(); };
    }


    public void printTreePeak() {
        System.out.println(presenter.getPeakTree());
    }

    public void printTreeShort() {
        presenter.getTreeShort();
    }

    public void saveTree() {
        new SaveTreeMenu(this).show();
        int menuSize = new SaveTreeMenu(this).getSize();
        String optionStr = scan("Выберите способ сохранения -> ");
        // использовать && или ||
        while (!isNum(optionStr) || Integer.parseInt(optionStr) >= menuSize) {
            optionStr = scan(inputError+"\n"+"Выберите 1 или 2 -> ");
        }
        new SaveTreeMenu(this).execute(Integer.parseInt(optionStr), "");
    }

    public void saveTreeObject() {
        isDone(presenter.saveTree("1"));
    }

    public void saveTreeByteArray() {
        isDone(presenter.saveTree("2"));
    }

    public void loadTree() {
        new LoadTreeMenu(this).show();
        int menuSize = new LoadTreeMenu(this).getSize();
        String optionStr = scan("Выберите способ сохранения -> ");
        String fileName = scan("введите имя файла без формата - > ");
        // использовать && или ||
        while (!isNum(optionStr) || Integer.parseInt(optionStr) >= menuSize) {
            optionStr = scan(inputError+"\n"+"Выберите 1 или 2.");
        }
        new LoadTreeMenu(this).execute(Integer.parseInt(optionStr), fileName);
    }

    public void loadTreeObject(String fileName) {
        isDone(presenter.loadTree("1", fileName));
    }

    public void loadTreeByteArray(String fileName) {
        isDone(presenter.loadTree("2", fileName));
    }

    public void printTree() {
        presenter.getTree();
    }

    public void printItem() {
        String fullName = scan("Введите ФИО для поиска -> ");
        presenter.getItem(fullName);
    }

    public void printItemShort() {
        String fullName = scan("Введите ФИО для поиска -> ");
        presenter.getItemShort(fullName);
    }

    public void getInfo() {
        new OutputMenu(this).show();
        int menuSize = new OutputMenu(this).getSize();
        String optionStr = scan("Выберите действие -> ");
        int option = checkNum(optionStr, "введите число -> ") - 1;
        while (option >= menuSize) {
            option = checkNum(scan("Выберите действие -> "), "введите число от 1 до "+menuSize+" -> ") - 1;
        }
        new OutputMenu(this).execute(option, "");
    }

    public void sortTree() {
        new SortMenu(this).show();
        int menuSize = new SortMenu(this).getSize();
        String optionStr = scan("Выберите действие -> ");
        int option = checkNum(optionStr, "введите число -> ") - 1;
        while (option >= menuSize) {
            option = checkNum(scan("Выберите действие -> "), "введите число от 1 до "+menuSize+" -> ") - 1;
        }
        new SortMenu(this).execute(option, "");
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

    public void delTree() {
        isDone(presenter.delTree());
    }

    public void exit() {
        presenter.exit();
    }


    public void changeItemParameter() {
        ChangeItemMenu curMenu = new ChangeItemMenu(this);
        int menuSize = curMenu.getSize();
        presenter.getTreeShort();
        int treeSize = presenter.getTreeSize();
        int itemIndex = checkNum(scan("Чьи параметры изменить -> "), "введите число -> ") - 1;
        while (itemIndex >= treeSize) {
            itemIndex = checkNum(scan("Выберите элемент дерева -> "), "введите число от 1 до "+treeSize+" -> ") - 1;
        }
        curMenu.show();
        int option = checkNum(scan("Какой параметр изменить -> "), "введите число -> ") - 1;
        while (option >= menuSize) {
            option = checkNum(scan("Выберите параметр -> "), "введите число от 1 до "+menuSize+" -> ") - 1;
        }
        curMenu.execute(option, Integer.toString(itemIndex));
    }

    public void setFullname(String itemIndex) {
        String fullName = scan("Введите ФИО -> ");
        isDone(presenter.setFullname(itemIndex, fullName));
    }

    public void setDateBirth(String itemIndex) {
        System.out.println("Введите:");
        int birthY = checkNum(scan("год р. в формате YYYY -> "), "год р. в формате YYYY -> ");
        int birthM = checkNum(scan("месяц р. в формате M -> "), "месяц р. в формате M -> ");
        int birthD = checkNum(scan("день р. в формате D -> "), "день р. в формате D -> ");
        isDone(presenter.setDateBirth(itemIndex, birthY, birthM, birthD));
    }

    public void setDateEndlife(String itemIndex) {
        System.out.println("Введите:");
        int EndlifeY = checkNum(scan("год c. в формате YYYY -> "), "год c. в формате YYYY -> ");
        int EndlifeM = checkNum(scan("месяц c. в формате M -> "), "месяц c. в формате M -> ");
        int EndlifeD = checkNum(scan("день c. в формате D -> "), "день c. в формате D -> ");
        isDone(presenter.setDateEndlife(itemIndex, EndlifeY, EndlifeM, EndlifeD));
    }

    public void setGender(String itemIndex) {
        System.out.print("1. Женский\n" +
                         "2. Мужской\n");
        int optionGender = 0;
        while (optionGender > 2 || optionGender < 1) {
            optionGender = checkNum(scan("Выберите пол - > "), "Выберите цифру 1 или 2 -> ");
        }
        Gender gender = optionGender == 1 ? Gender.Female : Gender.Male;
        isDone(presenter.setGenderChange(itemIndex, gender));
    }

    public void setMother(String itemIndex) {
        String motherName = scan("Введите ФИО мамы -> ");
        isDone(presenter.setMother(itemIndex, motherName));
    }

    public void setFather(String itemIndex) {
        String fatherName = scan("Введите ФИО папы -> ");
        isDone(presenter.setFather(itemIndex, fatherName));
    }

    public void setChildren(String itemIndex) {
        String childName = scan("Введите ФИО ребенка -> ");
        isDone(presenter.setChild(itemIndex, childName));
    }

    public void setCommit(String itemIndex) {
        String commit = scan("Введите доп. инфо -> ");
        isDone(presenter.setCommit(itemIndex, commit));
    }


}
