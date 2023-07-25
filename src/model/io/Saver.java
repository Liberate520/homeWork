package model.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Saver implements Writer {
    String pathName = null;

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public void writeObj(Serializable obj) throws IOException {
        ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(pathName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }
}