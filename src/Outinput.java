import java.io.FileNotFoundException;
import java.io.IOException;

public interface Outinput {
    void save(FamilyTree ft) throws FileNotFoundException, IOException;
    void load(FamilyTree ft) throws ClassNotFoundException, IOException;
}

