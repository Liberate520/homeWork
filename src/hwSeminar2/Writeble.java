package homeWorkSem1;
import java.io.IOException;
import java.io.Serializable;

public interface Writeble {
    void save(Serializable serializable);
    FamilyTree read() throws IOException;
    String readGetString()throws IOException;
}
