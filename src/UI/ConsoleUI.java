package UI;

import Presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public  void start(){
        work = true;
        while (work == true) {
            System.out.println("Выберите действие: \n" +
                    "1. Показать всех членов семьи;\n" +
                    "2. Найти члена семьи по имени;\n" +
                    "3. Добавить члена семьи; \n" +
                    "4. Выход.");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAll();
                    break;
                case "2":
                    findByName();
                    break;
                case "3":
                    addMember();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
    private void showAll(){
        presenter.showAll();
    }

    private void findByName(){
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        presenter.findByName(name);
    }
    private void addMember(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (Male, Female): ");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения в формате dd/mm/yyyy: ");
        String dateBirth = scanner.nextLine();
        System.out.println("Введите имя матери: ");
        String nameMother = scanner.nextLine();
        System.out.println("Введите имя отца: ");
        String nameFather = scanner.nextLine();
        presenter.addMember(name, gender, dateBirth, nameMother, nameFather);
    }
    private void exit(){
        System.out.println("Работа завершена");
        scanner.close();
        work = false;

    }


    @Override
    public void print(String text){
        System.out.println(text);
    }
}
