package saveload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface SaveLoad {
    //первый аргумент относится к сохраняемым данным, второй - дополнительный
    public void saveTo(Object obj, String path) throws IOException;

    public Object loadFrom(String path) throws IOException, ClassNotFoundException;
}
