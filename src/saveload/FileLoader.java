package saveload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileLoader implements LoadFrom {
    public Object loadFrom(String path) throws IOException, ClassNotFoundException {
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
