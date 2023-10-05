package fileWorker;

import java.io.Serializable;

public interface Writable {
    void saveToFile( Serializable obj, String filePath );
    Object readFromFile( String filePath );
}
