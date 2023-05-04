import model.Service;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        GenealogyTree tree = new GenealogyTree();
//        String filePath = "src/tree.txt";
//        Writable writable = new FileHandler();

//        tree.addHuman(new Human("Иван", "Петров", 45));
//        tree.addHuman(new Human("Мария", "Петрова", 35));
//        tree.addHuman(new Human("Татьяна", "Петрова",
//                17,tree.getByName("Иван", "Петров"), tree.getByName("Мария", "Петрова")));
//        tree.addHuman(new Human("Екатерина", "Петрова",
//                15, tree.getByName("Иван", "Петров"), tree.getByName("Мария", "Петрова")));
//        tree.addHuman(new Human("Егор", "Петров",
//                13, tree.getByName("Иван", "Петров"), tree.getByName("Мария", "Петрова")));

//        writable.save(tree,filePath);
//        GenealogyTree tree = (GenealogyTree) writable.read(filePath);
//        tree.printTree("", tree.getByName("Иван", "Петров"));
        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);


        service.addHuman("Иван", "Петров", 45);
        service.addHuman("Мария", "Петрова", 35);
        service.addHuman("Татьяна", "Петрова",17);
        service.addHuman("Екатерина", "Петрова", 15);
        service.addHuman("Егор", "Петров", 13);
        view.start();



//        System.out.println(service.getInfo());
//        service.sortByName();
//        System.out.println(service.getInfo());
//        service.sortByAge();
//        System.out.println(service.getInfo());


    }
}