package model;

import model.human.Human;

import java.io.IOException;

public interface Service1 {
    void addHuman(Human human);
    void sortByName();
    void sortByFamily();
    public void save(Object object) throws IOException;
    public Object read() throws ClassNotFoundException, IOException;
//    void save(Writable writable) throws IOException;
}
