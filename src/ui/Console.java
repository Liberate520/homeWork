package ui;

import java.util.Scanner;

import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public int id;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }


    @Override
    public void print(String text) {
        System.out.println(text);

    }
    
    @Override
    public void start() {
        System.out.println("Привет!");
        while (work) {
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            mainMenu.execute(numCommand);
        }
        // while (work) {
        //     System.out.println("Выберите команду:\n" +
        //             "1. Добавить родственника\n" +
        //             "2. Получить список людей\n" +
        //             "3. Завершить работу");
        //     String command = scanner.nextLine();
        //     switch (command) {
        //         case "1":
        //             addHuman();
        //             break;
        //         case "2":
        //             getInfo();
        //             break;
        //         case "3":
        //             finish();
        //             break;

        //         default:
        //             System.out.println("Команда введена неверно. Попробуйте еще раз.");

        //     }
        //     System.out.println();
        // }

    }

    public void finish() {
        System.out.println("До скорых встреч!");
        work = false;
    }
    
    public void getInfo() {
        presenter.getInfo();
    }
    
    public void addHuman() {
        //System.out.println("Введите id");
        
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения в формате дд.мм.гггг");
        String dateOfBirth = scanner.nextLine();
        presenter.addHuman(++id, name, surname, dateOfBirth, null);

    }
    
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
