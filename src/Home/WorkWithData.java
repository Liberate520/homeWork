package Home;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface WorkWithData extends Serializable {
    void FamilyTreeSave(Human human) throws IOException;
    void FamilyTreeload(Human human) throws IOException, ClassNotFoundException;
//    void FamilyTreeArrayLoad(List<Human>humans) throws IOException, ClassNotFoundException;
//    void FamilyTreeArraySave(List<Human>humans) throws IOException;
}
