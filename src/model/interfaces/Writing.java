package model.interfaces;

import java.io.IOException;

public interface Writing {
    void writeObj(Saveable obj, String pathName) throws IOException;
}