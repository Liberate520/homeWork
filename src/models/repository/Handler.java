package models.repository;

import java.io.Serializable;

public abstract class Handler implements CapableOfPreserving, CapableOfRestore {

    @Override
    public abstract Serializable read();

    @Override
    public abstract void save(Serializable object);   
}
