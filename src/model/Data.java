package model;

import model.Human.Human;
import model.tree.FamilyTree;

import java.io.*;

public class Data implements Writeable{
    @Override
    public void save(Object o) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.txt"));
            Object ob = objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(ob);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
