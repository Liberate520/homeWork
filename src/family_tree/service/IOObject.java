package family_tree.service;

import java.io.*;

public class IOObject implements Writable {
    //Сериализация в файл с помощью класса ObjectOutputStream
    @Override
    public boolean save (Serializable serializable, String filePath){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Десериализация  из файла с помощью класса ObjectInputStream
    @Override
    public Object read (String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
