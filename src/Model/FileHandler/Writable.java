package Model.FileHandler;


import java.io.Serializable;

public interface Writable {
    void writeToFile(Serializable serializable, String path);

    Object readFromFile(String path);
}
