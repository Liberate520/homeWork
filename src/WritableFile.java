import java.io.Serializable;

public interface WritableFile {
    void save(Serializable serializable);
    Object readFile();
}
