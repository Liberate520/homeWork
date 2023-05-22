package model.saving;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFromFile implements LoadableObject{
    @Override
    public Object loadObjectFrom(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Object is restored.");
        return object;
    }
}
