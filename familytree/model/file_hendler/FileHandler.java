package familytree.model.file_hendler;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import familytree.model.human.Human;

public class FileHandler implements Writeble {
    @Override
    public  boolean write(Serializable serializable, String filePath) {
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filePath))) {
            OOS.writeObject(serializable);
            System.out.println("Файл сохранён!");
            return true;
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл, ошибка: " + e.getMessage());
            return false;
        }
    }
    @Override
    public Object read(String fileName) {
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileName))) {
            return read.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить файл, ошибка: " + e.getMessage());
            return null;
        }
    }
    
}
