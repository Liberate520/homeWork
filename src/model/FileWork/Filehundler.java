package FileWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Filehundler implements Writeble{
    /**
     * Метод сохранение дерева в файл
     */
    public boolean SaveInFile(Serializable serializable, String fileName){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))){
        objectOutputStream.writeObject(serializable);
        return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Метод загрузки дерева из файла
     */
    public Object LoadInFile(String fileName){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
