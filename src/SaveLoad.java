import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface SaveLoad {
    //первый аргумент относится к сохраняемым данным, второй - дополнительный
    public void SaveTo(Object obj, Object[] s) throws IOException;

    public Object LoadFrom(Object[] s) throws IOException, ClassNotFoundException;
}
