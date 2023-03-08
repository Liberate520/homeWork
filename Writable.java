package main;

import java.io.Serializable;

public interface Writable {

    void write(Serializable obj);

    Object read();

}