package FileOperations;

import java.io.Serializable;

public interface InOut {
    void saveData(Serializable obj, String name) throws Exception;
    Serializable loadData(Serializable obj, String name) throws Exception;
}
