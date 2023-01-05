package homeWorkSem1;
import java.io.IOException;
import java.io.Serializable;

public interface Writeble {
    void save(Serializable serializable) throws IOException;
    FamilyTree read() throws IOException, ClassNotFoundException;

}
