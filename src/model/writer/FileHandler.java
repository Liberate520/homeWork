package homeWork.src.model.writer;

import java.io.*;
import java.util.List;

public class FileHandler implements Writable{
    // Добавить переменну path, убрать path из аргументов методов
    private String filePath = "src/homeWork/src/model/writer/tree.txt";
    public boolean save(List<? extends Serializable> serializableList) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializableList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

        public List<? extends Serializable> read(){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
                return (List<? extends Serializable>) objectInputStream.readObject();
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
