package handler;

public interface Writable {

    void save(Object object, String fileName);

    Object read(String fileName);
}