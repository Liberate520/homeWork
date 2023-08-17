package FT_Project.model.service.FileActions;

import java.io.Serializable;

public interface Writable{
    Object load(String filePath);
    boolean save(Serializable serializable, String filePath);
}
