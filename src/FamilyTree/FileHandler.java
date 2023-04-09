package FamilyTree;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements SaveLoad{

    @Override
    public void save(Serializable o, String path)  throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            System.out.println("Файл успешно записан");
            oos.close();
    }

    @Override
    public Object load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        System.out.println("Поцедура загрузки завершена успешно");
        ois.close();
        return o;
    }

}
