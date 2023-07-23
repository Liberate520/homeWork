package Homeworks.Family_tree.Interface;

import java.io.Serializable;

/**
 * Интерфейс, Записывание файла
 */
public interface WritingFile {

    /**
     * Метод, записать файл
     */

    boolean createSaveWriteFile(Serializable serializable, String filePath);

}
