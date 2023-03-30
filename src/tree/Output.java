package tree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Output {
    public void printOut(Object object) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src\\tree\\Input.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }
}
