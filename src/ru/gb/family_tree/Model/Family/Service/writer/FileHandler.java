package ru.gb.family_tree.Model.Family.Service.writer;

import java.io.*;

public class FileHandler implements Saveble{

    public boolean save(Serializable serializable) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/Users/egor/Documents/Учеба/ООП/NewProgect/src/ru/gb/family_tree/writer/test.txt"))) {
            os.writeObject(serializable);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("/Users/egor/Documents/Учеба/ООП/NewProgect/src/ru/gb/family_tree/writer/test.txt"))) {
            return is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
