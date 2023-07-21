package model.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import model.interfaces.Loadable;
import model.interfaces.Reader;

public class Loader implements Reader {
    String path;

    public Loader(String path) {
        this.path = path;
    }

    @Override
    public Loadable loadObj() throws ClassNotFoundException, IOException {
        ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(path));
        Object restoredObj = objInStream.readObject();
        objInStream.close();
        if (restoredObj instanceof Loadable) {
            return (Loadable)restoredObj;
        }
        throw new ClassNotFoundException("file not Loadable");
    }
}