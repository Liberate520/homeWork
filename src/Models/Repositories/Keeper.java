package Models.Repositories;

import java.io.Serializable;


public interface Keeper<T extends Serializable>{
    T read();
    boolean save(T object);
}
