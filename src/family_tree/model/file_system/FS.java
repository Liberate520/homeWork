package family_tree.model.file_system;

import java.io.File;
import java.io.Serializable;

import family_tree.model.file_system.enums.StatusFileFS;

public class FS{
    Writable writable;

    public FS(Writable writable)
    {
        this.writable = writable;
    }

    public StatusFileFS Save(Serializable serializable, String file_path)
    {
        return writable.Save(serializable, file_path);
    }

    public Object Read(String file_path)
    {
        return writable.Read(file_path);
    }

    public boolean IsFileExist(String file_path)
    {
        File file = new File(file_path);
        if(file.exists())
        {
            return true;
        }
        return false;
    }

}
