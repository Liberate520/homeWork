package homeWork.ProjectFamilyTree;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void Save(Serializable object) throws IOException;

    Object Load() throws IOException, ClassNotFoundException;
}
