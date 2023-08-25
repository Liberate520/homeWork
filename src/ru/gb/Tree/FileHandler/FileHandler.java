package ru.gb.Tree.FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.gb.Tree.Service.Service;

public class FileHandler implements Writable {

    public void saveFile(Service tree, String path){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(tree);
            System.out.println("Файл записан");
            oos.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public Service readFile(String path){
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            return (Service) ois.readObject();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
        return null;
    } 
}