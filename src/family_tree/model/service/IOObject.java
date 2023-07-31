package family_tree.model.service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOObject implements Writable {
    //Сериализация в файл с помощью класса ObjectOutputStream
    @Override
    public boolean save (Serializable serializable){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
        String fileName = format.format(date);
        String filePath = "src/family_tree/model/in_out_files/"+fileName+".bin";
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
    public Object read (String fileName) {
        String filePath = "src/family_tree/model/in_out_files/"+fileName;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
