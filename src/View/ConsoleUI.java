package View;
import Model.Gender;
import Model.HouseHold;
import Model.Human;
import Presenter.Presenter;
import java.util.*;

public class ConsoleUI implements Viewable {
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;

    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void start(){
        System.out.println("Hello, World!");
        while(work){
            System.out.println("1. Добавить человека");
            System.out.println("2. Показать семейное дерево");
            System.out.println("3. Отсортировать по именам");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Закончить ввод");
            System.out.println("6. Сохранить дерево в файл");
            System.out.println("Введите значение от 1 до 6: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    add();
                    break;
                case 2:
                    listInfo();
                    break;
                case 3:
                    sort_name();
                    break;
                case 4:
                    sort_age();
                    break;
                case 5:
                    end();
                    break;
                case 6:
                    saveToFile();
                    break;
                default:
                    error();
            }
        }
    }

    public void add() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите пол(1 - мужчина, 2 - Женщина): ");
        int choice = Integer.parseInt(scanner.nextLine());
        Gender gender = null;
        switch (choice){
            case 1:
                gender = Gender.MAN;
                break;
            case 2:
                gender = Gender.WOMAN;
                break;
        }
        Human human = new Human(name, age, gender);
    }
    public void listInfo() {
        presenter.getListInfo();
    }
    public void sort_name(){
        presenter.sortByName();
    }
    public void sort_age(){
        presenter.sortByAge();
    }
    public void end(){
        scanner.close();
        work = false;
    }
    private void error(){
        System.out.println("Ошибка, попробуйте заного");
    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);
    }

    public void saveToFile(){
        presenter.saveToFile();
    }

}
