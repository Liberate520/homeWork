package HW01.ui;

import HW01.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {

    private Scanner scanner;
    private Menu menu;
    private Boolean workFlag;
    private Presenter presenter;
    private Validator validator;

    @Override
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        workFlag = true;
        validator = new Validator();
        while (workFlag){
            printMenu();
            menu.execute(validator.checkInput(scanner.nextLine(),menu.getMenuRowsValue()));
        }
    }
    private void printMenu() {
        System.out.println(menu.printMenu());
    }

    public void finish(){
        workFlag = false;
    }

    public void errorInput(){
        System.out.println("Ошибка ввода");;
    }
    public void testTree(){
        System.out.println("заполнение дерева тестовым набором сведений");
        presenter.testTree();
    }

    public void loadData() throws IOException, ClassNotFoundException {
        System.out.println("загрузка сохраненных данных");
        presenter.loadData();
    }

    public void saveData() throws IOException {
        System.out.println("сохранение данных");
        presenter.saveData();
    }

    public void addPerson(){
        System.out.println("Введите данные человека");
        presenter.addPerson();
    }
    public void updatePerson(){
        System.out.println("Введите новые данные о человеке");
        presenter.updatePerson();
    }
    public void personEnvironment(){
        System.out.println("Введите новые данные об окружении");
        presenter.personEnvironment();
    }

    public void searchPerson(){
        System.out.println("Введите имя человека");
        presenter.searchPerson(scanner.nextLine());
    }

    public void printTree(){
        presenter.printTree();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


}
