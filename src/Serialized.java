import java.io.Serializable;

public interface Serialized {
    void saveFile(String path, Serializable obj);
    Serializable readFile(String path);
}