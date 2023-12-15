package model.writer;

public interface Writable {
    boolean save(Object object);
    Object load();
}
