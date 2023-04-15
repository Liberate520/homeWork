package view;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    Presenter presenter;
    Scanner scn = new Scanner(System.in);
    int key;
    String nameFather;
    String nameMather;
    String name;
    @Override
    public void print(String text) {
        System.out.println(text);
    }
    @Override
    public void start() {
        while (key != 5) {
            print(" Введите:\n " +
                            "0 - Вывести список членов семьи\n " +
                            "1 - Добавить члена семьи\n " +
                            "2 - Загрузить семью из файла\n " +
                            "3 - Вывести детей члена семьи\n " +
                            "4 - Найти члена семьи по имени \n " +
                            "5 - Выйти");
            key = scn.nextInt();
            switch (key) {
                case 0:
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
                    presenter.save("family.txt");
                    scn.close();
                    break;
                default:
                    break;
            }
    }
    }
    public void enterPersonData()
    {
        print("Введите имя:");
        name =scn.next();
        print("Введите имя отца:");
        nameFather = scn.next();
        print("Введите имя матери:");
        nameMather = scn.next();
        presenter.addMember(name,nameFather,nameMather);
    }

public void printChildren()
{
    print("Введите имя Родителя:");
    nameFather = scn.next();
    presenter.getChildren(nameFather);
}
public void findMember()
{
    print("Введите искомое имя");
    name =scn.next();
    presenter.findMember(name);
}
    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
}
