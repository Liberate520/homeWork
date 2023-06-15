package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu mainMenu;
    private boolean repeatFlag;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        repeatFlag = true;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Выберите действие:");
        while (repeatFlag) {
            System.out.println(mainMenu.menuText());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода!");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    @Override
    public void finish() {
        System.out.println("Работа завершена.");
        System.exit(0);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= 5;
    }

    public List<String> getNewPersonInfo(){
        List<String> itemInfo = new ArrayList<>();
        System.out.println("Введите имя:");
        itemInfo.add(scanner.nextLine());
        System.out.println("Введите год рождения в формате \"YYYY\":");
        itemInfo.add(scanner.nextLine());
        System.out.println("Введите месяц рождения в формате \"M\":");
        itemInfo.add(scanner.nextLine());
        System.out.println("Введите день рождения в формате \"D\":");
        itemInfo.add(scanner.nextLine());
        System.out.println("Укажите пол (m - мужской, f - женский):");
        itemInfo.add(scanner.nextLine());
        System.out.println("Введите имя матери (\"-\" при отсутствии):");
        itemInfo.add(scanner.nextLine());
        System.out.println("Введите имя отца (\"-\" при отсутствии):");
        itemInfo.add(scanner.nextLine());
        return itemInfo;
    }

    public boolean askToSave(){
        System.out.println("Сохранить изменения в файл?");
        System.out.println("Y - да, N - нет.");
        if (scanner.nextLine().equalsIgnoreCase("Y")) return true;
        else return false;
    }

    public void printLoadData() throws IOException, ClassNotFoundException {
        presenter.printLoadData();
    }

    public void printSortByName() throws IOException, ClassNotFoundException {
        presenter.printSortByName();
    }

    public void printSortByDOB() throws IOException, ClassNotFoundException {
        presenter.printSortByDOB();
    }

    public void addNewPerson() throws IOException, ClassNotFoundException {
        presenter.addNewPerson();
    }
}
