package family_tree.family_tree.view;

import family_tree.family_tree.model.Gender;
import family_tree.family_tree.presenter.Presenter;


import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветюли!");
        while (work){
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu() {
        String  choiceStr = scanner.nextLine();
        // метод проверочки строки
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
//        switch (choice){
//            case "1":
//                addHuman();
//                break;
//            case "2":
//                getHumanListInfo();
//                break;
//            case "3":
//                sortByName();
//                break;
//            case "4":
//                sortByAge();
//                break;
//            case "5":
//                finish();
//                break;
//            default:
//                error();
//        }
    }
    private void printMenu(){
        System.out.println(menu.print());
//        System.out.println("1. Добавить человека");
//        System.out.println("2. Получить список");
//        System.out.println("3. Отсортировать по имени");
//        System.out.println("4. Отсортировать по возрасту");
    }

    private void error() {
        System.out.println("Вы накосячили с данными");
    }

    public void finish() {
        System.out.println("Пока !");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя Human");
        String name = scanner.nextLine();
//        System.out.println("Укажите возраст: ");
//        String ageStr = scanner.nextLine();
        System.out.println("Укажите дату рождения");
        String birthDate = scanner.nextLine();
        // проверочка
//        int age = Integer.parseInt(ageStr);
//        presenter.addHuman(name, age);
//        System.out.println("Укажите дату смерти");
//        String deathDate = scanner.nextLine();
        System.out.println("Укажите пол (гендер)");
        String gender = scanner.nextLine();
//        presenter.addHuman(name, LocalDate.parse(birthDate), LocalDate.parse(deathDate), Gender.valueOf(gender));
        presenter.addHuman(name, LocalDate.parse(birthDate), Gender.valueOf(gender));
    }


    @Override
    public void answer(String answer) {
        System.out.println(answer);

    }
}
