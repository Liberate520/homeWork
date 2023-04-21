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
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(super.getFilePath() + super.getFileNameOut()));
            ois.close();
            return (Saveable) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
        return (Saveable) this.object;
    }

}
