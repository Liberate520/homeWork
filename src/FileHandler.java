import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler {
    
    public void saveData(Serializable o) throws IOException, ClassNotFoundException {
        // FileOutputStream fos = new FileOutputStream("D:\\tree\\tree.save");
        FileOutputStream fos = new FileOutputStream("tree.save");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        System.out.println("Файл успешно записан");
        oos.close();
    }

    public Object loadData() throws IOException, ClassNotFoundException{
        System.out.println("Поцедура загрузки из файла запущена");
        // FileInputStream fis = new FileInputStream("D:\\tree\\tree.save");
        FileInputStream fis = new FileInputStream("tree.save");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        System.out.println("Поцедура загрузки завершена успешно");
        ois.close();
        return o;
    }
}
