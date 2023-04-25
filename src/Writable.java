import java.io.ObjectInputStream;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    FamilyTree read(String filePath);
}
