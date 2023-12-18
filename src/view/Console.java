package view;

import model.family_tree.FamilyTree;
import model.file_handler.FileHandler;
import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class Console implements View{
    private final Scanner scanner;
    Presenter presenter;

    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        load();
        System.out.println("Привет! \n");
        while (true) {
            System.out.println("1)Добавить человека \n");
            System.out.println("2)Добавить ребенка \n");
            System.out.println("3)Сортировать по имени \n");
            System.out.println("4)Сортировать по возрасту \n");
            System.out.println("5)Вывести дерево на экран \n");
            System.out.println("6)Выход \n");
            System.out.println("Выберите действие");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHumanInTree();
                    break;
                case "2":
                    addChildren();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByAge();
                case "5":
                    printAnswer(printAllTree());
                    break;
                case "6":
                    save();
                    System.out.println("До новых встречь!");
                    return;
            }
        }

    }

    private void load() {
        presenter.load();
    }

    private void save() {
        presenter.save();
    }


    private void addHumanInTree() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите пол в фомате М или Ж");
        String gender = scanner.nextLine().toUpperCase();
        if(gender.equals("М")){
            Gender gender1 = Gender.Mail;
            presenter.addHumanInTree(name,gender1,getBirthDay());
        } else {
            Gender gender1 = Gender.Female;

            presenter.addHumanInTree(name,gender1,getBirthDay());
        }
    }

    private void addChildren() {
        System.out.println("Введите имя родителя:");
        String parent = scanner.nextLine();
        System.out.println("ВВедите имя ребёнка:");
        String name = scanner.nextLine();
        System.out.println("ВВедите пол ребенка в формате М или Ж:");
        String gender = scanner.nextLine().toUpperCase();
        if(gender.equals("М")){
            Gender gender1 = Gender.Mail;
            presenter.addChildren(parent,name,gender1,getBirthDay());
        } else {
            Gender gender1 = Gender.Female;

            presenter.addChildren(parent,name,gender1,getBirthDay());
        }
    }


    private void sortByAge() {
        presenter.sortByAge();
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private String printAllTree() {
        return presenter.printAllTree();
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
