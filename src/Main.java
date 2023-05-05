//import model.FileHandler;
import model.TreeFamily.ServiceData;
import model.TreeFamily.ServiceTree;
import model.TreeFamily.TreeFamily;
import model.human.Human;
import presenter.Presenter;
import ui.Console;
import ui.Desktop;
import ui.View;

import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Human pa = new Human("Bazarov", "Alex", Human.Gender.Mail, LocalDate.parse("1949-01-07"));
        Human ma = new Human("Budina", "Anna", Human.Gender.Fimale,LocalDate.parse("1948-09-07"));
        Human sister1 = new Human(pa, ma, "Bazarova","Helga", Human.Gender.Fimale, LocalDate.parse("1978-03-10"));
//        Human sister2 = new Human(pa, ma,"Bazarova","Tasy", Human.Gender.Fimale,LocalDate.parse("1980-06-07"));
//        System.out.println (pa.getMother());
//        System.out.println (sister1.getMother());
//        System.out.println (sister1.getFather());
        TreeFamily<Human> tree = new TreeFamily<>();

//        tree.add(pa);
//        tree.add(ma);
//        tree.add(sister1);
//        tree.add(sister2);
//        pa.addChildrenList(sister1);
//        pa.addChildrenList(sister2);
//        ma.addChildrenList(sister1);
//        ma.addChildrenList(sister2);
//
//        System.out.println("Дети "+pa.getName()+" "+ pa.getFamily() +":\n  "+pa.getСhildrenList());
//        System.out.println("Дети "+ma.getName()+" "+ ma.getFamily() +":\n  "+ma.getСhildrenList());
//
//        System.out.println();
//        System.out.println(tree.getInfo());

//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.out"));
//        objectOutputStream.writeObject(sister1);
//        objectOutputStream.writeObject(tree);
//        objectOutputStream.close();
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.out"));
//        Human sis = (model.human.Human) objectInputStream.readObject();
//        TreeFamily treeOut1 = (TreeFamily) objectInputStream.readObject();
//        objectInputStream.close();



  //      System.out.println(sis);
 //       System.out.println(treeOut1);
//
//        System.out.println();


        ServiceTree tr = new ServiceTree(tree);
        ServiceData data = new ServiceData();
        data.save(sister1);
        Human sis = (Human) data.read();
        System.out.println(sis.getInfo());
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

        View desktopview = new Desktop();
        View consoleView1 = new Console();
        //ServiceTree service = new ServiceTree(tree);
        new Presenter(desktopview, tr);
        new Presenter(consoleView1,tr);
        consoleView1.start();
        desktopview.start();


    }


}
