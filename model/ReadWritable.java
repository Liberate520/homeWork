package model;

import java.io.IOException;
import java.io.Serializable;

public interface ReadWritable {
    void write(Serializable obj);
    Object read();
}
