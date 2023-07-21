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
            view.displayMenu();
            int choice = view.getUserChoice();
            view.clearBuffer();

            switch (choice) {
                case 1:
                    String name = view.getHumanName();
                    System.out.println("Введите год рождения:");
                    int yearOfBirth = scanner.nextInt();
                    view.clearBuffer();
                    System.out.println("Введите пол (m/f):");
                    String gender = scanner.nextLine();

                    presenter.addHuman(name, yearOfBirth, gender);
                    break;
                case 2:
                    String searchName = view.getHumanName();
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
                    String saveFileName = view.getFileNameForSave();
                    try {
                        presenter.saveToFile(saveFileName);
                        System.out.println("Данные сохранены в файл " + saveFileName);
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении данных: " + e.getMessage());
                    }
                    break;
                case 5:
                    String loadFileName = view.getFileNameForLoad();
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

