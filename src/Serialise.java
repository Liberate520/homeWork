package family_tree;

import java.io.IOException;

public interface Serialise {
    String readInFile() throws IOException;
    void writeToFile(String dataString) throws IOException;

}
