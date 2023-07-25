package model.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Loader implements Reader {
    String pathName = null;

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public Object loadObj() throws ClassNotFoundException, IOException {
        ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(pathName));
        Object restoredObj = objInStream.readObject();
        objInStream.close();
        return restoredObj;
    }
}