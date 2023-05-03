package model.handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class HandlerReader extends Handler implements Reader {
    private Saveable object;

    public HandlerReader() {
        super();
    }

    @Override
    public Saveable readFromFile() {
        Saveable obj = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(super.getFilePathOut() + super.getFileNameOut()));
            obj = (Saveable) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

}
