package view;

import service.FamilyTree;
import service.human.Human;
import presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    Presenter presenter;
    Scanner scn = new Scanner(System.in);
    int key;
    String nameFather;
    String nameMather;
    String nameTemp;
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (key != 5) {
            System.out.println(" Введите: " +
                            "0 - Вывести список членов семьи\n " +
                            "1 - Добавить члена семьи\n " +
                            "2 - Загрузить семью из файла\n " +
                            "3 - Вывести детей члена семьи\n " +
                            "4 - Найти члена семьи по имени \n " +
                            "5 - Выйти");
            key = scn.nextInt();
            switch (key) {
                case 0:
                    System.out.println(familyTolstoy.getInfo());
                    break;
                case 1:
                    enterPersonData();
                    break;

                case 2:

                    familyTolstoy= (FamilyTree) writable.load("family.txt");
                    System.out.println(familyTolstoy);
                    break;

                case 3:
                    System.out.println("Введите имя Отца:");
                    nameFather = scn.next();
                    boolean found = false;
                    for (Human human : familyTolstoy) {
                        if (human.getName().equals(nameFather)) {
                            System.out.println("Дети отца " + nameFather + " :" + human.getChildrenInfo());
                            found = true;
                            break;
                        }
                        if (!(found)) {
                            System.out.println("Отец не найден");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите искомое имя");
                    familyTolstoy.find(scn.next());
                    break;
                case 5:
                    writable.save(familyTolstoy,"family.txt");
                    scn.close();
                    break;
                default:
                    break;
            }
    }

    }
    public void enterPersonData()
    {
        System.out.println("Введите имя:");
        nameTemp=scn.next();
        System.out.println("Введите имя отца:");
        nameFather = scn.next();
        System.out.println("Введите имя матери:");
        nameMather = scn.next();
        familyTolstoy.addMember(new Human(nameTemp,familyTolstoy.getByName(nameFather),familyTolstoy.getByName(nameMather)));
        System.out.println(familyTolstoy);
    }
    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
}
