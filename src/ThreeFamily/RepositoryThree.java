package ThreeFamily;

import View.View;
import Human.Human;

import java.util.Scanner;
import View.ConsoleUI;
public class RepositoryThree implements Repository {
    IThree iThree = new TreeFamily();
    Scanner sc = new Scanner(System.in);
    View view =  new ConsoleUI();

    @Override
    public void getNum(int num) {

        switch (num) {
            case 1:
                System.out.println("Просмотр всех людей");
                iThree.allHuman();
                view.start();
            case 2:
                System.out.println("Просмотр одного человека дерева");
                System.out.println("Введите имя человека ");
                String human = sc.nextLine();
                iThree.LoopHuman(human);
                view.start();
            case 3:
                System.out.println("Добавление человека");
                System.out.println("Введите имя нового человека ");
                String name = sc.nextLine();
                System.out.println("Введите возраст " + name);
                int age = sc.nextInt();
                Human people = new Human(name, age);
                iThree.addTreeFamily(people);
                System.out.println("Человек создан");
                view.start();
            case 4:
                System.out.println("Создание связи");
                System.out.println("Введите имя ребенка ");
                String baby1 = sc.nextLine();
                Human baby = iThree.searchHuman(baby1);
                System.out.println("Введите имя первого родителя ");
                String parent1 = sc.nextLine();
                Human parentOne = iThree.searchHuman(parent1);
                System.out.println("Введите имя второго родителя ");
                String parent2 = sc.nextLine();
                Human parentTwo = iThree.searchHuman(parent2);
                iThree.addChildren(baby, parentOne, parentTwo);
                System.out.println("Связь создана");
                view.start();
            case 5:
                System.out.println("Инфо о создании человека и связи");
                view.start();
            default:
                System.out.println("Такой опции еще не существует");
                view.start();
        }


    }
}
