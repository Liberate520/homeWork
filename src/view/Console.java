package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
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
        while (true) {
            System.out.println("1)Добавить человека \n");
            System.out.println("2)Напечатать все дерево \n");
            System.out.println("3)Сортировать по имени \n");
            System.out.println("4)Сортировать по возрасту \n");
            System.out.println("5)Сортировать по возрасту \n");
            System.out.println("6)Выход \n");
            System.out.println("Выберите действие");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHumanInTree();
                    break;
                case "2":
                    printAllTree();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByAge();
                case "5":
                    break;
                case "6":
                    return;
            }
        }

    }


    private void sortByAge() {
        presenter.sortByAge();
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void printAllTree() {
        presenter.printAllTree();
    }

    private void addHumanInTree() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();
        if(gender.equals("М")){
            Gender gender1 = Gender.Mail;
            presenter.addHumanInTree(name,gender1,getBirthDay());
        } else {
            Gender gender1 = Gender.Female;

            presenter.addHumanInTree(name,gender1,getBirthDay());
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public LocalDate getBirthDay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год: ");
        int x = sc.nextInt();
        System.out.println("Введите месяц: ");
        int y = sc.nextInt();
        System.out.println("Введите день: ");
        int z = sc.nextInt();
        return LocalDate.of(x,y,z);
    }

}
