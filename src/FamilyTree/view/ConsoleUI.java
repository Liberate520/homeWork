package FamilyTree.view;

import FamilyTree.presenter.Presenter;

import java.util.Scanner;
public class ConsoleUI implements View {
    private Menu menu;
    private Scanner scanner;
    private Presenter presenter;
    boolean work;

    public ConsoleUI(){
        presenter = new Presenter(this);
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void print(String answer) {
        System.out.println(answer);
    }


    @Override
    public void start() {
        System.out.println("Здравствуйте!");
        while (true) {
            System.out.println("1. Добавить человека в дерево");
            System.out.println("2. Получить список семьи");
            System.out.println("3. Отсортировать людей по имени");
            System.out.println("4. Отсортировать по дню рождения");
            System.out.println("5. Закончить работу и выйти");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    getHumanListInfo();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByBirthDate();
                    break;
                case "5":
                    finish();
                    break;


            }
        }
    }

    private void addHuman(){
        System.out.println("Укажите имя нового человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол человека (Male/Female)");
        String gend = scanner.nextLine();
        String gender = gend.substring(0,1).toUpperCase()+gend.substring(1);
        System.out.println("Укажите день рождения человека в формате 1999-09-09");
        String birthDate = scanner.nextLine();
//                System.out.println("укажите город проживания");
//                String place_of_residence =scanner.nextLine;
//                int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите id отца человека");
        long fatherId = Integer.parseInt(scanner.nextLine());
//                String fatherId = scanner.nextLine();
        System.out.println("Укажите id матери человека");
        long motherId = Integer.parseInt(scanner.nextLine());
//                String motherId = scanner.nextLine();
        presenter.addHuman(name, gender, birthDate, fatherId, motherId);
    }

    private void getHumanListInfo(){
        presenter.getHumanListInfo();
    }

    public void getHumanList() {
        presenter.getHumanListInfo();
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    private void finish() {
        System.out.println("До следующей встречи!");
        work = false;
    }












//    public void getHumanList(){
//        presenter.getHumanList();
//    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
