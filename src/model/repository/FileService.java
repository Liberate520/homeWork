package model.repository;

import java.io.Serializable;

public interface FileService {
    Serializable read();
    void save(Serializable object);
}
