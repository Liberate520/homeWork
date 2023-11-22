package family_tree.family_tree.model;

import java.io.*;

public class FileHandler implements Writable{
    //метод сохранения через интерфейс Serializable, путь  filePath
    public boolean save(Serializable serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable); // для сохранения writeObject
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
// метод загрузки
    public Object read(String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject(); //для загрузки readObject (метод возвращает Object)
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
