package model.geoTree.workGeoTreeData;
import java.io.Serializable;
/**
 * Writable
 */
public interface Writable {
    /**
     * Метод для записи данных в файл 
     * @param serializable - объект для записи
     * @param filePath     - путь к файлу, в который сделать запись
     * @return
     */
    boolean write(Serializable serializable, String filePath);
    /**
     * Метод загрузки данных из файла
     * @param filePath - расположение файла
     * @return - данные в файле
     */
    Object read(String filePath);
}
