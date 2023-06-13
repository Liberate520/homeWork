package models.repository;

import java.io.Serializable;

public interface Keeper{
    Serializable read();
    void save(Serializable object);   
}
