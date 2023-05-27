package model.handler;

import java.io.Serializable;

public interface Saveble {
    void save(String path, Serializable serializable);
    }
