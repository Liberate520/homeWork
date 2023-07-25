package model.io;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    void setPathName(String pathName);
    void writeObj(Serializable obj) throws IOException;
}