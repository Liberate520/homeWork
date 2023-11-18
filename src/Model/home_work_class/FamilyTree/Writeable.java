package Model.home_work_class.FamilyTree;

import java.io.IOException;

public interface Writeable {

    void write(FamilyTree tree) throws IOException;
    FamilyTree read() throws IOException, ClassNotFoundException;
}
