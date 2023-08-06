package ru.geekbrains.family_tree.model.database;

/**
 * Запись данных.
 */
public interface Writer {
    
    /**
     * Записывает данные в объект.
     */
    void write(Object object);

}
