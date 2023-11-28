package writer;

public interface Writable {
    void writeObject(Object o, String fileName);
    Object readObject(String fileName);
}
