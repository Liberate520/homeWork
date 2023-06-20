package model.fileManage.interfaces;

/**
 * Интерфейс, определяющий методы для сохранения и загрузки семейного древа.
 */
public interface Savable {
    /**
     * Сохраняет объект в файл.
     *
     * @param object объект для сохранения
     */
    void saveFile(Object object);

    void setFilePath(String filePath);


}