package model.interfaces;

import java.io.IOException;

public interface Reader {
    public Loadable loadObj() throws ClassNotFoundException, IOException;
}