package Java_OOP.homeWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements Writable {

    @Override
    public void write(String path, Object object) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree load(String path)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        FamilyTree ft = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return ft;
    }

}
