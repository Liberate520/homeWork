package code;

import java.io.Serializable;

public interface IInputOutputable {
    void saveAs(Serializable obj, String filePathName);

    Serializable readFrom(String filePathName);
}
