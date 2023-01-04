import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable);
    FamilyTree load();
}