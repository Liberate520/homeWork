import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Human pa = new Human("Bazarov", "Alex", Gender.Mail,"08.07.1949");
        Human ma = new Human("Budina", "Anna", Gender.Fimale,"15.09.1948");
        Human sister1 = new Human("Bazarova","Helga", Gender.Fimale,"10.03.1978");
        Human sister2 = new Human("Bazarova","Tasy", Gender.Fimale,"28.06.1980");

        sister1.mother = ma;
        sister1.father = pa;
//        System.out.println (sister1.getMother());
//        System.out.println (sister1.getFather());
        TreeFamily tree = new TreeFamily();
        tree.addHuman(pa);
        tree.addHuman(ma);
        tree.addHuman(sister1);
        tree.addHuman(sister2);
        pa.addChildrenList(sister1);
        pa.addChildrenList(sister2);

//        System.out.println("Дети "+pa.getName()+" "+ pa.getFamily() +":\n  "+pa.getСhildrenList());
//        System.out.println("Дети "+ma.getName()+" "+ ma.getFamily() +":\n  "+ma.getСhildrenList());

        System.out.println();
      //  System.out.println(tree);
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
        TreeFamily treeOut = (TreeFamily) fileHandler.read();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.out"));
//        objectOutputStream.writeObject(sister1);
//        objectOutputStream.writeObject(tree);
//        objectOutputStream.close();

//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.out"));
//        Human sisterout1 = (Human) objectInputStream.readObject();
//        TreeFamily treeOut = (TreeFamily) objectInputStream.readObject();
//        objectInputStream.close();

        System.out.println();
        System.out.println(treeOut);

    

    }
}
