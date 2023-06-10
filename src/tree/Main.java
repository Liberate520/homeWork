package tree;

import tree.familyTree.FamilyTree;
import tree.familyTree.presenter.Presenter;
import tree.familyTree.view.UserUI;
import tree.handler.FileHandler;
import tree.handler.SaveReadable;
import tree.human.Human;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static tree.human.Gender.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human Sasha = new Human("Sasha", man);
        Human Masha = new Human("Masha", woman);
        Human Olga = new Human("Olga", woman, Sasha, Masha);
        Human Misha = new Human("Misha", man, Sasha, Masha);

        Human Oleg = new Human("Oleg", man);
        Human Natasha = new Human("Natasha", woman);
        Human Nikita = new Human("Nikita", man, Oleg, Natasha);
        Human Vika = new Human("Vika", woman, Oleg, Natasha);

        Human Roma = new Human("Roma", man, Nikita, Olga);
        Human Anna = new Human("Anna", woman, Misha, Vika);

        Human Zhora = new Human("Zhora", man, Roma, Anna);

        Human Alena = new Human("Alena", woman);


        FamilyTree<Human> Ivanovi = new FamilyTree<>("Ivanovi");
        List<Human> people = new ArrayList<>(Arrays.asList(Sasha, Masha, Olga, Misha, Oleg, Natasha, Nikita, Vika, Roma, Anna, Zhora, Alena));

        Ivanovi.addHumanList(people);
        System.out.println(Ivanovi);

        System.out.println("-------------Найти человека-------------");
        System.out.println(Ivanovi.findHuman("Masha"));
        System.out.println("Найти Alla ---> " + Ivanovi.findHuman("Alla"));
        System.out.println(Ivanovi.findHuman("Masha").getParent() + "\n" + Ivanovi.findHuman("Masha").getChild());
        System.out.println("------------Добавление Parents для Alena------------");
        System.out.println(Alena.getParent());
        Alena.addParent(Masha);
        Sasha.addChild(Alena);
        System.out.println(Alena.getParent());
        System.out.println(Masha.getChild());

        System.out.println("-----------Тест запись/чтение----------");

        SaveReadable fileHandler = new FileHandler();
        fileHandler.saveObject(Ivanovi);

        FamilyTree<Human> IvanoviTestLoad = (FamilyTree) fileHandler.loadObject();

        System.out.println(IvanoviTestLoad);
        System.out.println(IvanoviTestLoad.findHuman("Sasha").getChild());

        System.out.println();

        Service service = new Service(IvanoviTestLoad);

        service.addHuman("Albert", man);
        System.out.print("No sort ----> ");
        System.out.println(IvanoviTestLoad);
        service.sortByName();
        System.out.print("Sort by Name ----> ");
        System.out.println(IvanoviTestLoad);

        service.sortByChild();
        System.out.print("Sort by count of kids ----> ");
        System.out.println(IvanoviTestLoad);
        System.out.println("S__________________S");
        System.out.println(service.findHuman("Sasha"));
        System.out.println("S---------------------S");
        for (Human human : IvanoviTestLoad) {
            System.out.printf("%s (count kids: %d)\n",human.getName(), human.getChildrenList().size());
        }
        Presenter presenter = new Presenter(service);
        UserUI user1 = new UserUI();
        user1.setPresenter(presenter);
        user1.start();
    }
}
