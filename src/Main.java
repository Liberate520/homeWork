import Model.FamilyTree;
import Model.service.Filehandlers.FileHandler;
import Model.units.Dog;
import Model.units.Gender;
import Model.units.Human;
import Model.units.Unit;
import Presenter.Presenter;
import UI.Console;

import java.io.IOException;

public class Main {
    public static void main(
            String[] args) throws IOException, ClassNotFoundException {
        Human kolya = new Human("Kolya", "Black", Gender.Male, 31, 3, 1998);
        Human marina = new Human("Marina", "Black", Gender.Female, 1, 6, 1977);
        Human uriy = new Human("Uriy", "Black", marina, kolya, Gender.Male, 5,
                               12, 1969);
        Human john = new Human("John", "Black", Gender.Male, 8, 6, 1998);

        marina.addChild(john);
        john.addParent(kolya);
        FamilyTree<Human> tree_1 = new FamilyTree<>();
        tree_1.add(kolya);
        tree_1.add(john);
        tree_1.add(uriy);
        System.out.println(tree_1.getInfo());
        FileHandler<Human> fh = new FileHandler<>();

        for (Human human : tree_1) {
            System.out.println(human.getName());
        }

        System.out.println();

        tree_1.sortByName();
        for (Human human : tree_1) {
            System.out.println(human.getName());
        }

        System.out.println();

        System.out.println(kolya.getName() + " " + kolya.getAge() + " лет");
        System.out.println(uriy.getName() + " " + uriy.getAge() + " лет");
        System.out.println(john.getName() + " " + john.getAge() + " лет");

        System.out.println();

        tree_1.sortByAge();
        for (Human human : tree_1) {
            System.out.println(human.getName());
        }

        Dog dog1 = new Dog("kuk", Gender.Male, 19, 5, 1999);
        Dog dog2 = new Dog("jack", Gender.Male, 19, 5, 1999);
        Dog dog3 = new Dog("lisichka", Gender.Female, 19, 5, 1999);
        Dog dog4 = new Dog("zchuchka", Gender.Female, 19, 5, 1999);
        FamilyTree<Dog> tree_2 = new FamilyTree<>();
        tree_2.add(dog1);
        tree_2.add(dog2);
        tree_2.add(dog3);
        tree_2.add(dog4);
        for (Dog dog : tree_2) {
            System.out.println(dog.getName());
        }


        Console console = new Console();
        new Presenter<>(console, tree_1, new FileHandler<>());
        console.run();
        FamilyTree<Human> treeRestore = fh.read("OAAO.txt");
        System.out.println("Восстановлено");
        System.out.println(treeRestore.getInfo());

    }
}
