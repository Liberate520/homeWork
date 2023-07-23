package saveload;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class FileSaver implements SaveTo {
    public void saveTo(Object obj, String path) throws IOException {
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }
}
