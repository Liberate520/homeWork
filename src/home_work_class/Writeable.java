package home_work_class;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writeable {

    void write(FamilyTree tree) throws IOException;
    FamilyTree read() throws IOException, ClassNotFoundException;
}
