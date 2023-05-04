package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work = true;

    public Console(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Добрый день!");
        while (work){
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить человека\n" +
                    "2. Вывести список \n" +
                    "3. Завершить работу");
            String command = scanner.nextLine();

            switch (command){
                case "1":
                    addHuman();
                    break;
                case "2":
                    getInfo();
                    break;
                case "3":
                    finish();
                    break;
                default:
                    System.out.println("Неправильный ввод. Повторите: ");

            }

        }
    }

    private void finish(){
        work = false;
    }
    private void getInfo(){
        presenter.getInfo();
    }
    private void addHuman(){
        System.out.println("Введите Имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите Фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите возраст");
        int age = Integer.parseInt(scanner.nextLine());
        presenter.addHuman(firstName,lastName,age);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
