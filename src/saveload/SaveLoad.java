package saveload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface SaveLoad {
    public void saveTo(Object obj, String path) throws IOException;

    public Object loadFrom(String path) throws IOException, ClassNotFoundException;
}
