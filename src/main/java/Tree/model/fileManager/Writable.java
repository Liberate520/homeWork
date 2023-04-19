package Tree.model.fileManager;

import java.io.Serializable;

// интерфейс работающий с сериализацией
public interface Writable {

    // методы для реализации
    void save(Serializable obj);

    Object load();
}