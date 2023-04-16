import model.FileHandler;
import model.Service;
import model.Service1;
import model.TreeFamily.TreeFamily;
import model.human.Human;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Human pa = new Human("Bazarov", "Alex", Human.Gender.Mail, LocalDate.parse("1949-01-07"));
        Human ma = new Human("Budina", "Anna", Human.Gender.Fimale,LocalDate.parse("1948-09-07"));
        Human sister1 = new Human(pa, ma, "Bazarova","Helga", Human.Gender.Fimale, LocalDate.parse("1978-03-10"));
        Human sister2 = new Human(pa, ma,"Bazarova","Tasy", Human.Gender.Fimale,LocalDate.parse("1980-06-07"));
//        System.out.println (pa.getMother());
//        System.out.println (sister1.getMother());
//        System.out.println (sister1.getFather());
        TreeFamily<Human> tree = new TreeFamily<>();

        tree.add(pa);
        tree.add(ma);
        tree.add(sister1);
        tree.add(sister2);
        tree.add(sister2);
        pa.addChildrenList(sister1);
        pa.addChildrenList(sister2);

//        System.out.println("Дети "+pa.getName()+" "+ pa.getFamily() +":\n  "+pa.getСhildrenList());
//        System.out.println("Дети "+ma.getName()+" "+ ma.getFamily() +":\n  "+ma.getСhildrenList());
//
//        System.out.println();
//        System.out.println(tree.getInfo());
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
        TreeFamily treeOut = (TreeFamily) fileHandler.read();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.out"));
//        objectOutputStream.writeObject(sister1);
//        objectOutputStream.writeObject(tree);
//        objectOutputStream.close();

//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.out"));
//        Human sisterout1 = (model.human.Human) objectInputStream.readObject();
//        model.TreeFamily treeOut1 = (model.TreeFamily) objectInputStream.readObject();
//        objectInputStream.close();

//        System.out.println();
//        System.out.println(treeOut);
//
//        System.out.println();
//
//        Service tr = new Service(tree);
//        tr.sortByFamily();
//        for (Human human: tree){
//            System.out.println(human);
//        }
//        System.out.println();
//
//
//        tr.sortByName();
//        for (Human human: tree) {
//            System.out.println(human);
//        }

        View view = new Console();
        Service service = new Service(tree);
        new Presenter(view, service);
        view.start();


    }
}
