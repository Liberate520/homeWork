package gb.task_4;

import java.io.Serializable;

public interface IInputOutputable {
    void saveAs(Serializable obj, String filePathName);

    Serializable readFrom(String filePathName);
}
