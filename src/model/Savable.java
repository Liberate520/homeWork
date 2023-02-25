package model;

import java.io.Serializable;

public interface Savable {
    public void save(Serializable serializable);

    public Object read();
}
