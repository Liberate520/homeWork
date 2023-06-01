package trees;

/**
 * Интерфейс, определяющий методы для сохранения и загрузки семейного древа.
 */
public interface Conservation {
    /**
     * Сохраняет семейное древо в файл.
     *
     * @param tree семейное древо для сохранения
     */
    void saveFile(FamilyTree tree);

    /**
     * Загружает семейное древо из файла.
     *
     * @return загруженное семейное древо
     */
    FamilyTree loadFile();
}