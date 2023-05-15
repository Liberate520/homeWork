package View;

import Model.Human;

import java.util.List;
import java.util.Scanner;

public class FamilyTreeView {
    private Scanner scanner;

    public FamilyTreeView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Вывести информацию о человеке по имени");
        System.out.println("3. Вывести список всех людей");
        System.out.println("4. Сохранить данные в файл");
        System.out.println("5. Загрузить данные из файла");
        System.out.println("6. Отсортировать список по имени");
        System.out.println("7. Выход");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void clearBuffer() {
        scanner.nextLine(); // Очистка буфера после ввода числа
    }

    public void displayHuman(Human human) {
        System.out.println(human);
    }

    public void displayAllHumans(List<Human> humanList) {
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

    public String getHumanName() {
        System.out.println("Введите имя человека:");
        return scanner.nextLine();
    }

    public String getFileNameForSave() {
        System.out.println("Введите имя файла для сохранения:");
        return scanner.nextLine();
    }

    public String getFileNameForLoad() {
        System.out.println("Введите имя файла для загрузки:");
        return scanner.nextLine();
    }
}
