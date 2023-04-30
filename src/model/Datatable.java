package model;

import java.io.IOException;

public interface Datatable {
    public void save(Object object) throws IOException;
    public Object read() throws ClassNotFoundException, IOException;
//    void save(Writable writable) throws IOException;
}
