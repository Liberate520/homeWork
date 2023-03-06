package HW01.ui;

import HW01.model.Person;
import HW01.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {


    private Menu menu;
    private Boolean workFlag;
    private Presenter presenter;
    private Validator validator;
    private Scanner scanner = new Scanner(System.in);

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
        System.out.println(presenter.testTree());
    }

    public void loadData() throws IOException, ClassNotFoundException {
        System.out.println("загрузка сохраненных данных");
        System.out.println(presenter.loadData());
    }

    public void saveData() throws IOException {
        System.out.println("сохранение данных");
        System.out.println(presenter.saveData());
    }

    public void addPerson(){
        System.out.println("Введите данные человека");
        System.out.println("Введите имя");
        String personName = scanner.next();
        if (presenter.checkName(personName)) {
            System.out.println("такой человек уже есть");
        }else{
            System.out.println("Введите пол");
            String personSex = scanner.next();
            System.out.println("год рождения");
            Integer birthData = scanner.nextInt();
            System.out.println("год смерти");
            Integer deathData = scanner.nextInt();

            System.out.println(presenter.addPerson(personName,personSex, birthData, deathData));
        }
    }
    public void updatePerson(){
        System.out.println("Введите новые данные о человеке");
        System.out.println("Введите имя");
        String personName = scanner.next();
        if (presenter.checkName(personName)) {
            System.out.println("человек найден \n");
            System.out.println(presenter.searchPerson(personName));
            System.out.println("введите год рождения или '0'\n");
            Integer birthDate = scanner.nextInt();
            System.out.println("введите год смерти или '0'\n");
            Integer deathDate = scanner.nextInt();
            System.out.println(presenter.updatePerson(personName, birthDate, deathDate));
            System.out.println(presenter.searchPerson(personName));
        }else {
            System.out.println("такого человека нет");
        }
    }
    public void personEnvironment(){
        System.out.println("Введите имя(без пробелов) человека для изменения данных об его окружени\n");
        String personName = scanner.next();
        if (presenter.checkName(personName)) {
            System.out.println("человек найден \n");
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
            switch (token) {
                case ("1"): {
                    System.out.println("Введите имя отца(без пробелов) или 'unknown'\n");
                    fatherName = scanner.next();
                    break;
                }
                case ("2"): {
                    System.out.println("Введите имя матери(без пробелов) или 'unknown'\n");
                    motherName = scanner.next();

                    break;
                }
                case ("3"): {
                    System.out.println("Введите имя ребенка(без пробелов) или 'unknown'\n");
                    childName = scanner.next();
                    System.out.println("Введите пол ребенка\n");
                    childSex = scanner.next();
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + token);
            }
            System.out.println(presenter.personEnvironment(personName, fatherName, motherName, childName, childSex));
            }else {
            System.out.println("такого человека нет");
        }

    }

    public void searchPerson(){
        System.out.println("Введите имя человека");
        String personName = scanner.next();
        if (presenter.checkName(personName)) {
            System.out.println(presenter.searchPerson(personName));
        }else{
            System.out.println("человек не найден");
        }

    }

    public void printTree(){
        System.out.println(presenter.printTree());
    }

    public void sortByName(){
        presenter.sortByName();
        System.out.println(presenter.printTree());
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        System.out.println(presenter.printTree());
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


}
