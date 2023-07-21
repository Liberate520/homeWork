package model.interfaces;

import java.io.IOException;

public interface Writer {
    void writeObj(Saveable obj) throws IOException;
}