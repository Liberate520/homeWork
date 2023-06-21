package tree;

import tree.model.Service;
import tree.model.familyTree.FamilyTree;
import tree.model.handler.FileHandler;
import tree.model.human.Human;
import tree.model.humanService.AddHumanService;
import tree.model.humanService.DirectDescendant;
import tree.model.humanService.FindHumanService;
import tree.model.humanService.RemoveHumanService;
import tree.presenter.Presenter;
import tree.view.UserUI;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static tree.model.human.Gender.*;

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

    /*    Service humanService = new Service();
        humanService.setTree(Ivanovi);
        humanService.setAddHumanService();
        humanService.setSaveReadable();
        humanService.setRemoveHumanService();
        humanService.setDirectDescendant();
        humanService.setFindHumanService();

        UserUI user1 = new UserUI(new Presenter(humanService));
        user1.start();

    */    Service service = new Service(new FamilyTree<>("Petrovi"),
                                      new FileHandler(),
                                      new AddHumanService<>(),
                                      new FindHumanService<>(),
                                      new RemoveHumanService<>(),
                                      new DirectDescendant<>());

        UserUI user2 = new UserUI(new Presenter(service));
        user2.start();
    }
}
