package model;

import java.io.IOException;

public interface Serviceble {
    void addHuman(String family, String name);
   // public getByHuman ();
    void sortByName();
    void sortByFamily();

    public void save(Object object) throws IOException;
    public Object read() throws ClassNotFoundException, IOException;
//    void save(Writable writable) throws IOException;
}
