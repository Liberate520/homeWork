package io;

import java.io.IOException;

public interface DataSave<T> {
    void saveData(T t) throws IOException, ClassNotFoundException;
}
