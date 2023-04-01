package file;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tree.Tree;

public class Slfamailytree implements OutInput {

    @Override
    public void save(Tree ft) throws FileNotFoundException, IOException {
        ObjectOutputStream savetree = new ObjectOutputStream(new FileOutputStream("data.dat"));
        savetree.writeObject(ft);
        savetree.close();
    }

    @Override
    public Object load() throws ClassNotFoundException, IOException {
        ObjectInputStream ltree = new ObjectInputStream(new FileInputStream("data.dat"));
        Object ft = new Object();
        ft = ltree.readObject();
        ltree.close();
        return ft;
    }
}
