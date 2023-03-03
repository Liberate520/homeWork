package HWGT.ui;

import HWGT.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {

    private Scanner scanner = new Scanner(System.in);
    private Menu menu;
    private Boolean workFlag;
    private Presenter presenter;
    private Validator validator;

    @Override
    public void start() throws IOException, ClassNotFoundException {
        menu = new Menu(this);
        workFlag = true;
        validator = new Validator();
        while (workFlag){
            printMenu();
            menu.execute(validator.checkInput(scanner.next(),menu.getMenuRowsValue()));
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
        System.out.println(presenter.saveData());
    }

    public void addPerson(){
        System.out.println("Введите данные человека");
        System.out.println("Введите имя");
        String personName = scanner.next();
        if (presenter.checkName(personName)){
            System.out.println("Такой человек уже есть");
        }else {
            System.out.println("Введите пол");
            String personSex = scanner.next();
            System.out.println("Введите год рождения");
            Integer birthDate = scanner.nextInt();
            System.out.println("Введите год смерти");
            Integer deathDate = scanner.nextInt();
            System.out.println(presenter.addPerson(personName, personSex, birthDate, deathDate));
        }
    }
    public void updatePerson(){
        System.out.println("Введите новые данные о человеке");
        System.out.println("Введите имя");
        String personName = scanner.next();
        if (presenter.checkName(personName)) {
            System.out.println("Человек найден \n");
            System.out.println(presenter.searchPerson(personName));
            System.out.println("Введите год рождения или '0' \n");
            Integer birthDate = scanner.nextInt();
            System.out.println("Введите год рождения или '0' \n");
            Integer deathDate = scanner.nextInt();
            System.out.println(presenter.updatePerson(personName, birthDate, deathDate));
        } else {
            System.out.println("Такой человек не найден");
        }
    }
    public void personEnvironment(){
        System.out.println("Введите имя (без пробелов) человека для изменения данных об его окружении \n");
        String personName = scanner.next();
        if (presenter.checkName(personName)){
            System.out.println("Человек найден \n");
            System.out.println(presenter.searchPerson(personName));
            System.out.println("Выберите какую информацию вы желаете добавить");
            System.out.println("1 - Отец");
            System.out.println("2 - Мать");
            System.out.println("3 - Ребенок \n");
            String fatherName = "unknown";
            String motherName = "unknown";
            String childName = "unknown";
            String childSex = "male";

            String token = scanner.next();
            switch (token){
                case ("1"):{
                    System.out.println("Введите имя отца(без пробелов) или 'unknown'\n");
                    fatherName = scanner.next();
                    break;
                }
                case ("2"):{
                    System.out.println("Введите имя матери(без пробелов) или 'unknown'\n");
                    motherName = scanner.next();
                    break;
                }
                case ("3"):{
                    System.out.println("Введите имя ребенка(без пробелов) или 'unknown'\n");
                    motherName = scanner.next();
                    System.out.println("Введите пол ребенка\n");
                    childSex = scanner.next();
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + token);
            }
            System.out.println(presenter.personEnvironment(personName, fatherName, motherName, childName, childSex));
        }else {System.out.println("Такого человека нет");}

    }

    public void searchPerson(){
        System.out.println("Введите имя человека");
        String personName = scanner.next();
        if (presenter.checkName(personName)){
            System.out.println(presenter.searchPerson(personName));
        }
        else{
            System.out.println("Человек не найден");
        }
    }

    public void printTree(){
        System.out.println(presenter.printTree());
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void sortByName(){
        presenter.sortByName();
        System.out.println(presenter.printTree());
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
        System.out.println(presenter.printTree());
    }

}