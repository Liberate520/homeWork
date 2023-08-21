package View;

import Model.BaseCharacter.Gender;
import Model.BaseCharacter.Human;
import Presenter.Presenter;

import java.io.Serializable;
import java.util.*;

public class ConsoleUI implements Viewable, Serializable {
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
        System.out.println("Здравствуйте!");
        while(work){
            System.out.println("1. Добавить человека");
            System.out.println("2. Показать семейное дерево");
            System.out.println("3. Отсортировать по именам");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Сохранить дерево в файл");
            System.out.println("6. Считать дерево из файла");
            System.out.println("7. Закончить ввод");
            System.out.println("Введите значение от 1 до 7: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    add();
                    break;
                case 2:
                    listInfo();
                    System.out.println("Дерево распечатано");
                    break;
                case 3:
                    sort_name();
                    System.out.println("Дерево отсортировано по имени");
                    break;
                case 4:
                    sort_age();
                    System.out.println("Дерево отсортировано по возрасту");
                    break;
                case 5:
                    saveToFile();
                    System.out.println("Дерево сохранено в папку Data");
                    break;
                case 6:
                    readToFile();
                    System.out.println("Дерево считано с папки Data");
                    break;
                case 7:
                    end();
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
        presenter.addHouseHold(new Human(name, age, gender));
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

    public void saveToFile() {
        presenter.saveToFile();
    }

    public void readToFile() {
        presenter.readFile("src/Data/text.txt");
    }

}
