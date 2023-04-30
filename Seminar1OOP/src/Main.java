import Model.FamilyTreeModel;
import Presenter.FamilyTreePresenter;
import View.FamilyTreeView;
import Model.Human;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeModel model = new FamilyTreeModel();
        FamilyTreeView view = new FamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Вывести информацию о человеке по имени");
            System.out.println("3. Вывести список всех людей");
            System.out.println("4. Сохранить данные в файл");
            System.out.println("5. Загрузить данные из файла");
            System.out.println("6. Отсортировать список по имени");
            System.out.println("7. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после ввода числа

            switch (choice) {
                case 1:
                    System.out.println("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите год рождения:");
                    int yearOfBirth = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера после ввода числа
                    System.out.println("Введите пол (m/f):");
                    String gender = scanner.nextLine();

                    presenter.addHuman(name, yearOfBirth, gender);
                    break;
                case 2:
                    System.out.println("Введите имя человека:");
                    String searchName = scanner.nextLine();
                    Human foundHuman = presenter.getHumanByName(searchName);
                    if (foundHuman != null) {
                        view.displayHuman(foundHuman);
                    } else {
                        System.out.println("Человек не найден");
                    }
                    break;
                case 3:
                    view.displayAllHumans(presenter.getAllHuman());
                    break;
                case 4:
                    System.out.println("Введите имя файла для сохранения:");
                    String saveFileName = scanner.nextLine();
                    try {
                        presenter.saveToFile(saveFileName);
                        System.out.println("Данные сохранены в файл " + saveFileName);
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении данных: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Введите имя файла для загрузки:");
                    String loadFileName = scanner.nextLine();
                    try {
                        presenter.loadFromFile(loadFileName);
                        System.out.println("Данные загружены из файла " + loadFileName);
                    } catch (IOException e) {
                        System.out.println("Ошибка при загрузке данных: " + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        System.out.println("Ошибка при загрузке данных: класс не найден");
                    }
                    break;
                case 6:
                    presenter.sortByName();
                    System.out.println("Список отсортирован по имени");
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор");
                    break;
            }
        }
        scanner.close();
    }
}

