package model.saving;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveInFile implements SavableObject{
    @Override
    public void saveObjectAs(Object object, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }
}
