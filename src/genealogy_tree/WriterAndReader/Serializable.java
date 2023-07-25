package genealogy_tree.WriterAndReader;

import java.io.IOException;

public interface Serializable {
    void ObjectOutputStream()throws IOException, ClassNotFoundException ;
    void ObjectInputStream ()throws IOException, ClassNotFoundException, IOException;
}
