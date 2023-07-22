package homeWork.src.WriterReader;

import java.io.*;

public class FileHandler implements Wrtr{


    @Override
    public String save(Serializable sr, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(sr);
            return "Готово.";
        } catch (Exception e){
            e.printStackTrace();
            return "Ошибка!";
        }
    }

    @Override
    public Object read(String path) {
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path))){
            return oos.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return "Ошибка";
        }
    }
}
