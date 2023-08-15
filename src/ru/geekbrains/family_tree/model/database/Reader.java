package ru.geekbrains.family_tree.model.database;

/**
 * Чтение данных.
 */
public interface Reader {

    /**
     * Возвращает прочитанные данные.
     */
    Object read() throws Exception;

}
