package FamilyTree.view;

import FamilyTree.model.Human.Human;
import FamilyTree.presenter.Presenter;

import java.util.Scanner;

public class UI implements View {
    private int id = -1;
    private Scanner sc;
    private Presenter presenter;
    private boolean flag;

    public UI() {
        sc = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void Start() {
        System.out.println("Привет.");
        while (flag) {
            System.out.println("Выберите команду:\n" +
                    "1. Добавить в древо\n" +
                    "2. Получить список древа\n" +
                    "3. Отсортировать список по возрасту\n" +
                    "4. Отсортировать список по имени");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    getlistinfo();
                    break;
                case 3:
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    System.out.println("До свзяи.");
                    flag = false;
                    break;
                default:
                    System.out.println("Такой комманды нет.");
            }
        }
    }

        public void add() {
            System.out.print("Введите имя: ");
            String name = sc.nextLine();
            System.out.print("Введите фамилию: ");
            String surname = sc.nextLine();
            System.out.print("Введите возраст: ");
            int age = sc.nextInt();
            System.out.print("Введите пол: ");
            String genderr = sc.nextLine();
            presenter.add(new Human(id++, age, name, surname, genderr));
            System.out.println("Успешно.");
        }

        public void getlistinfo () {
            presenter.getHumanList();
            System.out.println("Успешно.");
        }

        public void sortByName () {
            presenter.sortbyname();
            getlistinfo();
        }
        public void sortByAge () {
            presenter.sortbyage();
            getlistinfo();
        }
}

