package menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserMenu userMenu = new UserMenu();
        userMenu.load();
        View view = new View();
        view.UserInterface(userMenu);
    }
}
















////        ______________________________________________________________________
////        люди
//
//        tree.Human Sergey = new tree.Human("Sergey", tree.Gender.Male, 65);
//        tree.Human Marina = new tree.Human("Marina", tree.Gender.Female, 63);
//
//        tree.Human Ivan = new tree.Human("Ivan", tree.Gender.Male, 45, Sergey);
//        tree.Human Olga = new tree.Human("Olga", tree.Gender.Female, 41, Marina);
//        tree.Human Andrey = new tree.Human("Andrey", tree.Gender.Male, 43, Sergey);
//
//        tree.Human Semen = new tree.Human("Semen", tree.Gender.Male, 20, Ivan, Olga);
//        tree.Human Pavel = new tree.Human("Pavel", tree.Gender.Male, 1, Andrey, Olga);
//
//        tree.Human Evgeniy = new tree.Human("Evgeniy", tree.Gender.Male, 11, Sergey, Marina);
//
//        List<tree.Human> humans = Arrays.asList(Sergey, Marina, Ivan, Olga, Andrey, Semen, Pavel);
//
//        tree.FamilyTree<tree.Human> humanTree = new tree.FamilyTree("humans", humans);
//        humanTree.addElement(Evgeniy);
//
//        System.out.print("Результаты поиска человека по имени: ");
//        humanTree.findByName("Ivan");
//        System.out.println("---");
//
//        System.out.print("Результаты поиска братьев и сестер человека: ");
//        System.out.println(Andrey.getSistersBrothers());
//        System.out.println("---");
//
//        System.out.print("Результаты поиска всех детей человека: ");
//        System.out.println(Andrey.getChildren());
//        System.out.println("---");
//
//        System.out.print("Результаты вывода всего дерева: ");
//        System.out.println();
//        System.out.println(humanTree);
//        System.out.println("---");
//
//        System.out.print("Результаты работы с чтением и записью: \n");
//        tree.FileWorker worker = new tree.FileWorker();
//        humanTree.setWritable(worker);
//
//        humanTree.save();
//        System.out.printf("\n%s\n",humanTree.read());
//        humanTree.save();
//        System.out.println("---");
//
//        System.out.print("Результаты вывода элементов дерева через итератор: \n");
//        for (tree.Human hum : humanTree) {
//            System.out.println(hum);
//        }
//        System.out.println("---");
//
//        tree.Service service = new tree.Service();
//
//        System.out.print("Результаты сортировки по имени: \n");
//        service.sortByName(humanTree);
//        System.out.println(humanTree);
//        System.out.println("---");
//
//        System.out.print("Результаты сортировки по возрасту: \n");
//        service.sortByAge(humanTree);
//        System.out.println(humanTree);
//        System.out.println("---");
//
////        ______________________________________________________________________
////        коты
//
//        tree.Cat Vasiliy = new tree.Cat("Vasiliy", tree.Gender.Male, 65);
//        tree.Cat Murka = new tree.Cat("Murka", tree.Gender.Female, 63);
//
//        tree.Cat Rizhik = new tree.Cat("Rizhik", tree.Gender.Male, 45, Vasiliy);
//        tree.Cat Elli = new tree.Cat("Elli", tree.Gender.Female, 41, Murka);
//        tree.Cat Dimok = new tree.Cat("Dimok", tree.Gender.Male, 43, Vasiliy);
//
//        tree.Cat Murzik = new tree.Cat("Murzik", tree.Gender.Male, 20, Rizhik, Elli);
//        tree.Cat Mur = new tree.Cat("Mur", tree.Gender.Male, 1, Dimok, Elli);
//
//        tree.Cat Murz = new tree.Cat("Murz", tree.Gender.Male, 11, Vasiliy, Murka);
//
//        List<tree.Cat> cats = Arrays.asList(Vasiliy, Murka, Rizhik, Elli, Dimok, Murzik, Mur);
//
//        tree.FamilyTree<tree.Cat> catsTree = new tree.FamilyTree("cats", cats);
//
//        catsTree.addElement(Murz);
//
//        System.out.print("Результаты поиска кота по имени: ");
//        catsTree.findByName("Murka");
//        System.out.println("---");
//
//        System.out.print("Результаты поиска братьев и сестер кота: ");
//        System.out.println(Dimok.getSistersBrothers());
//        System.out.println("---");
//
//        System.out.print("Результаты поиска всех детей кота: ");
//        System.out.println(Vasiliy.getChildren());
//        System.out.println("---");
//
//        System.out.print("Результаты вывода всего дерева: ");
//        System.out.println();
//        System.out.println(catsTree);
//        System.out.println("---");
//
//        System.out.print("Результаты работы с чтением и записью: \n");
//        catsTree.setWritable(worker);
//
//        catsTree.save();
//        System.out.printf("\n%s\n",catsTree.read());
//        catsTree.save();
//        System.out.println("---");
//
//        System.out.print("Результаты вывода элементов дерева через итератор: \n");
//        for (tree.Cat cat : catsTree) {
//            System.out.println(cat);
//        }
//        System.out.println("---");
//
//        System.out.print("Результаты сортировки по имени: \n");
//        service.sortByName(catsTree);
//        System.out.println(catsTree);
//        System.out.println("---");
//
//        System.out.print("Результаты сортировки по возрасту: \n");
//        service.sortByAge(catsTree);
//        System.out.println(catsTree);
//        System.out.println("---");
