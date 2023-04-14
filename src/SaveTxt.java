import Tree.Tree;

import java.io.*;

public class SaveTxt implements Saveable {
    @Override
    public void save(Serializable obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Java_OOP_homeWork\\src\\treeSave.txt"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }


    @Override
    public Serializable load() throws IOException, ClassNotFoundException {
           ObjectInputStream objectInputStream = new ObjectInputStream(
                   new FileInputStream("Java_OOP_homeWork\\src\\treeSave.txt"));
           Tree treeRestored = (Tree) objectInputStream.readObject();
           objectInputStream.close();
           return treeRestored;
    }
}
