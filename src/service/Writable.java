package service;

import java.io.IOException;

public interface Writable {

    void write(Object obj, String fileName) throws IOException;
    Object read(String fileName) throws IOException, ClassNotFoundException;

}
