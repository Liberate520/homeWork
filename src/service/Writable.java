package service;

import java.io.Serializable;

public interface Writable {

    boolean save(Serializable serializable, String filename);

    Object load(String filename);
}
