package ru.gb.family_tree.family_tree.model.writer;

import java.io.*;

public class FileHandler implements Writable,SaveAndLoad{
    String path="src/ru/gb/family_tree/family_tree/model/writer/file";
    public boolean save(Serializable serializable,String path) {
        try (ObjectOutputStream familytreeOut= new ObjectOutputStream(new FileOutputStream(path))) {
            familytreeOut.writeObject(serializable);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object load(String path) {
        try (ObjectInputStream familytreeInput = new ObjectInputStream(new FileInputStream(path))) {
            return familytreeInput.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPath(){
        return path;
    }

}