package view;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Scanner scanner;
    Presenter presenter;

    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("Привет! \n");
        System.out.println("1)Добавить человека \n");
        System.out.println("Добавить ребенка \n");
        System.out.println("Сортировать по имени \n");
        System.out.println("Сортировать по возрасту \n");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                System.out.println("Введите ");
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
        }

    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
