package OOPjavaTree.src.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loaded implements Operation {
    @Override
    public Object getUsedFile(Object tree) throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("OOPjavaTree/src/Data/person.out"));
        tree = objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}
