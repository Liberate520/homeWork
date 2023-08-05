package ru.geekbrains.family_tree.model.database;

/**
 * Чтение и запись данных.
 */
public interface ReadableAndWriteable {
    
    /**
     * Возвращает прочитанные данные.
     */
    Object read();

    /**
     * Записывает данные в объект.
     */
    void write(Object object);

}
