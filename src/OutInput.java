import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutInput {
    void save(FamilyTree ft) throws FileNotFoundException, IOException;
    Object load() throws ClassNotFoundException, IOException;
}

