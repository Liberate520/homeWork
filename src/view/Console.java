package view;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    Presenter presenter;
    Scanner scn = new Scanner(System.in);
    int key;
    String nameFather;
    String nameMather;
    String name;
    String newName;
    int yearBirth;
    int yearDeath;

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (key != 6) {
            print(" Введите:\n " +
                    "0 - Вывести список членов семьи\n " +
                    "1 - Добавить члена семьи\n " +
                    "2 - Загрузить семью из файла\n " +
                    "3 - Вывести детей члена семьи\n " +
                    "4 - Найти члена семьи по имени \n " +
                    "5 - Изменить данные члена семьи \n " +
                    "6 - Выйти");
            key = scn.nextInt();
            switch (key) {
                case 0:
                    presenter.sortByName();
                    print(presenter.getInfo());
                    break;
                case 1:
                    enterPersonData();
                    break;
                case 2:
                    presenter.load("family.txt");
                    break;

                case 3:
                    printChildren();
                    break;
                case 4:
                    findMember();
                    break;
                case 5:
                    editMember();
                    break;
                case 6:
                    presenter.save("family.txt");
                    print("Работа завершена");
                    scn.close();
                    break;
                default:
                    break;
            }
        }
    }

    public void enterPersonData() {
        print("Введите имя:");
        name = scn.next();
        print("Введите имя отца:");
        nameFather = scn.next();
        print("Введите имя матери:");
        nameMather = scn.next();
        presenter.addMember(name, nameFather, nameMather);
    }

    public void printChildren() {
        print("Введите имя Родителя:");
        nameFather = scn.next();
        presenter.getChildren(nameFather);
    }

    public void findMember() {
        print("Введите искомое имя");
        name = scn.next();
        presenter.findMember(name);
    }

    public void editMember() {
        print("Введите имя человека: ");
        name = scn.next();
        if (presenter.findMember(name)) {
            print(" Что вы хотите изменить:\n " +
                    "1 - Имя\n " +
                    "2 - Год рождения\n " +
                    "3 - Год смери\n ");
            key = scn.nextInt();
            switch (key) {
                case 1:
                    print("Введите новое имя");
                    newName = scn.next();
                    presenter.editName(name, newName);
                    break;
                case 2:
                    print("Введите новый год рождения");
                    yearBirth = scn.nextInt();
                    presenter.editYearBirth(name, yearBirth);
                    break;
                case 3:
                    print("Введите новый год смерти");
                    yearDeath = scn.nextInt();
                    presenter.editYearDeath(name, yearDeath);
                    break;

            }
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
