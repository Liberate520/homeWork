package model;

import java.io.*;

public interface Writable {
    public void save(Serializable obj, String filePath) throws IOException;

    public Serializable load(String filePath) throws IOException, ClassNotFoundException;
}
