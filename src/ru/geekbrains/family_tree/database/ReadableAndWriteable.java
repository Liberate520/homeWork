package ru.geekbrains.family_tree.database;

public interface ReadableAndWriteable {
    
    Object read();
    void write(Object object);

}
