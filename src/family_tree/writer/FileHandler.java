package family_tree.writer;

import family_tree.model.family_tree.Family_tree;
import family_tree.model.family_tree.human.Human;

import java.io.*;

public class FileHandler implements Writable{


    public void SaveFamily_tree(Object familyTree)  throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public Family_tree LoadFamily_tree() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        Family_tree ret = (Family_tree) objectInputStream.readObject();
        objectInputStream.close();
        return ret;

    }

    public void SaveHuman(Human human)  throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Human.out"));
        objectOutputStream.writeObject(human);
        objectOutputStream.close();
    }

    public Human LoadHuman() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Human.out"));
        Human ret = (Human) objectInputStream.readObject();
        objectInputStream.close();
        return ret;

    }

}
