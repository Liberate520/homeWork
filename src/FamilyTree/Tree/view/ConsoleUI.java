package FamilyTree.Tree.view;

import FamilyTree.Tree.presenter.Presenter;


import java.util.Scanner;


public class ConsoleUI implements View{

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;


    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        work = true;
        while (work) {
            header();
            menuUi();
            System.out.print("Выберите пункт Меню -> ");
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Введите число!");
            }
        }
    }
    private void header() {
        System.out.println("\nПрограмма для работы с семейным древом");
    }
    private void menuUi() {
        System.out.println(menu.menu());
    }
    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }


    private void errorInput() {
        System.out.println("Введены некорректные данные");
    }

    public void Finish() {
        scanner.close();
        work = false;
    }

    public void sortDateOfBirth() {
        presenter.sortDateOfBirth();
        
    }

    public void sortPatronymic() {
        presenter.sortPatronymic();
        
    }

    public void sortName() {
        presenter.sortName();
        
    }

    public void getHumansInfo() {
        presenter.getHumansInfo();
    }

    public void addHumans(){
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Введите отчество человека");
        String patronymic = scanner.nextLine();
        System.out.println("Введите дату рождения человека");
        int dateOfBirth = scanner.nextInt();
        presenter.addHumans(name, patronymic, dateOfBirth );
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }

}
