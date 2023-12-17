package FamilyTree.view;

import FamilyTree.presenter.Presenter;

import java.util.Scanner;
public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте!");
        System.out.println("1. Добавить ...");
        System.out.println("2. Получить список ...");
        System.out.println("3. Отсортировать по имени");
        System.out.println("3. Отсортировать по возрасту");
        System.out.println("5. Закончить работу и выйти");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Укажите имя человека");
                String name = scanner.nextLine();
                System.out.println("укажите возраст человека");
                int age = Integer.parseInt(scanner.nextLine());
                presenter.addHuman(name,age);
//  семинар 5, 50 минута
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
