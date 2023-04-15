package service;

import java.io.Serializable;

public interface Writable {
    static final long serialVersionUID = 6529685098267757699L;
    boolean save(Serializable serializable, String filename);

    Object load(String filename);
}
