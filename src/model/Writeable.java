package model;

public interface Writeable {
    void save(Object o);
    Object read();
}
