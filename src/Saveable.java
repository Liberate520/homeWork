import java.io.Serializable;

public interface Saveable {
    void Save(String path);
    Serializable Load(String path);
}
