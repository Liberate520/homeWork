package view;

import presenter.Presenter;

import java.util.Scanner;

import model.tree.classes.Human;

public class AddPerson {
    private Scanner scanner = new Scanner(System.in, "cp866");
    private Presenter presenter;
    private SearchPerson search;

    public AddPerson(Presenter presenter) {
        this.presenter = presenter;
    }

    public void addPerson() {
        search = new SearchPerson(presenter);
        System.out.println("Введите данные нового человека: ");
        Human newHuman = new Human();
        presenter.setHuman(newHuman);

        boolean loop = false;
        while (!loop) {

            System.out.println("Введите данные отца: \n" +
                    " 1 - Данные неизвестны \n" +
                    " 2 - Поиск по списку \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    newHuman.setFather(null);
                    loop = true;
                    break;
                case "2":
                    boolean found = false;
                    while (!found) {
                        Human father = search.searchPerson();
                        System.out.println(father != null ? father.toString() : "Не найдено!");
                        System.out.println("Подтвердить выбор?\n" +
                                "1 - Выбрать\n" +
                                "2 - Новый поиск\n" +
                                "3 - Данные неизвестны\n");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "1":
                                newHuman.setFather(father);
                                found = true;
                                break;
                            case "2":
                                break;
                            case "3":
                                newHuman.setFather(null);
                                found = true;
                                break;
                        }
                    }
                    loop = true;
                    break;
                default:
                    System.out.println("Введите правильно значение!");
                    break;
            }
        }

        loop = false;
        while (!loop) {

            System.out.println("Введите данные матери: \n" +
                    " 1 - Данные неизвестны \n" +
                    " 2 - Поиск по списку \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    newHuman.setMother(null);
                    loop = true;
                    break;
                case "2":
                    boolean found = false;
                    while (!found) {
                        Human mother = search.searchPerson();
                        System.out.println(mother != null ? mother.toString() : "Не найдено!");
                        System.out.println("Подтвердить выбор?\n" +
                                "1 - Выбрать\n" +
                                "2 - Новый поиск\n" +
                                "3 - Данные неизвестны\n");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "1":
                                newHuman.setMother(mother);
                                found = true;
                                break;
                            case "2":
                                break;
                            case "3":
                                newHuman.setMother(null);
                                found = true;
                                break;
                        }
                    }
                    loop = true;
                    break;
                default:
                    System.out.println("Введите правильно значение!");
            }
        }
        presenter.addPerson(newHuman);
    }
}
