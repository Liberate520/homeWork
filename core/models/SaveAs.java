package homeWork3.core.models;

import java.io.Serializable;

public interface SaveAs {
    void save(String path, Serializable obj);
}