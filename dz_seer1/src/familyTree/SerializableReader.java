package familyTree;

import java.io.IOException;

public interface SerializableReader {
    <T> T readObject(String filename) throws IOException, ClassNotFoundException;
}

