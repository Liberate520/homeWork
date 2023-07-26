package FamilyTree.view;

import FamilyTree.model.Human.Human;
import FamilyTree.presenter.Presenter;

import java.util.Scanner;

public class UI implements View {
    private int id = -1;
    private Scanner sc;
    private Presenter presenter;
    private boolean flag;
    private MMenu mMenu;

    public UI() {
        sc = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true;
        mMenu = new MMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void Start() {
        System.out.println("Привет.");
        while (flag) {
            System.out.println(mMenu.menu());
            int choice = sc.nextInt();
            mMenu.exct(choice);
        }
    }
        public void end(){
            System.out.println("До связи.");
            flag = false;
        }

        public void add () {
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

