package model.tree.classes;

import java.util.Scanner;

public class SetHuman {
    Tree tree;
    SearchPerson search;

    public SetHuman(Tree tree) {
        this.tree = tree;
        search = new SearchPerson(tree);
    }

    public void settingHuman() {
        Human human = new Human();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные нового человека: ");

        System.out.println("Input name: ");
        human.setName(scanner.nextLine());

        System.out.println("Input patronymic: ");
        human.setPatronymic(scanner.nextLine());

        System.out.println("Input surname: ");
        human.setSurname(scanner.nextLine());

        boolean loop = false;
        while (!loop) {
            System.out.println("Input date of birth: ");
            String dateBirthString = scanner.nextLine();
            try {
                human.setDateBirth(Integer.parseInt(dateBirthString));
                loop = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода Catch!");
            }
        }

        loop = false;
        while (!loop) {
            System.out.println("Input date of death: ");
            String dateDeathString = scanner.nextLine();
            try {
                human.setDateDeath(Integer.parseInt(dateDeathString));
                loop = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода Catch!");
            }
        }

        loop = false;
        while (!loop) {

            System.out.println("Введите данные отца: \n" +
                    " 1 - Данные неизвестны \n" +
                    " 2 - Поиск по списку \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    human.setFather(null);
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
                                human.setFather(father);
                                found = true;
                                break;
                            case "2":
                                break;
                            case "3":
                                human.setFather(null);
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
                    human.setMother(null);
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
                                human.setMother(mother);
                                found = true;
                                break;
                            case "2":
                                break;
                            case "3":
                                human.setMother(null);
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
        tree.addPerson(human);
    }
}
