package interfaces;

import java.io.IOException;

public interface Reading {
    public Loadable loadObj(String pathFile) throws ClassNotFoundException, IOException;
}