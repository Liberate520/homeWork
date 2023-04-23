import java.io.Serializable;

public interface Saveable {
    void write(Serializable serializable, String path);
    FamilyTree read(String path);
}
