import FamilyTree.FamilyTree;

import java.io.*;
import java.time.LocalDate;

import FileOperations.InOutTxt;
import Human.Human;
import Presenter.Presenter;
import Service.Service;
import UI.Console;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      /* FamilyTree<Human> tree = new FamilyTree<Human>();
        Service service = new Service(tree);

        service.addHuman("мать матери ego", "Галина", "Бородихина", LocalDate.of(1932, 1,
                23));
        service.addHuman("отец матери ego", "Николай", "Мягков", LocalDate.of(1931, 12,
                23));
        service.addHuman("сын матери матери ego: ", "Юрий", "Мягков", LocalDate.of(1954, 5,
                8), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай",
                "Мягков"));
        service.addHuman("мать  ego", "Татьяна", "Мягкова", LocalDate.of(1958, 5,
                16), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай",
                "Мягков"));
        service.addHuman("дочь матери матери ego: ", "Марина", "Мягкова", LocalDate.of(1964,
                8, 5), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай",
                "Мягков"));
        service.addHuman("ego", "Денис", "Мягков", LocalDate.of(1984, 1, 22),
                tree.getHuman("Татьяна", "Мягкова"), null);
        service.addHuman("дочь сына матери матери ego", "Наталья", "Мягкова", LocalDate.of(1978,
                9, 23), null, tree.getHuman("Юрий", "Мягков"));
        service.addHuman("дочь сына матери матери ego", "Лариса", "Мягкова", LocalDate.of(1983,
                8, 7), null, tree.getHuman("Юрий", "Мягков"));
        service.addHuman("дочь дочери матери матери ego", "Юлия", "Констман", LocalDate.of(1988,
                4, 12), tree.getHuman("Марина", "Мягкова"), null);
        service.addHuman("сын ego", "Матвей", "Мягков", LocalDate.of(2021, 10, 5),
                null, tree.getHuman("Денис", "Мягков"));
        service.addHuman("дочь матери отца матери ego", "Любовь", "Мягкова", LocalDate.of(1947,
                7, 1));

        tree.getHuman("сын ego").setMother(new Human("мать сына ego", " Светлана", "Шемякина",
                LocalDate.of(1988, 4, 2)));*/



        //System.out.println(tree);
        //System.out.println(tree.getOldest());
        //System.out.println(tree.getYoungest());
        //System.out.println(tree.getHuman("Денис", "Мягков"));
        //System.out.println(tree.getHuman("сын ego"));
        //System.out.println(tree.getAllChildren("Галина", "Бородихина"));
        //System.out.println("=======");
        //System.out.println(service.getChildren("Галина", "Бородихина"));
        //System.out.println(tree.getHuman("Денис", "Мягков").getChildren());



       /* System.out.println(tree);
        System.out.println("===");
        InOutTxt copy = new InOutTxt();
        copy.saveData(tree, "copy15");
        FamilyTree <Human> treeRestored = new FamilyTree();
        treeRestored = (FamilyTree) copy.loadData("copy15");
        System.out.println(treeRestored);*//*

*//*        Iterator<Human.Human> iterator = tree.iterator();
        while (iterator.hasNext()) {
            Human.Human human = iterator.next();
            System.out.println(human);
        }*//*

       *//* System.out.println(tree);
        System.out.println("=====");
        service.sortByName();
        System.out.println(tree);
        System.out.println(tree.getHuman("Денис", "Мягков").getId());
        service.sortByBirthDate();
        System.out.println(tree);
        service.sortByID();
        for (Human human : tree) {
            System.out.printf("%d %s\n", human.getId(), human.getName());
        }*/


        InOutTxt copy = new InOutTxt();
        FamilyTree <Human> tree = (FamilyTree) copy.loadData("tree");
        //FamilyTree<Human> tree = new FamilyTree<Human>();
        Service service = new Service(tree);
        Console view = new Console(tree);
        Presenter presenter = new Presenter(service, view);
        view.start();
    }
}
