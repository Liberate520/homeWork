package workingFile;

import human.Human;
import tree.Node;

public interface SaveToFile {
    boolean save(Node tree);
    Node read();
    void setFilePath(String filePath);


}


