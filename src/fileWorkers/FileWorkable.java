package fileWorkers;

import java.io.Serializable;

public interface FileWorkable {
    boolean saveFile (Serializable serializable,String filePath);
    Object readFile (String filePath);

}
